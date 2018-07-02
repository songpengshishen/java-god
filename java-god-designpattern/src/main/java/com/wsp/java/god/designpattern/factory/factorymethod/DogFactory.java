package com.wsp.java.god.designpattern.factory.factorymethod;

/**
 *  小狗工厂
 *  @author wsp
 */
public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
