package com.ethanzyc.allinone.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ethan
 * @date 2019/6/27 22:58
 */
public class Producer01 {

    public static final String QUEUE01 = "helloworld";

    public static void main(String[] args) {
        // 生产者与mq建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5673);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            /**
             * String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
             * queue:队列名称
             * durable:是否持久：重启仍在
             * exclusive:是否独占连接，只在该连接中可以访问。连接关闭，队列删除
             * autoDelete:是否自动删除，独占和自动删除设为true可用于临时队列
             * arguments:设置拓展参数：比如连接时间
             */

            channel.queueDeclare(QUEUE01, true, false, false, null);

            /**
             * String exchange, String routingKey, AMQP.BasicProperties props, byte[] body
             * exchange:交换机，不指定就使用默认
             * routingKey:根据routingKey将消息转发到指定队列，默认交换机设为队列到名称
             * props:额外的参数
             * body:消息内容
             */
            String messageBody = "this is a message sent by ethan";
            channel.basicPublish("", QUEUE01, null, messageBody.getBytes());
            System.out.println("发送成功:" + messageBody);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
