package com.wsp.java.god.datastruct;

import java.util.TreeMap;

/**
 * 红黑树
 * @author wsp
 */
public class RedBlackTree {

    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<String,String>();
        treeMap.put("c","1");
        treeMap.put("b","2");
        treeMap.put("a","3");
        System.out.println(treeMap.values());
    }

}
