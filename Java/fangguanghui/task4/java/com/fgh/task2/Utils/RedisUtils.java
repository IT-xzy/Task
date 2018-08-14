package com.fgh.task2.Utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fgh.task2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RedisUtils {
    Logger logger=LoggerFactory.getLogger(RedisUtils.class);

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemp) {
        this.redisTemplate = redisTemp;
    }

    /**
     * key是否存在
     * @param key 键
     * @return
     * true 存在；false 不存在
     */
    public Boolean expKey(String key){
        try{
            return redisTemplate.hasKey(key);
    }catch (Exception e){
        e.getMessage();
        return false;
        }
    }


    /**
     * 设置key 过期时间
     * @param key
     *          键
     * @param time
     *          键值存在时间s
     * @return
     *          布尔型
     */

    public Boolean Extime(String key,Long time){
        try {
            redisTemplate.expire(key,time,TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加String key
     * @param key
     *          键
     * @param value
     *          Object 值
     * @return
     *          布尔型
     */
    public Boolean add(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 添加String key  并设置过期时间
     * @param key
     *          键
     * @param value
     *           Object 值
     * @param time
     *          过期时间s
     * @return
     */
    public Boolean add(String key,Object value,long time){
        try{
            redisTemplate.opsForValue().set(key, value, time,TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 删除key
     * @param key
     * @return
     */
//    使用String var args，您可以省略数组创建
//    就是一个String类型的可变长度的数组,
//    固定长度的数组是String[] str={};这样写,可变的就String... str.
    public Boolean delKey(String... key){
        if (key.length == 1){
            try{
                redisTemplate.delete(key[0]);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }else{
            try{
                //将key转换为数组
                List<String> keys=Arrays.asList(key);
                redisTemplate.delete(keys);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }

        }
    }

    /**
     * 获取key的内容
     * @param key
     * @return
     */
    public Object getkey(String key){
        try{
            Object object=redisTemplate.opsForValue().get(key);
            return object;
        }catch (Exception e){
            e.printStackTrace();
           return null;
        }
    }

//    /**
//     * list返回指定位置的元素
//     * index从0开始计数，0表示第一个元素，1表示第二个元素，以次类推。
//     *       也可以使用负数，-1表时倒数第一个元素，-2表时倒数第二个元素，以次类推
//     * @param key
//     *         列表key
//     * @param id
//     *         下标元素
//     * @return
//     */
//    public Boolean getListkey(String key,long id){
//        try{
//            redisTemplate.opsForList().index(key,id);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    /**
     * List 转换成Json  存储
     * @param userList
     * @param key
     * @return
     */
    public Boolean setJsonString(List<User> userList, String key){
            logger.debug("-----------进入 setJsonString 方法----------");
        try {
            logger.debug("将List转换成String");
            String jsonList=JSON.toJSONString(userList);
            logger.debug("存储String格式List");
            redisTemplate.opsForValue().set(key,jsonList);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取Json格式对象
     * @param key
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public Object getJsonString(String key,Class clazz){
        logger.debug("-----------进入 getJsonString 方法----------");
        try{
            logger.debug("获取String类");
            String getJsonList= (String) redisTemplate.opsForValue().get(key);
            logger.debug("getJsonList :"+getJsonList);
            logger.debug("类型转换");
            List<Object> list=JSONObject.parseArray(getJsonList,clazz);
            return list;
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

}
