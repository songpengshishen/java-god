package com.wsp.java.god.datastruct.tree;

/**
 *  二叉查找树实现
 *  二叉查找树是二叉树的一个分类,从根节点开始,每个节点的左节点(左子树)的值都小于当前节点的值,每个
 *  节点的右节点(右子树)的值都大于当前节点的值.二叉查找树的作用就是用于快速查找,添加,删除.尤其是查找
 *  二叉查找树使用类似与二分法的方式来过滤大量数据.
 *  @author wangsongpeng
 *  @since 2017/03/14
 */
public class BinarySearchTree<T extends Comparable<? super T >> {

    private BinaryNode<T> root;/*当前树的唯一根节点*/

    public BinarySearchTree(){
        root = null;//代表是空树
    }

    /**
     * 静态成员内部类,内部的二叉查找树节点.
     */
     private static class BinaryNode<T>{

        BinaryNode(T data){
            this(data,null,null);
        }

        BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        private T data;/*节点数据*/
        BinaryNode<T> left;/*当前节点的左节点*/
        BinaryNode<T> right;/*当前节点的右节点*/
     }

    /*****************公共方法*******************/

    public void makeEmpty(){
        root = null;
    }

    /**
     * 是否是空树
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 指定的数据对象是否在树中
     * 通过比较指定的数据与节点来决定从左边还是右边递归查找,减少查询次数
     * @param node
     * @return
     */
    public boolean contains(T node){
        return contains(node,root);
    }

    /**
     * 查找树的最小值
     * 通过不断递归左子树的节点来找出最小值
     * @return
     */
    public T findMin(){
        if(isEmpty()){
            throw new NullPointerException("tree is empty!");
        }
        return findMin(root).data;
    }

    /**
     * 查找树的最大值
     * 通过不断迭代右子树的节点来找出最大值
     * @return
     */
    public T findMax(){
        if(isEmpty()){
            throw new NullPointerException("tree is empty");
        }
        return findMax(root).data;
    }

    /**
     * 将node插入到当前的二叉查找树中.
     * 因为二叉树的特性所以插入的值总是会插入到叶子节点后面.
     * 通过contains比较node值与当前各个节点值的大小,从而选择插入时选择的路径,直到遍历到到该路径上的最后一个节点(即叶子节点)
     * 如果遍历过程中发现值与某个节点相同则替换值返回.
     * @note 插入操作需要返回插入后新树的根节点,来保持树的连通性.
     * @param node
     */
    public void insert(T node){
        root = insert(node,root);
    }

    /**
     * 删除指定的node的二叉查找树节点
     * 其中删除有3种情况:
     * 1:要删除的节点是一个叶子节点则直接删除,置为null
     * 2:要删除的节点有2个子节点,找出要删除节点的右子树中的最小的节点替换要删除节点,在进行二次删除,删除这个最小节点.
     * 3:要删除的节点有1个子节点,则让要删除节点的父节点跨过与自己的链指向其子节点即可.也就是说令子节点替代要删除节点.
     * @note 删除操作需要返回删除后新树的根节点(也表示子树),来保持树的连通性.
     * @param node
     */
    public void remove(T node){

    }
    public void printTree(){}

    /*****************私有方法*******************/

    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node == null){
            throw new IllegalStateException("node is empty!");
        }
        //一直迭代右子树,直到右边的叶子节点结束返回最大值
        while(node.right!=null){
              node = node.right;
        }
        return node;
    }
    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node == null){
            throw new IllegalStateException("node is empty!");
        }
        //是否是最小的叶子节点
        if(node.left == null) {
           return node;
        }
        //继续查找左边最小的节点
        return findMin(node.left);
    }
    private boolean contains(T node,BinaryNode<T> bNode){
        if(this.root == null){
            return false;
        }
        int compareVal =  compare(node,bNode.data);//这里比较节点与值
        //根据比较值决定递归的节点 >0:右节点 <0:左节点
        if(compareVal>0){
           return contains(node,bNode.right);
        }else if(compareVal<0){
           return contains(node,bNode.left);
        }
        return true;
    }

    private BinaryNode<T> insert(T node,BinaryNode<T> parent){
        if(null == parent){
            return new BinaryNode<T>(node,null,null);//如果节点为空 1:是空树2:插入遍历到路径的最后一个节点.
            //所以创建新值的节点
        }
        int compareVal = compare(node,parent.data);
        //根据比较值决定递归的节点 >0:右节点 <0:左节点
        if(compareVal>0){
            parent.right = insert(node,parent.right);//遍历右子树插入,并关联到右树父节点中
        }else if(compareVal<0){
            parent.left = insert(node,parent.left);//遍历左子树插入,并关联到左树父节点中
        }else{
            parent.data = node;//如果相同则替换值
        }
        return parent;
    }

    private BinaryNode<T> remove(T node,BinaryNode<T> parent){
        if(null == parent){
            return null;//如果节点为空,直接返回.对于根节点直接返回空.否则代表没有要删除的项,直接return停止
        }
        int compareVal = compare(node,parent.data);//进行比较
        if(compareVal>0){
             //如果大于,则从右边查找删除,最后关联右树的父节点
             parent.right = remove(node,parent.right);
        }else if(compareVal<0){
            //如果小于,则从左边查找删除,最后关联左树的父节点
             parent.left = remove(node,parent.left);
        }else if(parent.left != null && parent.right !=null){
            //找到要删除的节点,并且此节点有2个孩子节点
            //查找要删除节点右子树中的最小节点,把值替换给要删除的节点,这样保持了左小右大的二叉查找树特性.
            parent.data =  findMin(parent.right).data;
            //这里进行二次删除避免重复,将右子树的最小节点删除,并关联到右树的父节点中.
            parent.right =  remove(parent.data,parent.right);
        }else{
            //找到要删除的节点,此节点只有一个孩子节点或者是一个叶子节点
            //如果是叶子节点直接置为null返回
            //如果有左/右子节点,则令父节点跨过自身,执行其子节点,话句话说就是将子节点替代当前节点.
            parent = parent.left!=null?parent.left:parent.right;
        }
        return parent;
    }

    /**
     * 比较俩节点值,返回比较结果
     * compareVal$1 == compareVal$2  0
     * compareVal$1 > compareVal$2 >0
     * compareVal$1 < compareVal$2 <0
     * @param compareVal$1
     * @param compareVal$2
     * @return
     */
    private int compare(T compareVal$1,T compareVal$2){
         return compareVal$1.compareTo(compareVal$2);
    }

    private void printTree(BinaryNode<T> node){}




}
