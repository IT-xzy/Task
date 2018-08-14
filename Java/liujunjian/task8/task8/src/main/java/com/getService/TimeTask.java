package com.getService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class TimeTask {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ServiceFactory serviceFactory;

    public void setState() {
        try {
            serviceFactory.getEmptyService1().test();
        } catch (Exception e) {
            redisTemplate.opsForValue().set("service1","false");
        }
        try {
            serviceFactory.getEmptyService2().test();
        } catch (Exception e) {
            redisTemplate.opsForValue().set("service2","false");
        }
    }
}
