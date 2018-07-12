package com.wsp.java.god.designpattern.command;

/**
 * 命令模式的发送者
 * @author wsp
 */
public class Invoker {


    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }


    public void send(){
        command.execute();
    }
}
