package com.wsp.java.god.designpattern.factory.factorymethod;

/**
 * 工厂方法模式测试类
 */
public class Main {

    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.createAnimal().action();
        AnimalFactory catFactory = new CatFactory();
        catFactory.createAnimal().action();

    }
}
