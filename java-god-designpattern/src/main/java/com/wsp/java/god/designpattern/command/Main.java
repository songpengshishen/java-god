package com.wsp.java.god.designpattern.command;

/**
 * 命令模式测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        Command com = new CommandImpl(new Receiver());
        Invoker in = new Invoker(com);
        in.send();
    }

}
