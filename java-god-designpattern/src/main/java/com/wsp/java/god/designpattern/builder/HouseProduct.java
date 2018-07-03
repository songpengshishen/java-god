package com.wsp.java.god.designpattern.builder;

/**
 * 住宅产品
 *
 */
public class HouseProduct {

   private Foundation foundation;

   private Wall wall;

   private Roof roof;

    public Foundation getFoundation() {
        return foundation;
    }

    public void setFoundation(Foundation foundation) {
        this.foundation = foundation;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "HouseProduct{" +
                "foundation=" + foundation +
                ", wall=" + wall +
                ", roof=" + roof +
                '}';
    }
}
