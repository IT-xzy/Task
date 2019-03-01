package com.ptteng.cache;

/**
 * @ClassName Cached
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/27  17:13
 * @Version 1.0
 **/
public interface Cached {

    Boolean set(String key, Object value);

    Boolean delete(String key);

    Object get(String key);
}
