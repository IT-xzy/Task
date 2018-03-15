package com.service;

import com.bean.GoodStudent;
import com.dao.GoodStudentDao;
import com.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 16:07
 */
@Service
public class GoodStudentServiceImpl implements IGoodStudentService {
    @Autowired
    GoodStudentDao goodStudentDao;
    @Autowired
    RedisUtil redisUtil;
    @Override
    @SuppressWarnings("unchecked")
    public List<GoodStudent> selectAll() {
        if(redisUtil.haskey("gs","sa")){
            return (List<GoodStudent>) redisUtil.get("gs","sa");
        }
        
        redisUtil.put("gs","sa",goodStudentDao.selectAll(),0L);
        return (List<GoodStudent>) redisUtil.get("gs","sa");
    }
    
    @Override
    public Integer count() {
        if(redisUtil.haskey("gs","ct")){
            return (Integer) redisUtil.get("gs","ct");
        }
        redisUtil.put("gs","ct",goodStudentDao.count(),0L);
        return (Integer) redisUtil.get("gs","ct");
    }
    
    @Override
    public Integer countGood() {
        if(redisUtil.haskey("gs","cg")){
            return (Integer) redisUtil.get("gs","cg");
        }
        redisUtil.put("gs","cg",goodStudentDao.countGood(),0L);
        return (Integer) redisUtil.get("gs","cg");
    }
}
