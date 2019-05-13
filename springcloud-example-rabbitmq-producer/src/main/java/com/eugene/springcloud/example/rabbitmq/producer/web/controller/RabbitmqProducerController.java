package com.eugene.springcloud.example.rabbitmq.producer.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "通过消息队列发送消息")
@RestController
@RequestMapping("/rabbitmqs")
public class RabbitmqProducerController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ApiOperation(value = "发送一个普通的消息", notes = "通过RabbitMQ发送一个普通的文本消息")
    @PostMapping(value = "/new/{message}")
    public Map<String, Object> create(@PathVariable("message") String message) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 1; i <= 3000; i++) {
            this.amqpTemplate.convertAndSend("message", message);
        }
        result.put("code", 200);
        return result;
    }

    @ApiOperation(value = "发送一个交换机的普通消息", notes = "通过RabbitMQ的交换机发送一个普通的文本消息")
    @GetMapping(value = "/new/{message}/exchange")
    public Map<String, Object> exchange(@PathVariable("message") String message) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            // 消息会同时被topic.message和topic.messages队列消费，因为topic.message同时满足routingKey：topic.message和topic.#
            this.amqpTemplate.convertAndSend("eugene.exchange", "topic.message", i + ": " + message);
        }
        result.put("code", 200);
        return result;
    }

    @ApiOperation(value = "发送一个通配交换机的普通消息", notes = "通过RabbitMQ的交换机发送一个普通的文本消息")
    @GetMapping(value = "/new/{message}/exchanges")
    public Map<String, Object> exchanges(@PathVariable("message") String message) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            // 消息仅会被topic.messages队列消费，因为topic.eugene仅满足routingKey：topic.#
            this.amqpTemplate.convertAndSend("eugene.exchange", "topic.eugene", i + ": " + message);
        }
        result.put("code", 200);
        return result;
    }

    @ApiOperation(value = "发送一个Fanout交换机的普通消息", notes = "通过RabbitMQ的Fanout交换机发送一个普通的文本消息")
    @GetMapping(value = "/new/{message}/fanout")
    public Map<String, Object> fanoutExchanges(@PathVariable("message") String message) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            /*
             * 1: 消息会同时被fanout.a和fanout.b队列消费，因为eugene.fanout.exchange路由同时绑定了fanout.a和fanout.b队列。
             * 2: routingKey参数可以随便写，因为fanout路由模式的routingKey没有任何意义
             */
            this.amqpTemplate.convertAndSend("eugene.fanout.exchange", null, i + ": " + message);
        }
        result.put("code", 200);
        return result;
    }
}
