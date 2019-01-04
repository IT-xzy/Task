package com.ptteng.CahcheUtil;


public interface CacheDao {

    Boolean add(String key, Object value);

    Boolean set(String key, Object value);

    Boolean delete(String key);

    Boolean replace(String key, Object value);

    Object get(String key);

    Boolean flush();

}
