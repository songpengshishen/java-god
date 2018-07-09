package com.wsp.java.god.designpattern.strategy;

/**
 * 按金钱进行比较
 * @author wsp
 */
public class CompareMoneyStrategy implements CompareStrategy{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getMoney()>p2.getMoney() ? 1 :(p1.getMoney()==p2.getMoney()) ? 0 : -1 ;
    }
}
