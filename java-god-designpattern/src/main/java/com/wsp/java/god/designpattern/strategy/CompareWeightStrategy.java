package com.wsp.java.god.designpattern.strategy;

/**
 * 按体重进行比较
 * @author wsp
 */
public class CompareWeightStrategy implements CompareStrategy{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getWeight()>p2.getWeight() ? 1 :(p1.getAge()==p2.getWeight()) ? 0 : -1 ;
    }
}
