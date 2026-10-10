package cn.XF.server.constant;

/**
 * <p>RabbitMQ队列定义</p>
 *
 * @author cz
 **/
public class MqConstant {

    /**
     * 消防信息采集数据汇总的MQ交换机名称
     */
    public static final String COLLECT_DATA_EXCHANGE = "xf_collect_data_exchange";

    /**
     * 消防信息采集数据汇总的MQ队列名称
     */
    public static final String COLLECT_DATA_QUEUE = "xf_collect_data_queue";

}
