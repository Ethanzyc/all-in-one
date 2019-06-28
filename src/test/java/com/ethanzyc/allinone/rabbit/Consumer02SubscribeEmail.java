package com.ethanzyc.allinone.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ethan
 * @date 2019/6/27 23:30
 */
public class Consumer02SubscribeEmail {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

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

            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            /**
             * String exchange, String type
             * exchange:名称
             * type:交换机类型，
             *  fanout:对应rabbit的工作模式是 publish/subscribe
             *  direct:对应rabbit的工作模式是 routing
             *  topic: 对应rabbit的工作模式是 topics
             *  headers: 对应rabbit的工作模式是 headers
             */
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);

            // 交换机和队列进行绑定
            /**
             * String queue, String exchange, String routingKey
             * queue: 队列名称
             * exchange: 交换机名称
             * routingKey: 路由key，作用是交换机根据路由key的值将消息转发到指定到队列中，在发布订阅中协调为空字符串
             */
            channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_FANOUT_INFORM, "");

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


            String basicConsume = channel.basicConsume(QUEUE_INFORM_EMAIL, true, consumer);
            System.out.println("basicConsume:" + basicConsume);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
