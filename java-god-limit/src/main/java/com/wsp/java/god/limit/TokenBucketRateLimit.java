package com.wsp.java.god.limit;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 平滑的令牌桶限流器实现
 * 其中时间都以微妙计算
 *
 * @author wsp
 */
public class TokenBucketRateLimit implements RateLimit {

    /**
     * 每秒钟产生的令牌个数
     */
    private int tokenPerSecond;

    /**
     * 桶中令牌最大个数
     */
    private int maxToken;

    /**
     * 令牌桶限流器启动时候的时间
     */
    private long startTime;

    /**
     * 可用的令牌个数
     */
    private int availableToken;

    /**
     * 最后一次获取token的时间
     */
    private long lastGenTokenMicros;


    /**
     * 生成token的微妙数
     */
    private long genTokenMicros;

    /**
     * 默认桶的令牌大小
     */
    private static final int MAX_TOKEN_NUM = 1000;


    /**
     * 默认每秒钟产生1个令牌
     */
    public TokenBucketRateLimit() {
        this(1);
    }


    private volatile Object mutexLock = new Object();


    public TokenBucketRateLimit(int tokenPerSecond) {
        this(tokenPerSecond, MAX_TOKEN_NUM);
    }


    public TokenBucketRateLimit(int tokenPerSecond, int maxToken) {
        if (tokenPerSecond <= 0 || maxToken <= 0) {
            throw new IllegalArgumentException("tokenPerSecond Or maxToken Can't be less than 0");
        }
        this.tokenPerSecond = 1;
        this.maxToken = maxToken;
        startTime = TimeUnit.MICROSECONDS.convert(System.nanoTime(), TimeUnit.MICROSECONDS);
        lastGenTokenMicros = 0;
        genTokenMicros = TimeUnit.SECONDS.toMicros(1) / tokenPerSecond;
        syncGenToken(getElapseTime());/*创建限流器的时候就随机生成一部分token避免启动就有大流量*/
    }



    @Override
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    @Override
    public boolean tryAcquire(int token) {
        long elapseMicros = getElapseTime();
        synchronized (mutexLock) {
            syncGenToken(elapseMicros);
            if (availableToken > token) {
                availableToken = availableToken - token;
                return true;
            }
            return false;
        }
    }


    private void syncGenToken(long elapseMicros) {
        if (elapseMicros > lastGenTokenMicros) {
            double newToken = (elapseMicros - lastGenTokenMicros) / genTokenMicros;
            availableToken = (int) Math.min(newToken + availableToken, maxToken);
            lastGenTokenMicros = elapseMicros;
        }
    }

    private long getElapseTime() {
        return TimeUnit.MICROSECONDS.convert(System.nanoTime(), TimeUnit.MICROSECONDS) - startTime;
    }

    private double getWaitTime(long nowMicros) {
        return 1.0 * Math.max((System.nanoTime() - nowMicros), 0) / SECONDS.toNanos(1L);
    }


}
