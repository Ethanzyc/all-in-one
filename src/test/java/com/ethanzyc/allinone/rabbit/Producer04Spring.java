package com.ethanzyc.allinone.rabbit;

import com.ethanzyc.allinone.config.RabbitMqConfig;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ethan
 * @date 2019/6/27 22:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer04Spring {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testEmail() {
        String msg = "这是一条消息";
        /**
         * 参数 String exchange, String routingKey, Object object
         */
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPIC_INFORM, "inform.email", msg);
    }

}
