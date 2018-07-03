package com.wsp.java.god.designpattern.observer;

/**
 * 主题(被观察者)
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
