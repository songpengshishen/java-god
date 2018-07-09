package com.wsp.java.god.designpattern.strategy;

/**
 * 策略模式测试类
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        Person p1 = new Person(1,2,3);
        Person p2 = new Person(2,3,4);
        System.out.println(new CompareAgeStrategy().compare(p1,p2));
        System.out.println(new CompareMoneyStrategy().compare(p1,p2));
        System.out.println(new CompareWeightStrategy().compare(p1,p2));
    }

}
