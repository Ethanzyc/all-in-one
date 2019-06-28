package com.ethanzyc.allinone.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ethan
 * @date 2019/6/27 23:30
 */
public class Consumer01 {

    public static final String QUEUE01 = "helloworld";

    public static void main(String[] args) {
        // 消费者与mq建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5673);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE01, true, false, false, null);

            DefaultConsumer consumer = new DefaultConsumer(channel) {
                // 当接受到消息，此方法会被调用

                /**
                 *
                 * @param consumerTag 消费者标签，用来标识消费者，在监听队列到时候可设置
                 * @param envelope 信封
                 * @param properties
                 * @param body
                 * @throws IOException
                 */
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    // 交换机
                    String exchange = envelope.getExchange();
                    System.out.println("exchange:" + exchange);
                    // 消息id，用来标识消息，保证消息送达
                    long deliveryTag = envelope.getDeliveryTag();
                    System.out.println("deliveryTag:" + deliveryTag);
                    String s = new String(body, "utf-8");
                    System.out.println("收到的消息" + s);
                }
            };


            String basicConsume = channel.basicConsume(QUEUE01, false, consumer);
            System.out.println("basicConsume:" + basicConsume);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
