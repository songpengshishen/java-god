package com.wsp.java.god.datastruct.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  自定义双向链表的实现
 *  @author wangsongpeng
 *  @since 2016/12/18
 */
public class MyLinkedList<T> implements Iterable<T> {
    private int theSize;//当前Linkedlist的实际数据元素的个数
    private int modCount;//linkedlist结构发生变化的记录数
    private Node<T> firstNode;//linkedlist的头节点,只作为链表的标记节点,用来简化操作
    private Node<T> lastNode;//linkedlist的尾节点,只作为链表的标记节点,用来简化操作

    public MyLinkedList(){
      doClear();
    }

    public void clear(){
      doClear();
    }

    public int size(){
        return this.theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 向链表尾部添加一个新的元素
     * @param t 新的元素的数据域
     * @return
     */
    public boolean add(T t){
        add(this.size(),t);
        return true;
    }

    public void add(int idx,T t){
        addBefore(getNode(idx,0,size()),t);
    }

    public T  get(int idx){
        return getNode(idx).data;
    }

    public T set(int idx,T t){
        Node<T> oldNode = getNode(idx);
        T oldValue = oldNode.data;
        oldNode.data = t;
        return oldValue;
    }


    public T remove(int idx){
        return remove(getNode(idx));
    }


    @Override
    public Iterator<T> iterator() {
        return new linkedlistIterator();
    }

    /****************私有方法********************/


    private static class Node<T>{
           public T data;/*数据域*/
           public Node<T> prevNode;/*上一个节点引用*/
           public Node<T> nextNode;/*下一个节点引用*/

           public Node(T d,Node<T> pNode,Node<T> nNode){
                 this.data = d;
                 this.prevNode = pNode;
                 this.nextNode = nNode;
           }

    }


    private class linkedlistIterator implements Iterator<T> {

        private int expectedModCount = MyLinkedList.this.modCount;
        private Node<T> currNode  = MyLinkedList.this.firstNode.nextNode;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return currNode != lastNode;
        }

        @Override
        public T next() {
             if(expectedModCount != modCount){
                 throw new ConcurrentModificationException();
             }
             if(!hasNext()){
                 throw new NoSuchElementException();
             }
             T val = currNode.data;
             currNode = currNode.nextNode;
             okToRemove = true;
             return val;
        }

        @Override
        public void remove() {
              if(expectedModCount != modCount){
                  throw new ConcurrentModificationException();
              }

              if(!okToRemove){
                  throw new IllegalStateException();
              }

              MyLinkedList.this.remove(currNode.prevNode);
              expectedModCount = modCount;
              okToRemove = false;
        }
    }

    /**
     * 清空,初始化
     */
    private void doClear(){
        this.firstNode =  new Node<T>(null,null,null);
        this.lastNode = new Node<T>(null,firstNode,null);
        this.firstNode.nextNode = lastNode;
        this.theSize = 0;
        this.modCount = 0;
    }


    /**
     * 获取有效节点
     * @param idx 索引下标
     * @return 链表中的节点
     */
    private Node<T> getNode(int idx){
         return getNode(idx,0,size()-1);
    }

    /**
     * 获取节点
     * @param idx 索引下标
     * @param lower 起始
     * @param upper 结尾
     * @return 节点
     */
    private Node<T> getNode(int idx,int lower,int upper){
        Node<T> node = null;
        //如过下标低于起始位置或者高于结尾位置,抛出异常.
        if(idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }
        if(idx<size()/2) {
                node = this.firstNode.nextNode;//获取真正的有效节点
                for(int i = 0;i<idx;i++){
                      node = node.nextNode;
                }
        }else{
                node = this.lastNode;//获取真正的有效节点
                for(int i = size();i>idx;i--){
                      node = node.prevNode;
                }
        }
        return node;
    }


    /**
     * 向链表中插入一个新节点
     * @param node 原节点
     * @param t 新节点的数据域
     */
    private void addBefore(Node<T> node,T t) {
        //创建一个新插入的节点,将原来节点的上级节点作为新节点的上级节点,自己作为新节点的下级节点
        Node<T> newlastNode = new Node<T>(t, node.prevNode, node);
        //维护原来上级节点的下级节点逻辑关系
        newlastNode.prevNode.nextNode = newlastNode;
        //维护原来节点上级节点的逻辑关系
        node.prevNode = newlastNode;
        //长度++
        theSize++;
        //修改记录数++
        modCount++;
    }

    private T remove(Node<T> node){
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
        theSize--;
        modCount++;
        return node.data;
    }
}