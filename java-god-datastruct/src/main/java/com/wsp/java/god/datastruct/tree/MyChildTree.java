package com.wsp.java.god.datastruct.tree;

/**
 * 自定义实现树形数据结构
 * 树:树是具有层级迭代关系的数据结构,是有0个或多个节点组成的序列.0个节点的树叫做空树.否则树由一个根节点和多个子树组成.
 * 使用链式存储(链表)的孩子链表表示法来实现{@code MyChildTree}
 * 使用一个连续顺序的数组来保存树的所有节点,每一个节点除了有数据外还额外有一个指向该节点直接父节点在数组的下标.
 * @author wangsongpeng
 * @since 2017/2/26
 */
public class MyChildTree<T>{

    private TreeNode<T>[] treeNodes = null;//树节点数组

    private int rId = 0;//根节点在数组的位置默认为0

    private int theNodeSize=0;//树节点的个数

    private static final int  DEFAULT_CAPACITY = 16;

    public MyChildTree(){
        treeNodes = new TreeNode[DEFAULT_CAPACITY];
    }




    private class TreeNode<T>{
        private T data;//节点的数据
        private int parent;//该节点直接父节点在数组的下标,父节点为-1


        public TreeNode(T data,int parent){
            this.data = data;
            this.parent = parent;
        }
    }


}
