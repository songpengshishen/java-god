package com.wsp.java.god.algorithm.interview.getminstack;

/**
 * getMinStacks测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        GetMinStack<Integer> stack = new GetMinStack<Integer>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
