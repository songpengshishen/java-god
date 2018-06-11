package com.wsp.java.god.serialize.mp.bean;

/**
 * 一个 copy 的普通的Java Bean 字段顺序错误 msgpack序列化会有问题
 * Create Date : 2018/06/11
 * @author wsp
 */
public class PersonFieldOrderError {

    private String name;
    private int age;
    private double money;
    private Double money1 = 0.0;


    public PersonFieldOrderError(String name, int age, double money) {
        this(name,age,money,null);
    }

    public PersonFieldOrderError(String name, int age, double money, Double money1) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.money1 = money1;
    }

    public PersonFieldOrderError() {
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

    public Double getMoney1() {
        return money1;
    }

    public void setMoney1(Double money1) {
        this.money1 = money1;
    }

    @Override
    public String toString() {
        return "PersonFieldOrderError{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", money1=" + money1 +
                '}';
    }
}
