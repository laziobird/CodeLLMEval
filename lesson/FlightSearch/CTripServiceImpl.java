/**
 * 投放携程的Search API
 *
 */
@Slf4j
@Service
public class CTripServiceImpl implements CtripService {

    @Override
    public String getCacheKey(SearchRQ searchRQ){
        String key = searchRQ.getFromCity() + ":" +
                searchRQ.getToCity() + ":" +
                searchRQ.getFromDate() + ":" +
                searchRQ.getTripType();
        //单程和往返的key 不一样
        if(Objects.equals(searchRQ.getTripType(), SearchRQ.TRIP_TYPE_BACK)){
            key = key + ":" + searchRQ.getRetDate();
        }
        return key;
    }


}
