package com.wsp.java.god.datastruct.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 自定义队列(FIFO)实现
 * <h1>循环队列</h1>
 * <h3>不能使用Arraylist,因为Arraylist是动态数组的实现,从表头部出队(删除)时,会移动数据</h3>
 * <h3>定义一个内部数组和一个表示当前表容 量的变量</h3>
 * <h3>需要定义二个变量head队头变量,tail队尾变量分别保存表队头的下标和队尾的下标</h3>
 * @author wangsongpeng
 * @since 2017/02/12
 */
public class MyQueue<T> implements Iterable<T> {
     private int theSize;//当前Arraylist的数据元素的个数,并不代表内部数组的长度
     private T[] theItems;//当前ArrayList的内部数组
     private static final int DEFAULT_CAPACITY = 10;//默认的内部数组初始容量
     private transient int head;/*队头变量*/
     private transient int tail;/*队尾变量*/

      public MyQueue(){
          theItems = (T[]) new Object[DEFAULT_CAPACITY];
          head = 0;tail = -1;theSize=0;
      }

    /**
     * 入队(在队列的表尾添加元素)
     * <h3>每次添加(入队时),判断当前队尾变量是否已溢出如果真溢出,扩展数组,当前队尾变量tail+1,然后在入队新元素.
     * 否则判断队头变量是大于0即不在表头,如果是则队尾变量值为0,形成循环队列.</h3>
     * @param t 要添加的元素
     */
    public void enQueue(T t){
        if(this.tail == this.theItems.length-1){
            if(this.theSize>=this.theItems.length){
                ensureCapacity(this.size()*2+1);
            }else{
                if(head<=0){
                    throw new IndexOutOfBoundsException("queue inside error!");
                }
                tail = -1;
            }
        }
        this.theItems[++tail] = t;
        this.theSize++;
    }

    /**
     * 出队(在队列的表尾删除元素)
     * <h3>每次删除时(出队时),直接删除并返回队头变量指向的元素,队头变量head+1指向下一个元素.
     * 如果队头变量指向表尾了,则重新赋值为0,形成循环队列</h3>
     * @return
     */
    public T deQueue(){
        head =  countHead(head);
        T result = this.theItems[head];
        if(result == null) return null;
        this.theItems[head++] = null;
        this.theSize--;
        return result;
    }



    /**
     * 返回当前ArryList的长度
     * @return 整型的arralist长度
     */
    public int size(){
        return this.theSize;
    }


    @Override
    public Iterator<T> iterator()
    {
        return new queueIterator();
    }

    /****************私有方法********************/


    private class queueIterator implements Iterator<T> {

        private int head;/*队头变量*/
        private int current = 0;/*当前迭代数量*/
        public queueIterator(){
            this.head = MyQueue.this.head;
        }

        @Override
        public boolean hasNext() {
            return current<MyQueue.this.theSize;
        }

        @Override
        public T next() {
            if(!hasNext())
              throw new NoSuchElementException();
            this.head =  countHead(head);
            T t = MyQueue.this.theItems[head++];
            current++;
            return t;
        }

        @Override
        public void remove() {
            throw new IllegalAccessError();
        }
    }


    /**
     * 重新扩展老数组,创建一个新数组以 newCapacity 为新数组长度
     * @param newCapacity 新数组长度
     */
    private void ensureCapacity(int newCapacity){
        if(this.theSize<this.theItems.length){
            return ;
        }
        this.theItems = Arrays.copyOf(this.theItems,newCapacity);
    }

    /**
     * 计算队列的队头变量
     * 如果队头变量到达最后一位,则重置为0
     * @param head 传入的队头变量
     * @return
     */
    private int countHead(int head){
        return (head == MyQueue.this.theItems.length)?0:head;
    }

}
