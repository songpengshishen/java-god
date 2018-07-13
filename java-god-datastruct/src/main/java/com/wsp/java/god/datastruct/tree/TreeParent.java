package com.wsp.java.god.datastruct.tree;

import java.util.Arrays;

/**
 * 父(双亲)节点存储结构实现Tree数据结构
 * 实现核心即可,并未实现全部功能
 * @author wsp
 */
public class TreeParent<T> {

    private static final int DEFAULT_TREE_CAPACITY = 16;

    private static final int DEFAULT_TREE_MAX_CAPACITY = Integer.MIN_VALUE;

    private int treeCapacity;

    private int size = 0;

    private TreeNode<T>[] nodes = null;


    public TreeParent() {
        this(DEFAULT_TREE_CAPACITY, null);
    }

    public TreeParent(int treeCapacity, T root) {
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
            TreeNode treeNode = new TreeNode(node, index(parent));
            nodes[size++] = treeNode;
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
        nodes[0] = new TreeNode(root, -1);
    }


    private void checkExistRoot() {
        if (null != nodes) {
            if (null != nodes[0] && null != nodes[0].getData() && nodes[0].getParentIndex() == -1) {
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
        private int parentIndex;

        public TreeNode(O data, int parentIndex) {
            this.data = data;
            this.parentIndex = parentIndex;
        }

        public O getData() {
            return data;
        }

        public void setData(O data) {
            this.data = data;
        }

        public int getParentIndex() {
            return parentIndex;
        }

        public void setParentIndex(int parentIndex) {
            this.parentIndex = parentIndex;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", parentIndex=" + parentIndex +
                    '}';
        }
    }


    public static void main(String[] args) {
        TreeParent<String> tree = new TreeParent<String>();
        tree.add("a", null);
        tree.add("b","a");
        System.out.println(tree.getRoot());
    }
}
