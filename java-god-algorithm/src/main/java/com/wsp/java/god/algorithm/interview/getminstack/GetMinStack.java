package com.wsp.java.god.algorithm.interview.getminstack;

import java.util.Stack;

/**
 * 实现一个特殊栈,在满足基本栈的入栈,出栈外可以实现返回栈中的最小值操作.
 * 要求时间复杂度为0(1)
 *
 * 通过两个栈增加些空间复杂度来实现,一个栈保存数据的正常出入栈顺序,另一个栈用栈顶部保存最小值
 *
 * @author wsp
 */
public class GetMinStack<T extends Comparable> {

    /**
     * 数据栈
     */
    private Stack<T> stackData;

    /**
     * 存放最小值的栈
     */
    private Stack<T> stackMin;


    public GetMinStack(){
        this.stackData = new Stack<T>();
        this.stackMin = new Stack<T>();
    }


    /**
     * 入栈
     */
    public void push(T t){
        if(this.stackMin.isEmpty()){
             stackMin.push(t);
        }else if(t.compareTo(this.getMin()) <= 0){
             stackMin.push(t);
        }
        this.stackData.push(t);
    }

    /**
     * 出栈
     */
    public T pop(){
        if(this.stackData.isEmpty()){
            throw new IllegalStateException("Your stack is Empty!");
        }

        T t =  this.stackData.pop();
        //确定是否同步弹stackmin,保证最小值总是最新的
        if(t.equals(this.getMin())){
            this.stackMin.pop();
        }
        return t;
    }


    /**
     * 获取最小值
     * @return
     */
    public T getMin(){
        if(this.stackMin.isEmpty()){
            throw new IllegalStateException("Your stack is Empty!");
        }
        return this.stackMin.peek();
    }


}
