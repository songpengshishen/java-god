package com.wsp.java.god.serialize.mp.bean;

/**
 * 一个 copy 的普通的Java Bean
 * Create Date : 2018/06/11
 * @author wsp
 */
public class PersonClone {

    private String name;
    private int age;
    private double money;

    public PersonClone() {

    }

    public PersonClone(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PersonClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
