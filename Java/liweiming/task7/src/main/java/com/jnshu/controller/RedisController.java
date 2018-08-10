package com.jnshu.controller;

import com.jnshu.entity.User;
import com.jnshu.tools.JedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

/**
 * @program: Tiles
 * @description: redis测试页面
 * @author: Mr.Lee
 * @create: 2018-07-18 10:13
 **/

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    JedisCache jedisCache;

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @GetMapping("/gety")
    public String getyRedis(){
        Jedis jedis = new Jedis("localhost");
        return jedis.get("user1");
    }

    @GetMapping("/api/{id}")
    public Object findByKey(@RequestBody @PathVariable("id") String key){
        if(StringUtils.isEmpty(jedisCache.get(key))){
            return "there is no data,please check your id!!";
        }
        Object msg = jedisCache.get("user" + key);
        return msg;
    }

    @PutMapping(value = "/api/{id}",produces = "application/json; charset=utf-8")
    public Boolean insert(@PathVariable("id") String key, @RequestBody User user){
        user.setId(Integer.valueOf(key));
        if(StringUtils.isEmpty(jedisCache.get(key))){
            return false;
        }
        return jedisCache.set("user" + key, user);
    }

    @DeleteMapping("/api/{id}")
    public Boolean deleteByKey(@PathVariable("id") String key){
        if(StringUtils.isEmpty(jedisCache.get(key))){
            return false;
        }else {
            return jedisCache.delete("user" + key);
        }
    }


}
