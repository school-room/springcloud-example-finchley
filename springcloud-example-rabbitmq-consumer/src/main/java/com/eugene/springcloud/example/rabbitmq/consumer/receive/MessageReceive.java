package com.eugene.springcloud.example.rabbitmq.consumer.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceive {

    @RabbitListener(queues = "message")
    public void receive(String message) {
        log.info("从RabbitMQ的message队列获取消息:" + message);
    }

    @RabbitListener(queues = "topic.message")
    public void receiveExchange(String message) {
        log.info("从RabbitMQ的topic.message队列获取消息:" + message);
    }

    @RabbitListener(queues = "topic.messages")
    public void receiveExchanges(String message) {
        log.info("从RabbitMQ的topic.messages队列获取消息:" + message);
    }

    @RabbitListener(queues = "fanout.a")
    public void receiveFanoutAExchanges(String message) {
        log.info("从RabbitMQ的fanout.a队列获取消息:" + message);
    }

    @RabbitListener(queues = "fanout.b")
    public void receiveFanoutBExchanges(String message) {
        log.info("从RabbitMQ的fanout.b队列获取消息:" + message);
    }
}
