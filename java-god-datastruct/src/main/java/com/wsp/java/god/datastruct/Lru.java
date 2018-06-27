package com.wsp.java.god.datastruct;



import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Lru 算法实现
 * @author wsp
 */
public class Lru<k,v> extends LinkedHashMap<k,v> {


    private static int maxCacheValue;

    public Lru(int maxCacheValue){
        super(10,1,true);
        this.maxCacheValue = maxCacheValue;
    }

    /**
     * 当linkedHashMap的size大于maxCacheValue删除最久没访问的数据
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size()>maxCacheValue;
    }


      public static void main(String[] args) {
        Lru<String,String> li = new Lru<String,String>(7);
        li.put("a","1");
        li.put("b","2");
        li.put("c","3");
        li.put("d","4");
        li.put("e","5");
        li.put("f","6");
        li.put("g","7");
        li.get("a");
        li.put("h","8");
       System.out.println(li.values());
    }

}
