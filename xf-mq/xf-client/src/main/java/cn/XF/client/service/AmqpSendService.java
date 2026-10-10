package cn.XF.client.service;

/**
 * RabbitMQ的发送服务接口
 *
 * @author zhuwenkai
 */
public interface AmqpSendService {

    /**
     * 向RabbitMQ指定的exchange发送信息
     *
     * @param exchange   exchange
     * @param routingKey routingKey
     * @param object     object
     */
    void convertAndSend(String exchange, String routingKey, final Object object);
}
