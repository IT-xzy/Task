package com.ptt.dao.impl;

import com.ptt.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName: RedisDaoImpl
 * @Description: 发布者
 * @Author: Jin
 * @CreateDate: 2018/6/10 20:55
 * @Version: 1.0
 */
@Component
public class RedisDaoImpl implements RedisDao {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
