package com.ptt.dao;

import java.io.Serializable;

/**
 * @ClassName: RedisDao
 * @Description: 消息发布
 * @Author: Jin
 * @CreateDate: 2018/6/10 20:52
 * @Version: 1.0
 */
public interface RedisDao {
    void sendMessage(String channel, Serializable message);//发布消息
}
