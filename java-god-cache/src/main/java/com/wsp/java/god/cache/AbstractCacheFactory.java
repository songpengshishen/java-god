package com.wsp.java.god.cache;

import java.util.Map;
import java.util.Properties;

/**
 * 抽象的缓存工厂类
 * @author wsp
 */
public abstract class AbstractCacheFactory implements CacheFactory{

    @Override
    public Cache createCache(Properties prop) {
        return createCache(propToConfig(prop));
    }

    @Override
    public Cache createCache(Map<String, Object> map) {
        return createCache(mapToConfig(map));
    }

    @Override
    public Cache createCache(CacheConfig cacheConfig) {
        return newCache(cacheConfig);
    }



    private CacheConfig propToConfig(Properties prop){
        return null;
    }

    private CacheConfig mapToConfig(Map<String, Object> map){
        return null;
    }




    public abstract Cache newCache(CacheConfig cacheConfig);

}
