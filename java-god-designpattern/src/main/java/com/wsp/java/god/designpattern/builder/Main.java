package com.wsp.java.god.designpattern.builder;

/**
 * 构建者测试类
 */
public class Main {

    public static void main(String[] args) {
      HouseProduct product =  Director.builderHouseProduct(new ConcreteBuilder());
      System.out.println(product);
    }

}
