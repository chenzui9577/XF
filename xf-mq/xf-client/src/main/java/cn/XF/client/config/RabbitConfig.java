package cn.XF.client.config;

import lombok.Data;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 的连接配置
 *
 * @author cz
 **/
@Data
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String addresses;
    @Value("${spring.rabbitmq.port}")
    private Integer port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;
    @Value("${spring.rabbitmq.publisher-returns}")
    private boolean publisherReturns;

    @Value("${spring.rabbitmq.listener.simple.acknowledge-mode}")
    private String simpleAcknowledgeMode;
    @Value("${spring.rabbitmq.listener.simple.concurrency}")
    private String simpleConcurrency;
    @Value("${spring.rabbitmq.listener.simple.max-concurrency}")
    private String simpleMaxConcurrency;


    public RabbitConfig() {
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(this.addresses);
        connectionFactory.setPort(this.port);
        connectionFactory.setUsername(this.username);
        connectionFactory.setPassword(this.password);
        connectionFactory.setVirtualHost(this.virtualHost);
        connectionFactory.setPublisherConfirms(this.publisherConfirms);
        connectionFactory.setPublisherReturns(this.publisherReturns);
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 采用RabbitTemplate模版
     * <p>
     * Spring AMQP提供了一个发送和接收消息的操作模板类AmqpTemplate。
     * AmqpTemplate它定义包含了发送和接收消息等的一些基本的操作功能。
     * RabbitTemplate是AmqpTemplate的一个实现。
     * <p>
     * RabbitTemplate支持消息的确认与返回，为了返回消息RabbitTemplate需要设置mandatory 属性为true,并且CachingConnectionFactory 的publisherReturns属性也需要设置为true。
     * 返回的消息会根据它注册的RabbitTemplate.ReturnCallback setReturnCallback 回调发送到给客户端。
     * <p>
     * 注意：一个RabbitTemplate仅能支持一个ReturnCallback。
     * <p>
     * 为了确认Confirms消息, CachingConnectionFactory 的publisherConfirms 属性也需要设置为true，确认的消息会根据它注册的RabbitTemplate.ConfirmCallback setConfirmCallback回调发送到给客户端。
     * 注意：一个RabbitTemplate也仅能支持一个ConfirmCallback.
     *
     * @return RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
