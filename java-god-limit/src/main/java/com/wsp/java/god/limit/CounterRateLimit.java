package com.wsp.java.god.limit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计时器限流器
 * 适合简单限流场合,可以很好的和外部存储结合构成一个分布式的限流
 *
 * @author wsp
 */
public class CounterRateLimit implements RateLimit {

    private static final Logger logger = LoggerFactory.getLogger(CounterRateLimit.class);

    /**
     * 内部计数器
     */
    private AtomicInteger counter = new AtomicInteger(0);

    /**
     * 允许的最大请求阀值
     */
    private final int maxThreshold;

    /**
     * 重新计算时间
     * 以毫秒为单位
     */
    private final long recountTime;

    /**
     * 当计数器重置线程出现异常死掉后,pass设置为true,所有请求直接放行,限流器降级
     */
    private volatile boolean pass = false;


    /**
     * 默认最高1千请求阀值
     */
    private static final int DEFAULT_MAX_THRESHOLD = 1000;

    /**
     * 默认1分钟
     */
    private static final long DEFAULT_RECOUNT_TIME = 1;

    /**
     * 下一次重置计数的时间
     */
    private long nextRecountTime;


    public CounterRateLimit() {
        this(DEFAULT_MAX_THRESHOLD, DEFAULT_RECOUNT_TIME, TimeUnit.MINUTES);
    }


    public CounterRateLimit(int maxThreshold) {
        this(maxThreshold, DEFAULT_RECOUNT_TIME, TimeUnit.MINUTES);
    }


    public CounterRateLimit(int maxThreshold, long recountTime, TimeUnit timeUnit) {
        checkInitParam(maxThreshold,recountTime,timeUnit);
        this.maxThreshold = Math.min(maxThreshold,DEFAULT_MAX_THRESHOLD);
        this.recountTime = TimeUnit.MILLISECONDS.convert(recountTime, timeUnit);
        nextRecountTime = System.currentTimeMillis() + recountTime;
        Thread CounterResetThread = new Thread(() -> {
            while (true) {
                try {
                    if (System.currentTimeMillis() >= nextRecountTime) {
                        int value = counter.getAndSet(0);
                        System.out.println("重置计数器前的value : " + value);
                        nextRecountTime = System.currentTimeMillis() + recountTime;
                    } else {
                        /**
                         * 睡一秒
                         */
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    logger.warn("CounterResetThread Thread Interrupted Time of Occurrence : " + System.currentTimeMillis());
                } catch (Exception e) {
                    logger.error("CounterResetThread Thread Error!Enable Pass ",e);
                    pass = true;
                    throw e;
                }
            }

        }, "CounterResetThread");
        CounterResetThread.setDaemon(true);
        CounterResetThread.start();
    }


    private void checkInitParam(int maxThreshold, long recountTime, TimeUnit timeUnit){
        if (maxThreshold <= 0 || recountTime <= 0) {
            throw new IllegalArgumentException("maxThreshold Or recountTime Can't be less than 0");
        }
        if (null == timeUnit) {
            throw new IllegalArgumentException("timeUnit Can't be empty");
        }
        if (timeUnit.toMillis(recountTime) < 60000) {
            throw new IllegalStateException("recountTime can't be less than 1 minutes");
        }
    }


    @Override
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    @Override
    public boolean tryAcquire(int token) {
        if(token <=0 || token > 1){
            throw new IllegalArgumentException("CounterRateLimit tryAcquire Token can't be equal to 0 or more than 1");
        }
        if(pass){
            return true;
        }
        if(counter.incrementAndGet()<=maxThreshold){
            return true;
        }
        return false;
    }


}
