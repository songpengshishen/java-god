package com.wsp.java.god.datastruct.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 孩子存储结构实现Tree数据结构
 * 实现核心即可,并未实现全部功能
 * @author wsp
 */
public class TreeChildren<T> {

    private static final int DEFAULT_TREE_CAPACITY = 16;

    private static final int DEFAULT_TREE_MAX_CAPACITY = Integer.MIN_VALUE;

    private int treeCapacity;

    private int size = 0;

    private TreeNode<T>[] nodes = null;


    public TreeChildren() {
        this(DEFAULT_TREE_CAPACITY, null);
    }

    public TreeChildren(int treeCapacity, T root) {
        this.treeCapacity = treeCapacity;
        this.nodes = new TreeNode[treeCapacity];
        if (null != root) {
            setRoot(root);
        }
    }


    public void add(T node, T parent) {
        if (null == parent) {
            setRoot(node);
        } else {
            TreeNode treeNode = new TreeNode(node);
            nodes[size++] = treeNode;
            nodes[index(parent)].getChildrens().add(size);

        }
    }


    public T getRoot() {
        TreeNode<T> tn = nodes[0];
        return null == tn ? null : tn.getData();
    }


    private int index(T node) {
        for (int i = 0; i < size; i++) {
            if (nodes[i].getData().equals(node)) {
                return i;
            }
        }
        throw new IllegalStateException("Node does not exist!");
    }

    private void setRoot(T root) {
        checkExistRoot();
        nodes[0] = new TreeNode(root);
        size++;
    }


    private void checkExistRoot() {
        if (null != nodes) {
            if (null != nodes[0] && null != nodes[0].getData()) {
                throw new IllegalStateException("Root Node Not to be Repeated!");
            }
        }
    }


    @Override
    public String toString() {
        return "TreeParent{" +
                "treeCapacity=" + treeCapacity +
                ", size=" + size +
                ", nodes=" + Arrays.toString(nodes) +
                '}';
    }

    private static class TreeNode<O> {
        private O data;
        private LinkedList<Integer> childrens;

        public TreeNode(O data) {
            this(data,new LinkedList<Integer>());
        }

        public TreeNode(O data, LinkedList<Integer> childrens) {
            this.data = data;
            this.childrens = childrens;
        }

        public O getData() {
            return data;
        }

        public void setData(O data) {
            this.data = data;
        }

        public LinkedList<Integer> getChildrens() {
            return childrens;
        }

        public void setChildrens(LinkedList<Integer> childrens) {
            this.childrens = childrens;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", childrens=" + childrens +
                    '}';
        }
    }


    public static void main(String[] args) {
        TreeChildren<String> tree = new TreeChildren<String>();
        tree.add("a", null);
        tree.add("b","a");
        System.out.println(tree);
    }
}
