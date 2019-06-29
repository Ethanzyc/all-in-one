package com.ethanzyc.allinone.rabbitmq;

import com.ethanzyc.allinone.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ethan
 * @date 2019/6/29 10:11
 */
@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = {RabbitMqConfig.QUEUE_INFORM_EMAIL})
    public void sendEmail(String msg, Message message, Channel channel) {
        System.out.println("msg:" + msg);
        System.out.println("message:" + message);
        System.out.println("channel:" + channel);
        System.out.println("开始处理发送邮件");
    }

}
