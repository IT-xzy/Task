package com.jnshu.tools;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class Redis {


    ApplicationContext build = new ClassPathXmlApplicationContext("spring-redis.xml");

    RedisTemplate redisTemplate = (RedisTemplate) build.getBean("redisTemplate");

//    @Autowired
//    private RedisTemplate redisTemplate;


    /**
     * 缓存
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> ValueOperations<String, T> setCacheObject(String key, T value) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return operations;
    }

    public <T> ValueOperations<String, T> setCacheObject(String key, T value,long time) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        operations.set(key, value,time, TimeUnit.MINUTES);
        System.out.println("以"+key+"保存验证码"+value+"，有效期为"+time+"分钟");
        return operations;
    }



    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public <T> T getCacheObject(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        T s;
        try {
             s = operation.get(key);
            System.out.println("缓存"+key+s);
        }catch (Exception e){
            return (T) "f";
        }
        return s;
    }

    /**
     * 缓存list
     *
     * @param key
     * @param dataList 要缓存的list
     * @return 缓存的对象
     */
    public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {

            listOperation.rightPush(key, dataList);
        }


        return listOperation;
    }


    /**
     * 获取缓存list
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getCacheList(String key) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();

        dataList = (List<T>) listOperation.leftPop(key);

        return dataList;
    }

    /**
     * 获取缓存list
     *
     * @param
     * @param
     * @return
     */
    public Object getCacheList(List<String> keyList) {
        List<Object> dataList = new ArrayList<>();
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        try {
            for (int i = 0; i < keyList.size(); i++) {

                Object data = operation.get(keyList.get(i));
                if (data != null) {
                    dataList.add(data);
                }
            }

            if (dataList.size() < keyList.size() - 5) {
                return 0;
            } else if (dataList.size() == keyList.size()) {
                return dataList;
            } else {
                return 1;
            }

        } catch (Exception e) {
            return 0;
        }

    }


    public void delCache(String key) {
        redisTemplate.delete(key);
    }






}


