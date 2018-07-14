package com.wsp.java.god.cache;
import java.util.Map;

import java.util.Properties;

/**
 * 获取缓存工厂
 * @author wsp
 */
public interface CacheFactory {

    Cache createCache(Properties prop);

    Cache createCache(Map<String,Object> map);

    Cache createCache(CacheConfig cacheConfig);
}
