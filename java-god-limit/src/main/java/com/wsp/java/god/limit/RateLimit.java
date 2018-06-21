package com.wsp.java.god.limit;

/**
 * 限流器接口
 * @author wsp
 */
public interface RateLimit {



    /**
     * 尝试获取单个令牌,获取到就返回true,没有获取到返回false
     * @return
     */
    boolean tryAcquire();


    /**
     * 尝试获取指定个数的令牌,获取到就返回true,没有获取到返回false
     * @param token
     * @return
     */
    boolean tryAcquire(int token);


}
