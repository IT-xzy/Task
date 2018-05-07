package com.ssm_yl.serviceImpl;

import com.ssm_yl.category.Category;


import com.ssm_yl.mapper.Mapper;
import com.ssm_yl.service.CategoryService;


import com.ssm_yl.util.RedisUtil;
//import com.ssm_yl.util.XmemcachedUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ServiceImpl implements CategoryService {
    @Autowired
    Mapper mapper;
//    @Autowired
//    XmemcachedUtil xmemcachedUtil;
    //不能使用new
//    XmemcachedUtil xmemcachedUtil = new XmemcachedUtil();
    @Autowired
    RedisUtil redisUtil;

    public List<Category> list() {
        return mapper.list();
    }

    public Category select(int id) {
       //不使用缓存
//        return mapper.select(id);
        //使用memcached缓存
//        String str = String.valueOf(id);
//        if(xmemcachedUtil.get(str)==null) {
//
//            xmemcachedUtil.set(str,0,mapper.select(id));
//
//            return xmemcachedUtil.get(str);
//
//            }
//        else return xmemcachedUtil.get(str);

//        使用Redis缓存
        long expireTme= 86400;
        String str = String.valueOf(id);
        if(redisUtil.get(str)==null){
            redisUtil.set(str,mapper.select(id),expireTme);
            return (Category) redisUtil.get(str);
        }
        else return (Category) redisUtil.get(str);
    }

    public void insertCategory(Category category) {
         mapper.insertCategory(category);
    }

    public void delete(int id) {
         mapper.delete(id);
    }

    public int update(Category category) {
        System.out.println(category.toString());
        return mapper.update(category);
    }

}
