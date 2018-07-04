package com.wsp.java.god.designpattern.singleton;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单例模式测试类
 * @author wsp
 */
public class Main {

    public static void main(String[] args)throws Exception {
         ExecutorService executorService =  Executors.newFixedThreadPool(3);
         List<Future>  fs = new ArrayList<Future>();
         for(int i=0;i<3;i++){
             Future<Singleton> f1 = executorService.submit(()->{
                return Singleton.getInstance();
             });
             fs.add(f1);
         }
         Thread.sleep(3000);
         System.out.println( (fs.get(0).get() == fs.get(1).get() &&  fs.get(1).get() == fs.get(2).get()) );
    }
}
