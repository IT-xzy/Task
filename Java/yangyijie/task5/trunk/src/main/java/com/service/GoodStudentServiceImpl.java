package com.service;

import com.bean.GoodStudent;
import com.dao.GoodStudentDao;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author Arike
 * Create_at 2017/12/28 16:07
 */
@Service
public class GoodStudentServiceImpl implements IGoodStudentService {
    @Autowired
    GoodStudentDao goodStudentDao;
    @Autowired
    MemcachedClient memcachedClient;
    @Override
    public List<GoodStudent> selectAll() {
        try {
            if(null==memcachedClient.get("selectAll")){
                memcachedClient.set("selectAll", 60 * 60, goodStudentDao.selectAll());
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        try {
            return memcachedClient.get("selectAll");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return goodStudentDao.selectAll();
    }
    
    @Override
    public Integer count() {
        try {
            if(null == memcachedClient.get("count") || !(memcachedClient.get("count") instanceof Integer)){
                memcachedClient.set("count",60*60,goodStudentDao.count());
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        try {
            return memcachedClient.get("count");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return goodStudentDao.count();
    }
    
    @Override
    public Integer countGood() {
        try {
            if(null == memcachedClient.get("count")){
                memcachedClient.set("count",60*60,goodStudentDao.countGood());
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        try {
            return memcachedClient.get("countGood");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return goodStudentDao.countGood();
    }
}
