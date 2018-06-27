package com.wsp.java.god.datastruct.list;
import java.util.Iterator;

/**
 * 自定义栈(LIFO)的实现
 * <h3>使用ArrayList动态(扩容,缩容)数组来实现栈,添加和删除使用Arraylist的方法以及使用该类的成员变量</h3>
 * <h3>topOfStack是栈内部关键的成员变量</h3>
 * </br>
 * @author wangsongpeng
 * @see MyArrayList
 * @see java.util.ArrayList
 * @see java.util.List
 * @since 2017/01/18
 */
public class MyStack<T> extends MyArrayList<T>{


    private int topOfStack = -1;//栈顶指针,用来指向栈顶(表尾)是栈进行操作的索引位置


    public MyStack(){
          this.topOfStack = -1;
    }

    /**
     * 添加元素到栈顶中
     * push:进栈,压栈
     * <h3>每次进栈时,栈顶指针topOfStack加1,把待进栈的元素放入到theItems[topOfStack]中</h3>
     * @param t 数据元素
     */
    public void push(T t){
        add(++topOfStack,t);
    }

    /**
     * 在栈顶删除元素
     * pop:出栈,弹栈
     * <h3>出栈时,我们直接返回theItems[topOfStack]并且把topOfStack减1</h3>
     */
    public synchronized  T  pop(){
       return remove(topOfStack--);
    }

    /**
     * 清空并初始化当前栈
     */
    public void clear(){
        super.clear();
        this.topOfStack = -1;
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }




}
