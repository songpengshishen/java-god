package com.wsp.java.god.limit;

import java.util.concurrent.TimeUnit;



/**
 * 平滑的令牌桶限流器实现
 * 其中时间都以微妙计算
 * 令牌桶限流器应对并发大流量更平滑,在限流基础上对可用性影响也更低
 * @author wsp
 */
public class TokenBucketRateLimit implements RateLimit {


    /**
     * 每秒钟产生的令牌个数
     */
    private final int tokenPerSecond;

    /**
     * 桶中令牌最大个数
     */
    private final int maxToken;

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
        this(1,MAX_TOKEN_NUM);
    }


    private volatile Object mutexLock = new Object();


    public TokenBucketRateLimit(int tokenPerSecond) {
        this(tokenPerSecond, MAX_TOKEN_NUM);
    }


    public TokenBucketRateLimit(int tokenPerSecond, int maxToken) {
        checkParam(tokenPerSecond,maxToken);
        this.tokenPerSecond = tokenPerSecond;
        this.maxToken = Math.min(maxToken,MAX_TOKEN_NUM);
        startTime = TimeUnit.MICROSECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        lastGenTokenMicros = 0;
        genTokenMicros = TimeUnit.SECONDS.toMicros(1) / tokenPerSecond;
        syncGenToken(getElapseTime());/*创建限流器的时候就随机生成一部分token避免启动就有大流量*/
    }



    private void checkParam(int tokenPerSecond,int maxToken){
        if (tokenPerSecond <= 0 || maxToken <= 0) {
            throw new IllegalArgumentException("tokenPerSecond Or maxToken Can't be less than 0");
        }
        if(tokenPerSecond>maxToken){
            throw new IllegalArgumentException("tokenPerSecond can't be bigger than maxToken");
        }
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
        }
        return false;
    }

    /**
     * 同步生成token
     * @param elapseMicros
     */
    private void syncGenToken(long elapseMicros) {
        if (elapseMicros > lastGenTokenMicros) {
            double newToken = (elapseMicros - lastGenTokenMicros) / genTokenMicros;
            availableToken = (int) Math.min(newToken + availableToken, maxToken);
            lastGenTokenMicros = elapseMicros;
        }
    }

    private long getElapseTime() {
        return TimeUnit.MICROSECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS) - startTime;
    }



}
