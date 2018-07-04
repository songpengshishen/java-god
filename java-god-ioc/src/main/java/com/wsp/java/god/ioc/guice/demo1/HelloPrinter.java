package com.wsp.java.god.ioc.guice.demo1;


import com.google.inject.Singleton;

/**
 * Hello打印机
 * @author wsp
 */
@Singleton
public class HelloPrinter {

    public void print(){
        System.out.println("Hello World!");
    }


}
