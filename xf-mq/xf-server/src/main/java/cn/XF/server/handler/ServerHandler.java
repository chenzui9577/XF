package cn.XF.server.handler;

import cn.XF.server.dto.request.CollectDataRequest;
import cn.XF.server.entity.Engistates;
import cn.XF.server.service.DataService;
import cn.XF.server.service.EngistatesService;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.XF.server.constant.MqConstant.COLLECT_DATA_EXCHANGE;
import static cn.XF.server.constant.MqConstant.COLLECT_DATA_QUEUE;

/**
 * <p>队列数据加载</p>
 *
 * @author cz
 **/
@Component
public class ServerHandler {
    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);


    @Resource
    private DataService dataService;
    @Resource
    private EngistatesService engistatesService;

    /**
     * 接收队列内的采集数据
     *
     * @param recordByte 队列接收消息
     * @param channel    通道
     * @param headers    请求头部
     * @throws IOException 异常
     */
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = COLLECT_DATA_QUEUE, durable = "true"), exchange = @Exchange(name = COLLECT_DATA_EXCHANGE)))
    public void receiveDataRecord(@Payload(required = false) byte[] recordByte, Channel channel, @Headers Map<String, Object> headers) throws IOException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            String recordStr = new String(recordByte);
            String jsonParse = JSON.parse(recordStr).toString();
            logger.info("RMQ接收到的记录数据：{}", jsonParse);
            CollectDataRequest dataRequest = JSON.parseObject(jsonParse, CollectDataRequest.class);
            List<Engistates> engistatesList = dataService.analyseData(dataRequest);
            if (!CollectionUtil.isEmpty(engistatesList)) {
                //数据不为空时，插入数据库
                engistatesService.saveBatch(engistatesList);
            }
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            logger.error("RMQ接收记录数据异常：", e);
            channel.basicAck(deliveryTag, false);
        }
    }

}
