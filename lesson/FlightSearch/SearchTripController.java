/**
 * 携程搜索
 * 1、搜索结果缓存
 * 2、并发请求，异步合并结果
 * 3、超时设置
 */

@Slf4j
@Controller
@RequestMapping("/agent-hybird/ctrip")
public class SearchTripController {
    @Autowired
    private CtripService ctripService;

    @Autowired
    private SupplierService supplierService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchTripController.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    SearchCache searchCache;
    @Autowired
    ProductMerger productMerger;
    ConcurrentHashMap<String, ReadWriteLock> lockMap = new ConcurrentHashMap<>();

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public SearchRS search(@RequestBody SearchRQ req, boolean noCache) throws InterruptedException, ExecutionException {
        //机票搜索数据先走缓存，根据查询条件先拿到缓存key，打印key值
        String key = ctripService.getCacheKey(req);
        log.info("agent-hybird.ctrip.search.redis key:" + key);


        SearchRS searchRS = null;
        try {
            searchRS = noCache ? null : searchCache.cached("search:" + key);
        } catch (Exception e) {
            log.error("search cache error", e);
        }
        if (searchRS != null) {
            log.info("agent-hybird.ctrip.search.redis key:" + key);
            return searchRS;
        }

        ExecutorService exec = new ThreadPoolExecutor(1, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        try {
            // 3 都不是，实时请求，异步合并结果
            ConcurrentHashMap<SupplierChannel, Optional<SearchRS>> searchMap = new ConcurrentHashMap();

            //获取票代商列表，我们平台DB 存票代商数据
            List<SupplierChannel> supplyListIds = supplierService.getSupplierByChannel(SearchConstant.CHANNEL_CTRIP);


            List<FutureTask> listF = new ArrayList<>();
            //并发异步请求
            for (SupplierChannel s : supplyListIds) {

                FutureTask<Pair<SupplierChannel, Optional<SearchRS>>> f = new FutureTask(new SupplierTask(s, req));
                listF.add(f);
                exec.submit(f);
            }

            for (FutureTask<Pair<SupplierChannel, Optional<SearchRS>>> t : listF) {
                try {
                    //异步超时设置8s
                    Pair<SupplierChannel, Optional<SearchRS>> s = t.get(8, TimeUnit.SECONDS);
                    searchMap.putIfAbsent(s.getKey(), s.getValue());
                } catch (Exception e) {
                    log.info(" 某个接口请求异常: ", e);
                }
            }

            // 4、合并结果
            searchRS = productMerger.merge(req, searchMap);

            // 缓存结果
            if (!CollectionUtils.isEmpty(searchRS.getFlightList())) {
                searchCache.cache("search:" + key, searchRS);
            }

        } finally {
            //直接销毁线程池
            exec.shutdownNow();
        }

        return searchRS;
    }

    /**
     *      * 多线程异步请求，合并结果
     */
    private class SupplierTask implements Callable<Pair<SupplierChannel, Optional<SearchRS>>> {
        private SupplierChannel supplierChannel;
        private SearchRQ req;

        public SupplierTask(SupplierChannel supplierChannel, SearchRQ req) {
            this.supplierChannel = supplierChannel;
            this.req = req;
        }

        @Override
        public Pair<SupplierChannel, Optional<SearchRS>> call() throws Exception {
            Pair<SupplierChannel, Optional<SearchRS>> pair = Pair.of(supplierChannel, ctripService.search(supplierChannel, req));
            return pair;
        }
    }

}
