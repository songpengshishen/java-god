package com.wsp.java.god.ioc.guice.demo1;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;


/**
 * 一个例子
 * @author wsp
 */
@Singleton
public class Sample {
    @Inject
    private HelloPrinter helloPrinter;

    public void hello(){
        helloPrinter.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample sample =  injector.getInstance(Sample.class);
        sample.hello();
    }
}
