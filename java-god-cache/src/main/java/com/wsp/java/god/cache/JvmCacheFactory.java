package com.wsp.java.god.cache;



/**
 * Jvm本地缓存工厂类
 * @author wsp
 */
public class JvmCacheFactory extends AbstractCacheFactory  {


    @Override
    public Cache newCache(CacheConfig cacheConfig) {
        return new JvmCache(cacheConfig.getMaximum(),cacheConfig.getConcurrencyLevel());
    }
}
