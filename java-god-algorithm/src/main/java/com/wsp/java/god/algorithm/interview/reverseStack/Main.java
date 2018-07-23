package com.wsp.java.god.algorithm.interview.reverseStack;


import java.util.Stack;

/**
 * 递归逆序栈
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        RecursionReverseStack<Integer> recursionReverseStack = new RecursionReverseStack<>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        recursionReverseStack.reverseStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
