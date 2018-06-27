package com.wsp.java.god.datastruct.tree;

import java.util.Objects;

/**
 * 自定义实现树形数据结构
 * 树:树是具有层级迭代关系的数据结构,是有0个或多个节点组成的序列.0个节点的树叫做空树.否则树由一个根节点和多个子树组成.
 * 使用连续顺序存储(数组)的双亲表示法来实现{@code MyParentTree}
 * 使用一个连续顺序的数组来保存树的所有节点,每一个节点除了有数据外还额外有一个指向该节点直接父节点在数组的下标.
 * @author wangsongpeng
 * @since 2017/2/26
 */
public class MyParentTree<T> implements TreeModel<T>{

    private TreeNode<T>[] treeNodes;//树节点数组

    private final int rId = 0;//根节点在数组的位置默认为0

    private int theNodeSize=0;//树节点的个数

    private static final int  DEFAULT_CAPACITY = 16;

    public MyParentTree(){
        treeNodes = (TreeNode[]) new Object[DEFAULT_CAPACITY];
    }


    private class TreeNode<T>{
        private T data;//节点的数据
        private int parent;//该节点直接父节点在数组的下标,父节点为-1


        public TreeNode(T data,int parent){
            this.data = data;
            this.parent = parent;
        }
    }

    @Override
    public T getRoot() {
        return this.treeNodes[rId].data;
    }

    @Override
    public int getHight() {
        return 0;
    }

    @Override
    public int getHight(T node) {
        int height = 0;
        TreeNode<T> treeNode = this.getTreeNode(node);
        for(int i = 0 ;i<this.treeNodes.length;i++){

        }

        return height;
    }

    @Override
    public boolean addNode(T OldNode, T newNode) {
        return false;
    }

    @Override
    public T removeNode(T node) {
        return null;
    }


    private TreeNode<T> getTreeNode(T data){
        Objects.requireNonNull(data,"tree data is null!");
        TreeNode<T> node = null;
        for(int i = 0 ; i<this.treeNodes.length; i++){
            node = this.treeNodes[i];
            if(node.data == data && node.data.equals(data)){
                break;
            }
        }
        return node;
    }
}
