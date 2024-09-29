/**
 *
 * @author jiangzhiwei
 * @date 2023/02/14
 * @parms supplierChannel 票代理商对应OTA渠道的配置信息
 */
public interface CtripService {

  

	/**
	 * 从Redis缓存中获取Key
	 * @param searchRQ
	 * @return
	 */
	public String getCacheKey(SearchRQ searchRQ);

}
