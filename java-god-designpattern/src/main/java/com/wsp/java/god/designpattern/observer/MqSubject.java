package com.wsp.java.god.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Mq主题
 */
public class MqSubject implements Subject{


    private List<Observer> observers;

    public MqSubject(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach((Observer o)->{
            o.updateMessage("haha");
        });
    }

}
