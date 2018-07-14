package com.wsp.java.god.cache;

import java.util.Collection;

/**
 * 缓存接口
 * @author wsp
 */
public interface Cache<K,V> {

      V get(K key);

      V put(K key,V value);

      V remove(K key);

      int size();

      void clear();

      Collection<V>  values();

      Collection<K>  keys();
}
