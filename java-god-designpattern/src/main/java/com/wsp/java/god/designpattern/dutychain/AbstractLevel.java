package com.wsp.java.god.designpattern.dutychain;

/**
 * 职责链中的抽象类
 * @author wsp
 */
public abstract class AbstractLevel implements Level{


    protected Level nextLevel;

    protected String name;

    public AbstractLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }
}
