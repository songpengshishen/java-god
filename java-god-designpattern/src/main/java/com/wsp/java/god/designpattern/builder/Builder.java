package com.wsp.java.god.designpattern.builder;

/**
 * 构造具体产品的接口
 */
public interface Builder {

   void buildFoundation();

   void buildWall();

   void buildRoof();

   HouseProduct buildHouse();

}
