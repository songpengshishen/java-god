package com.wsp.java.god.datastruct.tree;

import java.util.Objects;

/**
 * 自定义实现树形数据结构
 * 树:树是具有层级迭代关系的数据结构,是有0个或多个节点组成的序列.0个节点的树叫做空树.否则树由一个根节点和多个子树组成.
 * 使用链式存储(链表)的孩子兄弟表示法来实现{@code MyChildBrotherTree}
 * 每个节点除了数据域另有俩个指针域
 * 一个指向子节点一个指向兄弟节点
 * @author wangsongpeng
 * @since 2017/2/26
 */
public class MyChildBrotherTree<T>{

    private TreeNode root;//树的根节点,唯一.

    /**
     * 创建一个空树
     */
    public MyChildBrotherTree(){
         root = new TreeNode(null,null,null);
    }

    /**
     * 创建一个带有根节点的树
     * @param Root 创建树时传入的根节点
     */
    public MyChildBrotherTree(T Root){
         root = new TreeNode(Root,null,null);
    }


    private class TreeNode<T>{
        private T data;//节点的数据
        private TreeNode<T> firstChild;//第一个子节点
        private TreeNode<T> nextSibLing;//下一个兄弟节点

        public TreeNode(T data,TreeNode firstChild,TreeNode nextSibLing){
            this.data = data;
            this.firstChild = firstChild;
            this.nextSibLing = nextSibLing;
        }

        public TreeNode<T> getNextSibLing() {
            return nextSibLing;
        }

        public void setNextSibLing(TreeNode<T> nextSibLing) {
            this.nextSibLing = nextSibLing;
        }

        public TreeNode<T> getFirstChild() {
            return firstChild;
        }

        public void setFirstChild(TreeNode<T> firstChild) {
            this.firstChild = firstChild;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


    /**
     * 添加新节点到指定父节点下,如果树是空树(根为Null)则新节点为根节点.
     * @param newNode 新节点
     * @param parentNode 父节点
     * @return 添加成功?true:false
     */
    public boolean add(T newNode,T parentNode){
        if(null == this.root){
            // null tree
            this.root = new TreeNode(newNode,null,null);
        }

       return true;
    }


    public T remove(T node){
       return  null;
    }


    private TreeNode<T> getNode(TreeNode root,T nodeData){
        Objects.requireNonNull(root);
        if(root.getData() == nodeData){
            return root;
        }

         return null;

    }
}
