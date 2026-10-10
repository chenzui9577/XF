package cn.XF.common.protocol;

import lombok.Data;

import java.util.Map;

/**
 * <p>访问日志实体</p>
 *
 * @author cz
 **/
@Data
public class LogInfo {

    /**
     * 访客ip地址
     */
    private String ip;

    /**
     * 请求URL
     */
    private String url;

    /**
     * 请求方式
     */
    private String httpMethod;

    /**
     * 被请求接口
     */
    private String classMethod;

    /**
     * 请求参数
     */
    private Map<String, Object> parameterMap;
}
