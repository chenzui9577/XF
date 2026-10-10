package cn.XF.server.dto.request;

import lombok.Data;

/**
 * <p>采集器数据汇集接收实体</p>
 *
 * @author cz
 **/
@Data
public class CollectDataRequest {

    /**
     * 设备串号
     */
    private String sn;

    /**
     * 采集数据
     */
    private String data;

    /**
     * 接收时间
     */
    private Long creatTime;
}
