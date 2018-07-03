package com.wsp.java.god.designpattern.builder;

/**
 * 地基
 */
public class Foundation {

    public Foundation(String name) {
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
        return "Foundation{" +
                "name='" + name + '\'' +
                '}';
    }
}
