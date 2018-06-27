package com.jnshu.tools;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: taskTwo
 * @description: Redis 缓存工具类
 * @author: Mr.xweiba
 * @create: 2018-05-23 23:24
 * @des: https://blog.csdn.net/qq_34021712/article/details/75949706
 * 针对所有的hash 都是以h开头的方法
 * 针对所有的Set 都是以s开头的方法                    不含通用方法
 * 针对所有的List 都是以l开头的方法
 **/

public class RedisUtils {
    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /* ================= 通用 =================*/
    /**
     * @Description: 设置指定key的过期时间
     * @Param: [key, time] key名, 过期时间(s)
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public boolean expire(String key, long time) {
        try {
            if (time >= 0) {
                // TimeUnit.SECONDS 颗粒度按秒计算
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean expire(String key) {
        try {
            // TimeUnit.SECONDS 颗粒度按秒计算
            redisTemplate.expire(key, 0, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description: 获取指定key的获取时间
     * @Param: [key]
     * @return: long 颗粒度为秒
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * @Description: 判断key值是否存在
     * @Param: [key]
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description: 删除指定 key, 或key集合
     * @Param: [key]
     * @return: void
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public boolean delKey(String... key) {
        if (key.length == 1) {
            try {
                redisTemplate.delete(key[0]);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            // CollectionUtils.arrayToList(key) 将key字符串集合转换为list对象集合
            try {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * @Description: 获取指定key的value
     * @Param: [key]
     * @return: java.lang.Object
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public Object get(String key) {
        // 三元运算符 key为空返回null,否则返回redisTemplate.opsForValue().get(key);
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @Description: 添加普通缓存
     * @Param: [key, object]
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/24
     */
    public boolean set(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 添加普通缓存并设置过期时间
     * @param: [key] 键
     * @param: [object] 值
     * @param: [time] 过期时间, 单位秒, 如果time小于等于0 将设置无限期
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 16:07
     * @since: 1.0.0
     */
    public boolean set(String key, Object object, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, object, time, TimeUnit.SECONDS);
            } else {
                set(key, object);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 递增
     * @param: [key] 键
     * @param: [dalte] 增加的数
     * @return: long
     * @author: Mr.xweiba
     * @date: 2018/5/24 16:51
     * @since: 1.0.0
     */
    public long incr(String key, long dalte) {
        if (dalte < 0) {
            throw new RuntimeException("增长因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, dalte);
    }

    /**
     * @description 递减
     * @param: [key] 键
     * @param: [dalte] 减少的值
     * @return: long
     * @author: Mr.xweiba
     * @date: 2018/5/24 16:52
     * @since: 1.0.0
     */
    public long decr(String key, long dalte) {
        if (dalte < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -dalte);
    }

    /*============= Map ===============*/

    /**
     * @description 获取指定key及指定对象item的值
     * @param: [key]
     * @param: [item]
     * @return: java.lang.Object
     * @author: Mr.xweiba
     * @date: 2018/5/24 16:58
     * @since: 1.0.0
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * @description 获取key对应的所有键值对
     * @param: [key]
     * @return: java.util.Map<java.lang.Object   ,   java.lang.Object>
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:00
     * @since: 1.0.0
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @description 存储map集合缓存
     * @param: [key] 键
     * @param: [map] 集合
     * @return: boolean 成功true 失败false
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:03
     * @since: 1.0.0
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 存储map集合缓存, 并设定过期时间
     * @param: [key]
     * @param: [map]
     * @param: [time]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:08
     * @since: 1.0.0
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * description 像一张hash表中添加数据,如果不存在将创建
     *
     * @param: [key]
     * @param: [item]
     * @param: [value]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:13
     * @since: 1.0.0
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * @description 向一张表中放入数据, 若不存在将创建
     * @param: [key]
     * @param: [item]
     * @param: [value]
     * @param: [time] 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:16
     * @since: 1.0.0
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 删除hash表中的值
     * @param: [key]
     * @param: [item]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:21
     * @since: 1.0.0
     */
    public boolean hdel(String key, Object ... item){
        long along = redisTemplate.opsForHash().delete(key, item);
        if (along > 0){
            return true;
        }
        return false;
    }
    
    /**
     * @description 判断hash表中是否有该项的值
     * @param: [key]
     * @param: [item]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:23
     * @since: 1.0.0
     */
    public boolean hHasKey(String key, Object item){
        return redisTemplate.opsForHash().hasKey(key,item);
    }

    /**
     * @description 递增 如果不存在,就会创建一个 并把新增后的值返回
     * @param: [key]
     * @param: [item]
     * @param: [by]
     * @return: double
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:25
     * @since: 1.0.0
     */
    public double hincr(String key, Object item, double by){
        return redisTemplate.opsForHash().increment(key, item, by);
    }
    
    /**
     * @description 递减
     * @param: [key]
     * @param: [item]
     * @param: [by]
     * @return: double
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:26
     * @since: 1.0.0
     */
    public double hdecr(String key, Object item, double by){
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /* ============= Set ==================*/
    /**
     * @description 根据 key 获取set中的所有值
     * @param: [key]
     * @return: java.util.Set<java.lang.Object>
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:29
     * @since: 1.0.0
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @description 根据value 在 set 中查询是否存在.
     * @param: [key]
     * @param: [values]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:32
     * @since: 1.0.0
     */
    public boolean sHasKey(String key, Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * @description 将数据放入set缓存
     * @param: [key]
     * @param: [values]
     * @return: long 返回成功个数
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:35
     * @since: 1.0.0
     */
    public long sSet(String key, Object ... values){
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * @description 向set缓存中添加数据, 并设置过期时间
     * @param: [key]
     * @param: [values]
     * @param: [time]
     * @return: long
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:39
     * @since: 1.0.0
     */
    public long sSet(String key, long time, Object ... values){
        try {
            long count = redisTemplate.opsForSet().add(key, values);
            if(time > 0){
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * @description 获取名为key的Set缓存的长度
     * @param: [key]
     * @return: long 返回0说明获取错误
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:42
     * @since: 1.0.0
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    /**
     * @description 删除Set缓存中名为key的集合中的values值
     * @param: [key]
     * @param: [values]
     * @return: long
     * @author: Mr.xweiba
     * @date: 2018/5/24 17:44
     * @since: 1.0.0
     */
    public long sRemove(String key, Object ... values){
        try {
            long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*========== list ===================*/
    /**
     * @description 获取list缓存的内容
     * @param: [key]
     * @param: [start] 开始下标
     * @param: [end] 结束下标
     * @return: java.util.List<java.lang.Object>
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:17
     * @since: 1.0.0
     */
    public List<Object> lGet(String key, long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 获取指定list长度
     * @param: [key]
     * @return: java.lang.long
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:18
     * @since: 1.0.0
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @description 通过索引获取list缓存key中的值
     * @param: [key]
     * @param: [index] index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return: java.lang.Object
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:21
     * @since: 1.0.0
     */
    public Object lGetIndex(String key, long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 添加list类型缓存
     * @param: [key]
     * @param: [value]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:25
     * @since: 1.0.0
     */
    public boolean lSet(String key, Object value){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 添加list类型缓存, 并设置过期时间
     * @param: [key]
     * @param: [value]
     * @param: [time] 过期时间单位秒
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:25
     * @since: 1.0.0
     */
    public boolean lSet(String key, Object value, long time){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if(time>0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 更新list缓存中的key集合中下标为index的值
     * @param: [key]
         * @param: [index]
         * @param: [value]
     * @return: boolean
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:27
     * @since: 1.0.0
     */
    public boolean lUpdateIndex(String key, long index, Object value){
        try {
            redisTemplate.opsForList().set(key,index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description 删除list缓存中key集合count个值为value的值
     * @param: [key]
         * @param: [count]
         * @param: [value]
     * @return: long
     * @author: Mr.xweiba
     * @date: 2018/5/24 19:32
     * @since: 1.0.0
     */
    public long lRemove(String key, long count, Object value){
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
