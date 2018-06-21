import com.wsp.java.god.limit.RateLimit;
import com.wsp.java.god.limit.TokenBucketRateLimit;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流测试
 * @author wsp
 */
public class RateLimitTest {


    @Test
    public static void main(String[] args)throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(100);
        RateLimit rateLimit = new TokenBucketRateLimit(1,10);
        ThreadFactory threadFactory = new ThreadFactory() {
            AtomicInteger atomicInteger = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r,"wsp-"+atomicInteger.incrementAndGet());
                t.setDaemon(true);
                return t;
            }
        };
        ExecutorService executors =  Executors.newFixedThreadPool(10,threadFactory);
        for(int i = 0;i<100;i++){
            executors.execute((()->{
                if(rateLimit.tryAcquire()){
                    System.out.println("成功!");
                    try {
                        Thread.sleep(1000);//模拟操作数据
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.err.println("失败!");
                }
                countDownLatch.countDown();
            }));
        }
        countDownLatch.await();
    }

}
