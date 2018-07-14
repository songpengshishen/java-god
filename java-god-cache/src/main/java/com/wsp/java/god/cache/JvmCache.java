package com.wsp.java.god.cache;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jvm本地缓存实现
 *
 * @author wsp
 */
public class JvmCache<K, V> implements Cache<K, V> {

    private static final int DEFAULT_CACHE_MAX = Integer.MAX_VALUE;

    private static final int DEFAULT_CONCURRENCYLEVEL = 16;

    /**
     * 缓存最大值
     */
    private final int maximum;

    /**
     * 并发级别
     */
    private final int concurrencyLevel;

    /**
     * 当前缓存个数
     */
    private AtomicInteger size = new AtomicInteger(0);

    private Segment<K, V>[] segments = null;


     JvmCache(int maximum) {
        this(maximum, DEFAULT_CONCURRENCYLEVEL);
    }

     JvmCache(int maximum, int concurrencyLevel) {
        this.maximum = maximum <= 0 ? DEFAULT_CACHE_MAX : maximum;
        this.concurrencyLevel = concurrencyLevel <= 0 ? DEFAULT_CONCURRENCYLEVEL : concurrencyLevel;
        segments = new Segment[concurrencyLevel];
    }


    Segment<K, V> segmentFor(K key) {
        return segments[Math.abs(key.hashCode()) % (segments.length - 1)];
    }


    @Override
    public V get(K key) {
        return segmentFor(key).getVal(key);
    }

    @Override
    public V put(K key, V value) {
        return segmentFor(key).putVal(key,value);
    }

    @Override
    public V remove(K key) {
        return segmentFor(key).remove(key);
    }

    @Override
    public int size() {
        return size.get();
    }

    @Override
    public void clear() {
        synchronized (this){
            for(int i = 0 ; i < segments.length;i++){
                segments[i].cacheMap.clear();
            }
            size.set(0);
        }
    }

    @Override
    public Collection<V> values() {
        List<V> collections = new ArrayList<V>();
        synchronized (this){
            for(int i = 0 ; i < segments.length;i++){
                collections.addAll(segments[i].cacheMap.values());
            }
        }
        return collections;
    }

    @Override
    public Collection<K> keys() {
        List<K> collections = new ArrayList<K>();
        synchronized (this){
            for(int i = 0 ; i < segments.length;i++){
                collections.addAll(segments[i].cacheMap.keySet());
            }
        }
        return collections;
    }


    private class Segment<K, V> extends ReentrantLock {

      private LinkedHashMap<K, V> cacheMap = new LinkedHashMap<K, V>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                boolean removeFlag =  size.get() > maximum;
                if(removeFlag){
                    size.decrementAndGet();
                }
                return removeFlag;
            }
        };

        public V getVal(K key) {
            lock();
            V value = null;
            try {
                value = cacheMap.get(key);
            } finally {
                unlock();
            }
            return value;
        }

        public V putVal(K key, V value) {
            V old = null;
            lock();
            try {
                old = cacheMap.put(key, value);
            } finally {
                unlock();
            }
            size.incrementAndGet();
            return old;
        }

        public V remove(K key){
            V old = null;
            lock();
            try {
                old = cacheMap.remove(key);
            } finally {
                unlock();
            }
            size.decrementAndGet();
            return old;
        }
    }


}
