package com.wsp.java.god.designpattern.builder;

/**
 * 具体的构建者
 */
public class ConcreteBuilder implements Builder{

    private HouseProduct houseProduct;

    public ConcreteBuilder(){
        houseProduct = new HouseProduct();
    }

    @Override
    public void buildFoundation() {
        houseProduct.setFoundation(new Foundation("地基"));
    }

    @Override
    public void buildWall() {
        houseProduct.setWall(new Wall("白墙"));
    }

    @Override
    public void buildRoof() {
        houseProduct.setRoof(new Roof("楼顶"));
    }

    @Override
    public HouseProduct buildHouse() {
      return houseProduct;
    }
}
