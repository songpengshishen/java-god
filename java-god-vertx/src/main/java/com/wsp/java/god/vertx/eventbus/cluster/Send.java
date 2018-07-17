package com.wsp.java.god.vertx.eventbus.cluster;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

/**
 * eventBus集群编程
 * 发送节点
 *
 * @author wsp
 */
public class Send {

    private static EventBus eventBus = null;

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions();
        options.setClusterManager(new HazelcastClusterManager());
        options.setClusterPort(5001);
        /**
         * 创建集群的vertx与eventbus(异步)
         */
        Vertx.clusteredVertx(options, vertxAsyncResult -> {
            if (vertxAsyncResult.succeeded()) {
                /**
                 * 创建成功,创建eventBus
                 */
                eventBus = vertxAsyncResult.result().eventBus();
                eventBus.publish("vertx.cluter","hello vertx eventBus");
            } else {
                /**
                 * 创建失败
                 */
                System.out.println("create cluster vertx failed : " + vertxAsyncResult.cause());
            }
        });

    }




}
