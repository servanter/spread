package com.zhy.spread.util;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * memcached util for set and get values.
 * 
 * @author wunan
 * 
 */
public class MemcachedUtil {
    public static final long MINUTE = 60;
    public static final long HOUR = 60 * 60;
    public static final long DAY = 60 * 60 * 12;
    public static final long MONTH = 60 * 60 * 12 * 30;
    public static final long YEAR = 60 * 60 * 12 * 30 * 365;

    private MemCachedClient client = null;

    /**
     * The pool must be initialized prior to use for memcached client.
     */
    static {
        init();
    }

    private static void init() {
        String[] serverlist = new String[]{"192.169.1.101:11211"};
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(serverlist);
        pool.initialize();
    }

    private MemcachedUtil() {
        client = new MemCachedClient();
    }

    /**
     * Get the instance of memcached client.
     */
    public synchronized static MemcachedUtil getInstance() {
        return new MemcachedUtil();
    }

    public boolean delete(String key) {
        return client.delete(key);
    }

    public boolean delete(String key, Date expiry) {
        return client.delete(key, expiry);
    }

    public boolean delete(String key, long seconds) {
        return client.delete(key, new Date(System.currentTimeMillis() + seconds * 1000));
    }

    public boolean set(String key, Object value) {
        return client.set(key, value, new Date(System.currentTimeMillis() + 2 * HOUR));
    }

    public boolean set(String key, Object value, Date expiry) {
        return client.set(key, value, expiry);
    }

    public boolean set(String key, Object value, long seconds) {
        return client.set(key, value, new Date(System.currentTimeMillis() + seconds * 1000));
    }

    public boolean add(String key, Object value) {
        return client.add(key, value, new Date(System.currentTimeMillis() + 2 * HOUR));
    }

    public boolean add(String key, Object value, Date expiry) {
        return client.add(key, value, expiry);
    }

    public boolean add(String key, Object value, long seconds) {
        return client.add(key, value, new Date(System.currentTimeMillis() + seconds * 1000));
    }

    public boolean replace(String key, Object value) {
        return client.replace(key, value, new Date(System.currentTimeMillis() + 2 * HOUR));
    }

    public boolean replace(String key, Object value, Date expiry) {
        return client.replace(key, value, expiry);
    }

    public boolean replace(String key, Object value, long seconds) {
        return client.replace(key, value, new Date(System.currentTimeMillis() + seconds * 1000));
    }

    public Object get(String key) {
        return client.get(key);
    }

    public static void main(String[] args) {
        MemcachedUtil.getInstance().set("xxx", "12123123", HOUR);
        System.out.println(MemcachedUtil.getInstance().get("xxx"));
    }
}
