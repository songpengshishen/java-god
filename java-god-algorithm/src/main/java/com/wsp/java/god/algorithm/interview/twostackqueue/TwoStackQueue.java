package com.wsp.java.god.algorithm.interview.twostackqueue;

import java.util.Stack;

/**
 * 通过两个栈实现一个FIFO的队列
 *
 * 利用栈的LIFO特性将两个栈正好颠倒来实现队列,  一个栈只实现Push添加操作,一个栈进行pop出队操作出队pop时需要一次性将写入栈的所有数据导入
 *
 * @author wsp
 */
public class TwoStackQueue<T> {

    /**
     * 只push的栈
     */
    private Stack<T> stackPush;
    /**
     * 只pop的栈
     */
    private Stack<T> stackPop;

    public TwoStackQueue(){
        this.stackPush = new Stack<T>();
        this.stackPop = new Stack<T>();
    }

    public void add(T t){
        this.stackPush.push(t);
    }

    public T poll(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new IllegalStateException("Queue is Empty!");
        }else if(stackPop.empty()){
            while(!stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return stackPop.pop();
    }


    public T peek(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new IllegalStateException("Queue is Empty!");
        }else if(stackPop.empty()){
            while(!stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
