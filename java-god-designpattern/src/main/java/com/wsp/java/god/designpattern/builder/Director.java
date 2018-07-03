package com.wsp.java.god.designpattern.builder;

/**
 * 建造者
 */
public class Director {

    public static HouseProduct builderHouseProduct(Builder builder){
        builder.buildFoundation();
        builder.buildWall();
        builder.buildRoof();
        return builder.buildHouse();
    }

}
