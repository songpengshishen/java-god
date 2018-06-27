package com.wsp.java.god.datastruct.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * linkedlist 性能测试
 * @author wangsongpeng
 * @since 2016/11/25
 */
public class linkedlistTest {

    public void  getAndIterator() {
        List<Integer> table = new LinkedList<Integer>();
        for(int i = 0;i<100000;i++){
            table.add(i);
        }
        long startTime = System.currentTimeMillis();
        for(int i = 0 ;i<table.size();i++){
              Integer value = table.get(i);
        }
        System.out.println("current for time total : "+(System.currentTimeMillis()-startTime));

        long startTime2 = System.currentTimeMillis();
        for(Integer i :table) {
             Integer value = i;
        }
        System.out.println("current foreach time total : "+(System.currentTimeMillis()-startTime2));

    }


    public static void main(String args[]){
        ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("346");
        arrayList.add("789");
        Iterator it = arrayList.iterator();
        while(it.hasNext()){
            Object obj =  it.next();
        }
        System.out.println(arrayList);
    }



}
