package cn.XF.client.service.impl;

import cn.XF.client.service.AmqpSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送队列的业务实现类（生产者确认涉及到两个回调函数一个叫 ConfirmCallback ，一个叫 RetrunCallback）
 *
 * @author zhuwenkai
 */
@Service
public class AmqpSendServiceImpl implements AmqpSendService, RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(AmqpSendServiceImpl.class);


    private @Autowired
    RabbitTemplate amqpTemplate;


    /**
     * Confirmation callback.
     *
     * @param correlationData correlation data for the callback.
     * @param ack             true for ack, false for nack
     * @param cause           An optional cause, for nack, when available, otherwise null.
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            logger.error("消息发送失败:{}", cause);
        } else {
            logger.info("消息发送成功");
        }
    }


    /**
     * Returned message callback.
     *
     * @param message    the returned message.
     * @param replyCode  the reply code.
     * @param replyText  the reply text.
     * @param exchange   the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info("消息主体 message : " + message);
        logger.info("消息主体 message : " + replyCode);
        logger.info("描述：" + replyText);
        logger.info("消息使用的交换器 exchange : " + exchange);
        logger.info("消息使用的路由键 routing : " + routingKey);
    }


    /**
     * 向RabbitMQ指定的exchange发送信息
     *
     * @param exchange   exchange
     * @param routingKey routingKey
     * @param object     object
     */
    @Override
    public void convertAndSend(String exchange, String routingKey, final Object object) {
        this.amqpTemplate.setReturnCallback(this);
        this.amqpTemplate.setConfirmCallback(this);
        this.amqpTemplate.convertAndSend(exchange, routingKey, object);
    }
}
