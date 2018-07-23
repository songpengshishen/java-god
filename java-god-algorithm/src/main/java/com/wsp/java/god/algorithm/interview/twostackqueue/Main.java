package com.wsp.java.god.algorithm.interview.twostackqueue;

import com.wsp.java.god.algorithm.interview.getminstack.GetMinStack;

/**
 * 两个栈组成一个队列测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        TwoStackQueue<Integer> stack = new TwoStackQueue<Integer>();
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(1);
        stack.add(2);
        stack.add(1);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }
}
