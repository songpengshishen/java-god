package com.wsp.java.god.vertx.http;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;

/**
 * Http客户端
 *
 * @author wsp
 */
public class MyHttpClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();/*创建一个vertx实例对象*/
        HttpClientOptions options = new HttpClientOptions();/*创建一个httpClient配置对象*/
        options.setDefaultHost("myhost.com");
        options.setDefaultPort(8080);
        HttpClient client = vertx.createHttpClient(options);/*创建httpclient对象*/
        /**
         * 设置一个post请求的请求体
         */
        String body = "{'name':'vertx'}";

        /**
         * 发送一个异步的post请求,当请求被服务端接受并响应时执行responseHandler
         */
        HttpClientRequest request = client.post("/index.html", response -> {
            /**
             * 接受的响应码
             */
            System.out.println("I received Server Response Status: " + response.statusCode());
            /**
             * 接受的响应头
             */
            System.out.println("I received Server Response Header: " + response.headers().entries());
            /**
             * 接受了所有的响应body后执行此handler
             */
            response.bodyHandler(buffer -> {
                System.out.println("I received Server Response body: " + buffer.toString());
                client.close();
            });

            /**
             * response异常时执行此handler
             */
            response.exceptionHandler(ex->{
                System.out.println("response failed : "+ex);
            });

        });
        /**
         * 真正发起请求,填写头部和body
         */
        request.putHeader("Content-Length",String.valueOf(body.length())).write(body).end();


    }
}
