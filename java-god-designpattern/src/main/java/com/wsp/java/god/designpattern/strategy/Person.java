package com.wsp.java.god.designpattern.strategy;

/**
 * 策略模式的一个实体 人
 * @author
 */
public class Person {

    private int age;

    private double weight;

    private double money;

    public Person(int age, double weight, double money) {
        this.age = age;
        this.weight = weight;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", weight=" + weight +
                ", money=" + money +
                '}';
    }
}
