package com.wsp.java.god.algorithm.interview.reverseStack;

import java.util.Stack;

/**
 * 递归逆序栈,只能使用递归函数不能使用其他数据结构,并且只能用当前栈
 * 循环栈从栈顶拿元素一个一个向栈中存,注意每次取栈顶都需要传入一个递归次数这个次数决定当前的栈顶是那个
 * @author wsp
 */
public class RecursionReverseStack<T> {


    public Stack<T> reverseStack(Stack<T> stack) {
        int size = stack.size();
        T pushElement = null;
        for (int i = 0; i < size; i++) {
            pushElement = getAndPopIndexElement(stack, i);
            stack.push(pushElement);
        }

        return stack;
    }


    public T getAndPopIndexElement(Stack<T> stack,int count){
           T top = stack.pop();
           if(count == 0){
               return top;
           }
           T t1 = getAndPopIndexElement(stack,count-1);
           stack.push(top);
           return t1;
    }


}
