package com.wsp.java.god.vertx.tcp;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

/**
 * TCP 服务端
 * @author wangsongpeng
 */
public class TcpServer {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        NetServerOptions options = new NetServerOptions();
        options.setHost("127.0.0.1");
        options.setPort(8009);
        NetServer netServer =  vertx.createNetServer(options);
        netServer.connectHandler(socket ->{
            System.out.println("connection ok");
            socket.handler(buffer -> {
                System.out.println("I received some bytes:" + buffer.toString());
            });
        });

        netServer.listen(result -> {
            if(result.succeeded()){
                System.out.println("listen ok!");
            }else{
                System.out.println("Failed to bind! " + result.cause());
            }
        });

    }

}
