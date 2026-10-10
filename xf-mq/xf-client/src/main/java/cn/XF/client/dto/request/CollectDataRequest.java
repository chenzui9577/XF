package cn.XF.client.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>采集器数据汇集接收实体</p>
 *
 * @author cz
 **/
@Data
@ApiModel("采集器数据汇集接收实体")
public class CollectDataRequest {

    @NotBlank(message = "设备串号不允许为空")
    @ApiModelProperty(name = "sn", value = "设备串号", required = true)
    private String sn;

    @NotBlank(message = "采集数据不允许为空")
    @ApiModelProperty(name = "data", value = "采集数据", required = true)
    private String data;


    private Long creatTime;
}
