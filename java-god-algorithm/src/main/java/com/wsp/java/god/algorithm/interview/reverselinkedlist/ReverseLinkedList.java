package com.wsp.java.god.algorithm.interview.reverselinkedlist;
/**
 * 递归逆序链表,只能使用递归函数不能使用其他数据结构,并且只能用当前链表
 * @author wsp
 */
public class ReverseLinkedList {


    public static class Node{
        private int value;
        private ReverseLinkedList.Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }


    public Node reverseLinkedList(Node headNode) {
        if(headNode == null || headNode.getNext() == null)
            return headNode;

        Node newhead = reverseLinkedList(headNode.getNext()); // 先反转后面的链表
        headNode.getNext().setNext(headNode);//再将当前节点(head)设置为其然来后面节点(head->next)的后续节点
        headNode.setNext(null);//取消当前节点的后置节点
        return newhead;//总是返回最后一个节点为新节点
    }





}
