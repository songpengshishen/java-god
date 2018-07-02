package com.wsp.java.god.designpattern.facede;

/**
 * 门面模式
 * @author wsp
 */
public class Facede {

    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facede(){
          serviceA = new ServiceA();
          serviceB = new ServiceB();
          serviceC = new ServiceC();
    }

    public void service(){
        serviceA.serviceA();
        serviceB.serviceB();
        serviceC.serviceC();
    }
}
