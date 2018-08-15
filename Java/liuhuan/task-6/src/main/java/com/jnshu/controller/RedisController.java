package com.jnshu.controller;

import com.jnshu.model.UserCustom;
import com.jnshu.tools.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

/**
 * @program: taskTwo
 * @description: Redis 缓存接口
 * @author: Mr.xweiba
 * @create: 2018-05-23 17:30
 **/
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    RedisUtils redisUtils;

    private static Logger logger = LoggerFactory.getLogger(MemCacheController.class);

    // 原生接口性能测试
    @RequestMapping(value = "/gety", method = RequestMethod.GET)
    @ResponseBody
    public String getyRedis() throws Exception {
        Jedis jedis = new Jedis("localhost");
        return jedis.get("user1");
    }

    /**
     * @Description: 获取key为id的user缓存
     * @Param: [key]
     * @return: java.lang.Object
     * @Author: Mr.Wang
     * @Date: 2018/5/19
     */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object findByKey(@RequestBody @PathVariable("id") String key){
        if(StringUtils.isEmpty(key)){
            return "key must not be empty or null!";
        }
        return redisUtils.get("user" + key);
    }


    /**
     * @Description: 增加缓存数据 当键存在时取消存入
     * @Param: [key, userCustom] 键, 值
     * @return: java.lang.Boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/19
     */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Boolean insert(@PathVariable("id") String key, @RequestBody UserCustom userCustom){
        userCustom.setId(Integer.valueOf(key));
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return redisUtils.set("user" + key, userCustom);
    }

    /**
     * @Description: 删除指定key
     * @Param: [key]
     * @return: java.lang.Boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/19
     */
    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteByKey(@PathVariable("id") String key){
        if(StringUtils.isEmpty(key)){
            return false;
        }
        return redisUtils.expire("user" + key);
    }

    @RequestMapping(value = "/api/all", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean flashAll() throws Exception {
        logger.info("redis 缓存已清理");
        redisUtils.expire("userAll");
        return redisUtils.expire("user42");
    }
}
