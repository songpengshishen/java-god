package com.wsp.java.god.designpattern.decorate;

/**
 * 装饰着模式测试类
 */
public class Main {
    public static void main(String[] args) {
        Girl girl = new BeautyGirlDecorate(new GeneralGirl());
        girl.dressing();
    }
}
