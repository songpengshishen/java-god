package com.wsp.java.god.algorithm.interview.reverselinkedlist;



/**
 * 递归逆序链表
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ReverseLinkedList.Node node1 = new ReverseLinkedList.Node(1);
        ReverseLinkedList.Node node2 = new ReverseLinkedList.Node(2);
        ReverseLinkedList.Node node3 = new ReverseLinkedList.Node(3);
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4);
        ReverseLinkedList.Node node5 = new ReverseLinkedList.Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ReverseLinkedList.Node node = new ReverseLinkedList.Node(-1);

        node1 =  reverseLinkedList.reverseLinkedList(node1);
        node.setNext(node1);


        while(null!=node && node.getNext()!=null){
            System.out.println(node.getNext());
            node = node.getNext();
        }
    }
}
