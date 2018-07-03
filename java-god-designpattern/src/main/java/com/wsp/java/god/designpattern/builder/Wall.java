package com.wsp.java.god.designpattern.builder;

/**
 * 墙
 */
public class Wall {

    public Wall(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "name='" + name + '\'' +
                '}';
    }
}
