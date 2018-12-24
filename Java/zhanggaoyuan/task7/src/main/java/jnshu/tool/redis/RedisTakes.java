package jnshu.tool.redis;

import java.util.List;

//Redis的基本操作接口
public interface RedisTakes {
    //增
    void add(Object key, Object value);

    void addObj(Object hash, Object hashKey, Object value);

    /**
     * @param key
     * @param value
     * @param time  过期时间,单位秒
     */
    void set(Object key, Object value, long time);


    //删
    void delete(Object key);

    void delete(List listKeys);

    void deletObj(Object objecyKey, Object key);

    //改
    void update(Object key, String value);

    void updateObj(Object objectKey, Object key, Object object);

    //查
    Object get(Object key);

    Object getObj(Object hash, Object hashKey);


}