package com.wsp.java.god.designpattern.builder;

/**
 * 屋顶
 */
public class Roof {

    public Roof(String name) {
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
        return "Roof{" +
                "name='" + name + '\'' +
                '}';
    }
}
