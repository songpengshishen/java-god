package com.wsp.java.god.designpattern.strategy;

/**
 * 按年龄进行比较
 * @author wsp
 */
public class CompareAgeStrategy implements CompareStrategy{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge()>p2.getAge() ? 1 :(p1.getAge()==p2.getAge()) ? 0 : -1 ;
    }
}
