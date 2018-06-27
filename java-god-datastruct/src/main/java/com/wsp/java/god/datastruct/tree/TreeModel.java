package com.wsp.java.god.datastruct.tree;

/**
 * 普通树的操作集合
 *
 * @author wangsongpeng
 * @see MyChildBrotherTree
 * @see MyChildTree
 * @see MyParentTree
 */
public interface TreeModel<T> {

    /*树路径:从指定节点到目标节点所经过的节点序列叫做节点的路径,路径的长等于节点序列的总数减1, l = N(节点总数)-1  */
    static int NODE_HEIGHT = 0;/*节点高度:从该节点到最深的那个叶子节点的路径长叫做节点的高*/
    static int NODE_DEPTH = 0;/*节点深度:从根节点到当前节点的唯一路径长叫做节点的深度*/
    static int TREE_HEIGHT_DEPTH = 0;/*树的高度和深度一样.都是当前树的根节点的高 */


    T getRoot();
    int getHight();
    int getHight(T node);
    boolean addNode(T OldNode, T newNode);
    T removeNode(T node);
}
