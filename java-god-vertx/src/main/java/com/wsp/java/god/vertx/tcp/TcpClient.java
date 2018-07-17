package com.wsp.java.god.vertx.tcp;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;

/**
 * TCP客户端
 * @author wangsongpeng
 */
public class TcpClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        NetClientOptions options = new NetClientOptions();
        options.setConnectTimeout(3000);
        options.setReconnectAttempts(3);
        options.setReconnectInterval(1000);
        NetClient tcpClient =  vertx.createNetClient(options);
        tcpClient.connect(8009,"127.0.0.1",result -> {
              if(result.succeeded()){
                  System.out.println("Connected!");
                  NetSocket netSocket =  result.result();
                  netSocket.write("hello vertx Server");
              }else{
                  System.out.println("connected faild " + result.cause());
              }
        });

    }

}
