package com.wsp.java.god.vertx.eventbus.cluster;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

/**
 * eventBus集群编程
 * 消费节点
 *
 * @author wsp
 */
public class ConsumerB {

    private static EventBus eventBus = null;

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions();
        options.setClusterManager(new HazelcastClusterManager());
        options.setClusterPort(5003);
        /**
         * 创建集群的vertx与eventbus(异步)
         */
        Vertx.clusteredVertx(options, vertxAsyncResult -> {
            if (vertxAsyncResult.succeeded()) {
                /**
                 * 创建成功,创建eventBus
                 */
                eventBus = vertxAsyncResult.result().eventBus();
                /**
                 * 指定消费的事件地址
                 */
                MessageConsumer<String> consumer = eventBus.consumer("vertx.cluter");
                /**
                 * 当有事件消息传送过来时,执行此handler
                 */
                consumer.handler(message->{
                    System.out.println("I received message : " + message.body());
                });

                /**
                 * 当有事件消息抛出异常时,执行此handler
                 */
                consumer.exceptionHandler(ex->{
                    System.out.println("I received message  faield: " + ex);
                });
            } else {
                /**
                 * 创建失败
                 */
                System.out.println("create cluster vertx failed : " + vertxAsyncResult.cause());
            }
        });

    }


}
