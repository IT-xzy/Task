package com.myitschool.redisUtil;

import com.myitschool.serializeUtil.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import xin.xihc.utils.common.CommonUtil;

import java.util.List;

public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;//使用泛型
    /**
     * 设置对象
     *
     * @param key
     * @param obj
     */
    public void setObject(String key, Object obj) {
        try {
            obj = obj == null ? new Object() : obj;
            redisTemplate.opsForValue().set(key, SerializeUtil.serialize(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象
     *
     * @param key
     * @return Object
     */
    public Object getObject(String key) {
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        //有误，不能强制转换
        byte[] data = (byte[])redisTemplate.opsForValue().get(key);
        return (Object) SerializeUtil.unserialize(data);
    }

    /**
     * 设置List集合
     *
     * @param key
     * @param list
     */
    public void setList(String key, List<?> list) {
        try {

            if (CommonUtil.isNotNullEmpty(list)) {
                redisTemplate.opsForValue().set(key, SerializeUtil.serializeList(list));
            } else {//如果list为空,则设置一个空
                redisTemplate.opsForValue().set(key, "".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取List集合
     *
     * @param key
     * @return
     */
    public List<?> getList(String key) {
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        byte[] data = (byte[])redisTemplate.opsForValue().get(key);
        return SerializeUtil.unserializeList(data);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }
}
