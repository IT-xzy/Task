package jnshu.taskeight.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-26
 * @Time: 下午 10:02
 * Description:
 **/

@Component("redisUtil")
public class RedisUtil {

    /**
     * 日志记录
     */
    private  static Logger logger = LoggerFactory.getLogger(RedisUtil.class);


    @Autowired
    RedisTemplate<String,String> redisTemplate;

//    public void setRedisTemplate(RedisTemplate<String,String> redisTemplate){
//        this.redisTemplate = redisTemplate;
//    }

    /**
     * 缓存value操作,存入string的值
     * @param k
     * @param v
     * @param time
     * @return
     */
    public  boolean setCacheValue(String k, String v, long time) {
        String key = k;
        try {
            ValueOperations valueOps =  redisTemplate.opsForValue();
            valueOps.set(key, v);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存value操作
     * @param k
     * @param v
     * @return
     */
    public  boolean setCacheValue(String k, String v) {
        return setCacheValue(k, v, -1);
    }

    /**
     * 判断缓存是否存在
     * @param k
     * @return
     */
    protected boolean containsValueKey(String k) {
        return containsKey( k);
    }

    /**
     * 判断缓存是否存在
     * @param k。
     * @return
     */
    protected boolean containsSetKey(String k) {
        return containsKey(k);
    }

    /**
     * 判断缓存是否存在
     * @param k
     * @return
     */
    protected boolean containsListKey(String k) {
        return containsKey(k);
    }

    protected boolean containsKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Throwable t) {
            logger.error("判断缓存存在失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    /**
     * 获取缓存
     * @param k
     * @return
     */
    public  String getValue(String k) {
        try {
            ValueOperations<String, String> valueOps =  redisTemplate.opsForValue();
            return valueOps.get(k);
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + k + ", error[" + t + "]");
        }
        return null;
    }

    /**
     * 移除缓存
     * @param k
     * @return
     */
    public  boolean removeValue(String k) {
        return remove(k);
    }

    public boolean removeSet(String k) {
        return remove(k);
    }

    public boolean removeList(String k) {
        return remove(k);
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    private  boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }
    /**
     * 缓存set操作
     * @param k
     * @param v
     * @param time
     * @return
     */
    public  boolean cacheSet(String k, String v, long time) {
        String key = k;
        try {
            SetOperations<String, String> valueOps =  redisTemplate.opsForSet();
            valueOps.add(key, v);
            if (time > 0){ redisTemplate.expire(key, time, TimeUnit.SECONDS);}
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @return
     */
    public  boolean cacheSet(String k, String v) {
        return cacheSet(k, v, -1);
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @param time
     * @return
     */
    public  boolean cacheSet(String k, Set<String> v, long time) {
        String key = k;
        try {
            SetOperations<String, String> setOps =  redisTemplate.opsForSet();
            setOps.add(key, v.toArray(new String[v.size()]));
            if (time > 0){ redisTemplate.expire(key, time, TimeUnit.SECONDS);}
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @return
     */
    public  boolean cacheSet(String k, Set<String> v) {
        return cacheSet(k, v, -1);
    }

    /**
     * 获取缓存set数据
     * @param k
     * @return
     */
    public  Set<String> getSet(String k) {
        try {
            SetOperations<String, String> setOps = redisTemplate.opsForSet();
            return setOps.members(k);
        } catch (Throwable t) {
            logger.error("获取set缓存失败key[" + k + ", error[" + t + "]");
        }
        return null;
    }

    /**
     * list缓存
     * @param k
     * @param v
     * @param time
     * @return
     */
    public boolean cacheList(String k, String v, long time) {
        String key = k;
        try {
            ListOperations<String, String> listOps =  redisTemplate.opsForList();
            listOps.rightPush(key, v);
            if (time > 0){ redisTemplate.expire(key, time, TimeUnit.SECONDS);}
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @return
     */
    public boolean cacheList(String k, String v) {
        return cacheList(k, v, -1);
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @param time
     * @return
     */
    public boolean cacheList(String k, List<String> v, long time) {
        String key = k;
        try {
            ListOperations<String, String> listOps =  redisTemplate.opsForList();
            long l = listOps.rightPushAll(key, v);
            if (time > 0) {redisTemplate.expire(key, time, TimeUnit.SECONDS);}
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @return
     */
    public boolean cacheList(String k, List<String> v) {
        return cacheList(k, v, -1);
    }

    /**
     * 获取list缓存
     * @param k
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String k, long start, long end) {
        try {
            ListOperations<String, String> listOps =  redisTemplate.opsForList();
            return listOps.range( k, start, end);
        } catch (Throwable t) {
            logger.error("获取list缓存失败key[" + k + ", error[" + t + "]");
        }
        return null;
    }

    /**
     * 获取总条数, 可用于分页
     * @param k
     * @return
     */
    public long getListSize(String k) {
        try {
            ListOperations<String, String> listOps =  redisTemplate.opsForList();
            return listOps.size(k);
        } catch (Throwable t) {
            logger.error("获取list长度失败key[" +  k + "], error[" + t + "]");
        }
        return 0;
    }

    /**
     * 获取总条数, 可用于分页
     * @param listOps
     * @param k
     * @return
     */
    public long getListSize(ListOperations<String, String> listOps, String k) {
        try {
            return listOps.size( k);
        } catch (Throwable t) {
            logger.error("获取list长度失败key[" + k + "], error[" + t + "]");
        }
        return 0;
    }

    /**
     * 移除list缓存
     * @param k
     * @return
     */
    public boolean removeOneOfList(String k) {
        String key =  k;
        try {
            ListOperations<String, String> listOps =  redisTemplate.opsForList();
            listOps.rightPop(k);
            return true;
        } catch (Throwable t) {
            logger.error("移除list缓存失败key[" +  k + ", error[" + t + "]");
        }
        return false;
    }
}