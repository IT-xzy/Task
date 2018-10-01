package com.impl;

import com.pojo.Profession;
import com.service.PttDaoService;
import com.tools.MemcachedUtil;
import com.tools.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PttDaoServiceImpl implements PttDaoService {
    @Autowired
    private MemcachedUtil memcached;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Profession findProfession(String professionName) {
//        return memcached.getProfession(professionName);
        return redisUtil.getProfession(professionName);
    }

    @Override
    public List<Profession> findAll() {
//        return memcached.getProfessions();
        return redisUtil.getProfessions();
    }
}
