package com.wsp.java.god.designpattern.dutychain;

/**
 * 职责链测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        OneLevel oneLevel = new OneLevel("oneLevel");
        TwoLevel twoLevel = new TwoLevel("twoLevel");
        EndLevel endLevel = new EndLevel("endLevel");
        oneLevel.setNextLevel(twoLevel);
        twoLevel.setNextLevel(endLevel);
        Request req = new Request();
        req.setReq("hello level!");
        System.out.println(oneLevel.handler(req));
    }

}
