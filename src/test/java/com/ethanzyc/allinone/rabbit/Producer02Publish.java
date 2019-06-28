package com.ethanzyc.allinone.rabbit;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ethan
 * @date 2019/6/27 22:58
 */
public class Producer02Publish {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

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

            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);
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
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_FANOUT_INFORM, "");

            /**
             * String exchange, String routingKey, AMQP.BasicProperties props, byte[] body
             * exchange:交换机，不指定就使用默认
             * routingKey:根据routingKey将消息转发到指定队列，默认交换机设为队列到名称
             * props:额外的参数
             * body:消息内容
             */
            for (int i = 0; i < 10; i++) {
                String messageBody = "this is a message";
                channel.basicPublish(EXCHANGE_FANOUT_INFORM, "", null, messageBody.getBytes());
                System.out.println("发送成功:" + messageBody);
            }
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
