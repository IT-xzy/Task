package com.iceneet.service.impl;

import com.iceneet.dao.SignupDao;
import com.iceneet.entity.Signup;
import com.iceneet.service.Signupservice;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class Sigupserviceimpl implements Signupservice{

    @Autowired(required = false)
    private  SignupDao signupDao;

    @Autowired
    private MemcachedClient memcachedClient;


    public List<Signup> getSignupByPage(int start,int limit) throws InterruptedException, MemcachedException, TimeoutException, NotSerializableException {
        ArrayList IdList = new ArrayList();
        List<Signup> List2 = new ArrayList<Signup>();
        List2 = signupDao.selectSignup(start,limit);

        if (memcachedClient.get(String.valueOf(start)+"page")!=null){
            IdList = memcachedClient.get(String.valueOf(start)+"page");
            System.out.println(IdList.size());
            for (int i = 0; i <IdList.size() ; i++) {
                List2.add(memcachedClient.get(String.valueOf(IdList.get(i))));
            }
            System.out.println("缓存存在");
        }else {
            System.out.println("缓存不存在");
            List2 = signupDao.selectSignup(start,limit);
            for (Signup s:List2) {
                IdList.add(s.getId());
                memcachedClient.set(String.valueOf(s.getId()),500,s);
            }
            memcachedClient.set(String.valueOf(start)+"page",500,IdList);
        }
        return List2;
    }
    //  单个查询
    public Signup GetSignupById(long id) throws InterruptedException, MemcachedException, TimeoutException {
        String ids = String.valueOf(id);
        Signup signup = memcachedClient.get(ids);
        if (signup!=null){
            return signup;
        } else if ("empty".equals(memcachedClient.get(ids))) {
            return null;
        } else {
            signup = signupDao.GetSignupById(id);
            if (signup != null) {
                memcachedClient.set(ids, 60 * 50, signup);
            } else {
                memcachedClient.set(ids, 60 * 5, "empty");
            }
        }
        return signup;
    }
    //更新
    public int updateByPrimaryKey(Signup signup) throws InterruptedException, MemcachedException, TimeoutException {
        int result = signupDao.updateByPrimaryKey(signup);
        memcachedClient.set(String.valueOf(signup.getId()),60*12,signup);
        return result;
    }

    public int InsertSign(Signup signup) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.flushAll();
        return signupDao.insertSignup(signup);
    }

    public List<Signup> getSignAll(){
        return signupDao.GetSignAll();
    }

    public int DeleteById(long id) throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.delete(String.valueOf(id));
        int result = signupDao.deleteSignupById(id);
        memcachedClient.delete("0page");
        return result;
    }


}
