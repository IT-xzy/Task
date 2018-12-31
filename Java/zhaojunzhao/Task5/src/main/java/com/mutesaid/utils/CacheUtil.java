package com.mutesaid.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class CacheUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static CacheUtil cacheUtil;

    private static Logger logger = LogManager.getLogger(CacheUtil.class);

    @PostConstruct
    public void init() {
        cacheUtil = this;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getList(String key, Supplier<List<T>> supplier) {
        logger.info("select data from cache: key = [{}]", key);
        try {
            List<T> result = (List<T>) cacheUtil.redisTemplate.opsForList().range(key, 0, -1);
            if (result == null || result.size() == 0) {
                logger.info("first select set in cache");
                List<T> dbResult = supplier.get();
                set(key, dbResult);
                return dbResult;
            } else {
                logger.info("select from cache");
                return result;
            }
        } catch (Throwable t) {
            logger.info("cache error, select from DB");
            return supplier.get();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List getList(String key, Function<String, List<T>> function) {
        logger.info("select data from cache: key = [{}]", key);
        try {
            List<T> result = (List<T>) cacheUtil.redisTemplate.opsForList().range(key, 0, -1);
            if (result == null || result.size() == 0) {
                logger.info("first select set in cache");
                List<T> dbResult = function.apply(key);
                set(key, dbResult);
                return dbResult;
            } else {
                logger.info("select from cache");
                return result;
            }
        } catch (Throwable t) {
            logger.info("cache error, select from DB");
            return function.apply(key);
        }
    }

    private static <T> void set(String key, List<T> obj) {
        obj.forEach(item -> cacheUtil.redisTemplate.opsForList().rightPush(key, item));
    }
}
