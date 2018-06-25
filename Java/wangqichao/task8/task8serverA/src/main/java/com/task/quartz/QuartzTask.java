package com.task.quartz;

import com.task.cache.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Quartz定时任务
 */
public class QuartzTask {
    @Autowired
    RedisCacheManager redisCacheManager;
    public void reportAlive(){
        //将其存入缓存，设置时间为3000毫秒过期
        redisCacheManager.set("serverA","alive",3);
        System.out.println("定时任务进行中");
    }
}
