package ai.next.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("证书信息")
public class CertInfoDto {
    @ApiModelProperty("证书类型")
    private String certType;
    @ApiModelProperty("证书编号")
    private String certNumber;
    @ApiModelProperty("证书图片url")
    private String certUrl;
    @ApiModelProperty("证书效期开始日期")
    private Long certStartDate;
    @ApiModelProperty("证书效期结束日期")
    private Long certExpireDate;
}
