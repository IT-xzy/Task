package com.jnshu.pojo.tool.memcached;

/**
 * @author pipiretrak
 * @date 2019/4/24 - 9:12
 */
public interface MemcachedUtil {
    Boolean set(String key,int exp, Object value);

    Boolean delete(String key);

    Object get(String key);
}

