
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class SearchRQ implements Serializable {
    public static String TRIP_TYPE_SINGLE = "1";
    public static String TRIP_TYPE_BACK = "2";
    /**
     * 接口身份标识用户名（渠道唯一标识）
     */
    @NotNull
    String cid;

    /**
     * 行程类型，1. 单程 2 往返 3 多程 4 往返中推荐多程 （3和4目前仅Qunar需要）
     */
    @NotNull
    @Range(min = 1, max = 3, message = "行程类型，1. 单程 2 往返 3 多程 4 往返中推荐多程 （3和4目前仅Qunar需要）")
    String tripType;

    /**
     * 出发地城市 IATA 三字码代码 【注意请求的是城市不是机 场】
     * (Qunar支持多程，按照BJS/HKG, HKG/SHA格式请求， 第一程为北京-香港，第二程为香港-上海）
     */
    @NotNull
    @Length(min = 3, max = 3)
    String fromCity;

    /**
     * 目的地城市 IATA 三字码代码【注意请求的是城市不是机场】
     */
    @NotNull
    @Length(min = 3, max = 3)
    String toCity;

    /**
     * 出发日期，格式为 YYYYMMDD
     * (如果为多程，按照 20130729，20130804 的方式传输数据)
     */
    @NotNull
    String fromDate;

    /**
     * 回程日期，格式为 YYYYMMDD(留空表示单程/多程)
     */
    String retDate;

    /**
     * 成人人数，1-9，供应商请按照实际请求出行人数返回相关
     * 运价数据【特别注意:查询请求是带人数的】
     */
    @NotNull
    int adultNumber;

    /**
     * 儿童人数，0-9(新上线供应商默认只开放成人，不开放多 乘客类型)
     */
    @NotNull
    int childNumber;

    /**
     * 婴儿人数，0-9
     */
    @NotNull
    int infantNumber;

    /**
     * 搜索请求渠道来源;
     * F:FlightIntlOnline;
     * M:Mobile ;
     * E:EnglishSite; K:积分票(对于积分票的查询请求，查询返回报文的 productType 务必赋值为 JFP，否则过滤)
     */
    @NotNull
    String channel;

    /**
     * 标识供应商查询返回报文是否需要压缩 1) 默认不压缩;如果为 T，压缩编码; 2)若需要压缩，请联系我们处理。
     */
    String isCompressEncode;

    /**
     * 主渠道，如 FlightIntlOnline/ Mobile/ EnglishSite 等
     */
    @NotNull
    String mainChannel;

    /**
     * 子渠道号
     */
    @NotNull
    String subChannelID;

    /**
     * 请求来源，0标识请求来源于Ctrip； 1标识请求来源于Qunar
     */
    int source;

    /**
     * 市场渠道，需要的供应商可以识别该渠道
     */
    String market;

    @Override
    public int hashCode() {
        return Objects.hash(cid, tripType, fromCity, toCity, fromDate, retDate, adultNumber, childNumber, infantNumber, channel, isCompressEncode, mainChannel, subChannelID, source, market);
    }
}
