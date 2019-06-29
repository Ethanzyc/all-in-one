package com.ethanzyc.allinone.rabbitmq;

import com.ethanzyc.allinone.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbitmq消费者
 * 只要在对应的方法上加 @RabbitListener 注解
 *
 * 生产者代码在 com.ethanzyc.allinone.rabbit.Producer05Spring 中
 * 配置在 com.ethanzyc.allinone.config.RabbitMqConfig 中
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
