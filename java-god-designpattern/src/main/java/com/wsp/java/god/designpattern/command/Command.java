package com.wsp.java.god.designpattern.command;

/**
 * 命令模式中命令接口,抽象出命令实体概念将发送者和接收着解耦.
 * @author wsp
 */
public interface Command {

    void execute();
}
