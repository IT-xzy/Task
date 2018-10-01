package com.jnshu.tiles.controller;

import com.jnshu.tiles.entity.User;
import com.jnshu.tiles.service.impl.MemcacheUserServiceImpl;
import com.jnshu.tiles.tools.MemcachedUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Tiles
 * @description: 缓存测试
 * @author: Mr.Lee
 * @create: 2018-07-12 10:20
 **/

@RestController
@RequestMapping("/mem")
public class MemcacheController {

    @Autowired
    MemcacheUserServiceImpl service;

    @GetMapping("/api/{id}")
    public Object findByKey(@RequestBody @PathVariable("id") String key) {
        if (ObjectUtils.isEmpty(MemcachedUtils.get(key))) {
            return "there is no data,please check your id!!";
        }
        return MemcachedUtils.get("user" + key);
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public Boolean insert(@PathVariable("id") String key, @RequestBody User user) {
        System.out.println(user.toString());
        user.setId(Integer.valueOf(key));
        if (ObjectUtils.isEmpty(MemcachedUtils.get(key))) {
            return false;
        }
        return MemcachedUtils.add("user" + key, user);
    }




}