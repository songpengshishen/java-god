package com.wsp.java.god.datastruct.list;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  自定义动态数组实现类
 *  @see Iterable
 *  @see Iterator
 *  @see java.util.ArrayList
 *  @see java.util.List
 *  @see java.util.Collection
 *  @author wangsongpeng
 *  @since 2016/11/26
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;//默认的内部数组初始容量
    private static final Object[] DEFAULT_EMPTY_ARR = {};//默认的空数组
    protected int theSize;//当前Arraylist的数据元素的个数,并不代表内部数组的长度
    protected T[] theItems;//当前ArrayList的内部数组

    /**
     * 创建一个默认大小的{@link MyArrayList#DEFAULT_CAPACITY ArrayList}列表
     */
    public MyArrayList(){
        this.theSize = 0;
        this.theItems = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 清空当前Arraylist
     */
    public void clear(){
        doClear();
    }

    /**
     * 返回当前ArryList的长度
     * @return 整型的arralist长度
     */
    public int size(){
        return this.theSize;
    }

    /**
     * 判断当前ArrayList是否为空
     * @return  空:true 非空:false
     */
    public boolean isEmpty(){
        return size() <= 0;
    }


    /**
     * 调整数组大小到当前列表大小
     * @see MyArrayList#theSize 数组大小
     * 当前列表大小就是当前 Arraylist 最后操作后有值空间的大小
     */
    public void trimToSize(){
      ensureCapacity(this.theSize);
    }


    /**
     * Arraylist检索获取数据,从内部数组直接返回下标对应数据元素
     * 数组名+(idx-1)*T(占内存)=idx所指向的数据元素
     * @param idx 数组下标
     * @return 下标对应的数据项
     */
    public T get(int idx){
        checkIndex(idx);
        return this.theItems[idx];
    }

    /**
     * 在下标 idx 设置新值 newValue
     * @param idx 传入的下标
     * @param newValue 新值
     * @return 返回下标idx原来的旧值
     */
    public T set(int idx,T newValue){
        checkIndex(idx);
        T oldValue = this.theItems[idx];
        this.theItems[idx] = newValue;
        return oldValue;
    }

    /**
     * 重新扩展老数组,创建一个新数组以 newCapacity 为新数组长度
     * @param newCapacity 新数组长度
     */
    public void ensureCapacity(int newCapacity){
            if(this.theSize<this.theItems.length){
                 return ;
            }
            this.theItems = Arrays.copyOf(this.theItems,newCapacity);
    }

    /**
     * 插入一个新元素到列表的尾部
     * @param t 新数据元素
     * @return 插入成功:true 插入失败:false
     */
    public boolean add(T t){
         add(this.theSize,t);
         return true;
    }

    /**
     * 向列表指定索引下标处添加一个新值
     * @param idx 索引下标
     * @param t 新值
     */
    public void add(int idx,T t){
       if(theItems.length >= theSize){
           ensureCapacity(this.theSize*2+1);
       }
       if(idx == this.theSize){
           this.theItems[idx] = t;
       }else{
           for(int i = this.theSize;i>idx;i++){
               this.theItems[i] = this.theItems[i-1];
           }
           this.theItems[idx] = t;
       }
       this.theSize++;

    }

    /**
     * 删除指定下标处的索引
     * @param idx 指定下标
     * @return 返回下标原有的数据
     */
    public T remove(int idx){
       checkIndex(idx);
       T oldValue = this.theItems[idx];
       if(idx != this.theSize-1){
           for(int i = idx;i<this.theSize-1;i++){
               theItems[i] = theItems[i+1];
           }
       }
       this.theSize--;
       return oldValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraylistIterator();
    }

    /****************私有方法********************/


    /**
     * 执行清空当前ArrayList
     */
    private void doClear(){
        this.theSize = 0;
        this.theItems = (T[]) DEFAULT_EMPTY_ARR;
    }

    /**
     * 验证当前数组索引是否越界或低于0
     * @throws ArrayIndexOutOfBoundsException 当传入的索引超出边界或低于0时
     * @param idx 下标索引
     */
    private void checkIndex(int idx){
        if(idx <0 || idx>=this.theSize){
            throw new ArrayIndexOutOfBoundsException("传入的索引"+idx+"不合法");
        }
    }

    private class ArraylistIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current<MyArrayList.this.theSize;
        }

        @Override
        public T next() {
            if(!hasNext()){
              throw new NoSuchElementException();
            }
            return MyArrayList.this.theItems[current++];
        }


        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

}
