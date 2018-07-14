package com.wsp.java.god.cache;

/**
 * 缓存配置对象
 *
 * @author wsp
 */
public class CacheConfig {

    /**
     * 缓存最大值
     */
    private int maximum;

    /**
     * 并发级别
     */
    private int concurrencyLevel;


    public CacheConfig() {
    }

    public int getMaximum() {
        return maximum;
    }

    public CacheConfig setMaximum(int maximum) {
        this.maximum = maximum;
        return this;
    }

    public int getConcurrencyLevel() {
        return concurrencyLevel;
    }

    public CacheConfig setConcurrencyLevel(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
        return this;
    }

    public static enum CacheConfigKeyEnum{
        MAXIMUM("maximum"),
        CONCURRENCYLEVEL("concurrencyLevel")
        ;

        CacheConfigKeyEnum(String key) {
            this.key = key;
        }

        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheConfig)) {
            return false;
        }
        CacheConfig cacheConfig = (CacheConfig)obj;
        if(cacheConfig.getMaximum() != this.getMaximum()){
            return false;
        }
        if(cacheConfig.getConcurrencyLevel() != this.getConcurrencyLevel()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result  = this.getMaximum();
        result  = 31 * result + this.getConcurrencyLevel();
        return result;
    }
}
