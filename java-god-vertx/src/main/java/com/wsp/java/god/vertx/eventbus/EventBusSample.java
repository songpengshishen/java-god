package com.wsp.java.god.vertx.eventbus;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

/**
 * 简单的eventBus例子
 * @author wsp
 */
public class EventBusSample {

    public static final EventBus eb = Vertx.vertx().eventBus();

    public static void main(String[] args) throws InterruptedException {
        registerMsgHandler();
        sendMsg();
        try {
            Class<EventBusSample> clz = EventBusSample.class;
            synchronized (clz){
                clz.wait();
            }
        }catch (Exception e){
            ;
        }
    }



    static void registerMsgHandler(){
        MessageConsumer<String> msg =  eb.consumer("news.uk.sport");
        msg.handler((message)->{
            System.out.println("I have received a message : " + message.body());
        });
    }


    static void sendMsg(){
        eb.send("news.uk.sport"," Hello world Vertx EventBus!");
    }



}
