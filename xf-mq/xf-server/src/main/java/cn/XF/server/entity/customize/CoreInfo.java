package cn.XF.server.entity.customize;

import lombok.Data;

/**
 * <p>信息采集的核心信息</p>
 *
 * @author cz
 **/
@Data
public class CoreInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 部件状态
     */
    private String state;
}
