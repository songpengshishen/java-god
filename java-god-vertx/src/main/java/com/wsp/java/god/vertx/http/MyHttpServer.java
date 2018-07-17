package com.wsp.java.god.vertx.http;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;

/**
 * Http服务器
 *
 * @author wsp
 */
public class MyHttpServer {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();/*创建vertx实例*/
        HttpServerOptions options = new HttpServerOptions();/*创建HttpServer服务器配置*/
        options.setHost("myhost.com");
        options.setPort(8080);
        HttpServer server = vertx.createHttpServer(options);/*创建Http服务器*/
        /**
         * 当有客户端连接被接受时执行connectionHandler
         */
        server.connectionHandler(connection -> {
            /**
             * 当连接异常时执行exceptionHandler
             */
            connection.exceptionHandler(ex -> {
                System.out.println("connection faild " + ex);
            });

            System.out.println("connection into " + connection.remoteAddress());
        });
        /**
         * 当有客户端请求(request)达到时执行requestHandler
         */
        server.requestHandler(request -> {

            /**
             * 接受的请求行
             */
            System.out.println("I received some request :" + request.absoluteURI());

            /**
             * 接受的请求头
             */
            System.out.println("I received some request Header:" + request.headers().entries());

            /**
             * 接受的请求体body,bodyHandler会一次性接受完所有body在触发此方法
             */
            request.bodyHandler(buffer -> {
                System.out.println("I received some request body:" + buffer.toString());

                HttpServerResponse response = request.response();
                response.setStatusCode(HttpResponseStatus.OK.code());
                response.putHeader("header-custome", "wsp");
                response.putHeader("Content-Length", String.valueOf(request.uri().length()));
                response.write(request.uri());
                response.end();
            });
            /**
             * 当请求发生异常时触发
             */
            request.exceptionHandler(ex -> {
                System.out.println("request failed : " + ex);
            });

        });
        /**
         * 当HttpServer发生异常时执行exceptionHandler
         */
        server.exceptionHandler(ex -> {
            System.out.println("server failed : " + ex);
            server.close();
        });



        /**
         * server绑定myhost.com和8080端口
         */
        server.listen(result -> {
            if (result.succeeded()) {
                System.out.println("started HttpServer Success!");
            } else {
                System.out.println("started HttpServer failed!" + result.cause());
            }
        });
    }
}
