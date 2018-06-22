import com.wsp.java.god.limit.CounterRateLimit;
import com.wsp.java.god.limit.RateLimit;
import com.wsp.java.god.limit.TokenBucketRateLimit;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流测试
 *
 * @author wsp
 */
public class RateLimitTest {


    public void testTokenBucketRateLimit() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        RateLimit rateLimit = new TokenBucketRateLimit(1, 10);
        ExecutorService executors = Executors.newFixedThreadPool(10, new MyThreadFactory());
        for (int i = 0; i < 100; i++) {
            executors.execute((() -> {
                if (rateLimit.tryAcquire()) {
                    System.out.println("成功!");
                    try {
                        Thread.sleep(1000);//模拟操作数据
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("失败!");
                }
                countDownLatch.countDown();
            }));
        }
        countDownLatch.await();
    }


    public void testCounterRateLimit() throws Exception {
        CounterRateLimit counterRateLimit = new CounterRateLimit(2);
    }


    private class MyThreadFactory implements ThreadFactory {

        AtomicInteger atomicInteger = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "rateLimitTest-" + atomicInteger.incrementAndGet());
            t.setDaemon(true);
            return t;
        }

    }

    ;


}
