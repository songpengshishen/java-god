package com.wsp.java.god.designpattern.factory.factorymethod;

/**
 * Created by wangsongpeng on 2018/6/30.
 */
public class Main {

    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.createAnimal().action();
        AnimalFactory catFactory = new CatFactory();
        catFactory.createAnimal().action();

    }
}
