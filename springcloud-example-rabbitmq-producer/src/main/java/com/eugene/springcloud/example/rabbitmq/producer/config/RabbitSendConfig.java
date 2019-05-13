package com.eugene.springcloud.example.rabbitmq.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitSendConfig {

    /**
     * 创建一个名字是message的消息队列
     * @return 返回一个Queue对象
     */
    @Bean
    public Queue messageQueue() {
        return new Queue("message");
    }

    /**
     * 创建一个名字是topic.message的消息队列，单个路由队列
     * @return 返回一个Queue对象
     */
    @Bean(name = "message")
    public Queue topicMessageQueue() {
        return new Queue("topic.message");
    }

    /**
     * 创建一个名字是topic.messages的消息队列，一组路由消息队列
     * @return 返回一个Queue对象
     */
    @Bean(name = "messages")
    public Queue topicMessagesQueue() {
        return new Queue("topic.messages");
    }

    /**
     * 创建一个名字是fanout.a的消息队列，可以与多个交换机绑定
     * @return 返回一个Queue对象
     */
    @Bean(name = "fanoutA")
    public Queue fanoutAMessagesQueue() {
        return new Queue("fanout.a");
    }

    /**
     * 创建一个名字是fanout.b的消息队列，可以与多个交换机绑定
     * @return 返回一个Queue对象
     */
    @Bean(name = "fanoutB")
    public Queue fanoutBMessagesQueue() {
        return new Queue("fanout.b");
    }

    /**
     * 创建一个名字是eugene.exchange的消息订阅交换机
     * @return 返回消息订阅TopicExchange对象
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("eugene.exchange");
    }

    /**
     * 创建一个名字是eugene.fanout.exchange的消息交换机，同于同时向多个队列发送消息
     * @return 返回消息FanoutExchange对象
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("eugene.fanout.exchange");
    }

    /**
     * 绑定消息到交换机上，需要匹配topic.message
     * @param queue 目标队列
     * @param exchange 目标交换机
     * @return Binding对象
     */
    @Bean
    public Binding bindingExchangeMessage(@Qualifier("message") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.message");
    }


    /**
     * 绑定消息到交换机上，需要匹配topic.message
     * @param queue 目标队列
     * @param exchange 目标交换机
     * @return Binding对象
     */
    @Bean
    public Binding bindingExchangeMessages(@Qualifier("messages") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.#");
    }

    /**
     * 绑定消息队列fanout.a到交换机eugene.fanout.exchange上
     * @param queue 目标队列
     * @param exchange 目标交换机
     * @return Binding对象
     */
    @Bean
    public Binding bindingExchangeFanoutA(@Qualifier("fanoutA") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    /**
     * 绑定消息队列fanout.b到交换机eugene.fanout.exchange上
     * @param queue 目标队列
     * @param exchange 目标交换机
     * @return Binding对象
     */
    @Bean
    public Binding bindingExchangeFanoutB(@Qualifier("fanoutB") Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
}
