package com.iceneet.service.impl;

import com.iceneet.dao.SignupDao;

import com.iceneet.service.Signupservice1;
import com.weihao.entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("service")
public class Sigupserviceimpl implements Signupservice1 {

    @Autowired(required = false)
    private  SignupDao signupDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Signup> getSignupByPage(int start, int limit) {
        ArrayList IdList = new ArrayList();
        List<Signup> List2 = new ArrayList<Signup>();
        if (redisTemplate.opsForValue().get(String.valueOf(start)+"page")!=null){
            IdList = (ArrayList) redisTemplate.opsForValue().get(String.valueOf(start)+"page");
            for (int i = 0; i <IdList.size() ; i++) {
                List2.add((Signup) redisTemplate.opsForValue().get(String.valueOf(IdList.get(i))));
            }
            System.out.println("缓存存在");
        }else {
            List2 = signupDao.selectSignup(start,limit);
            for (Signup s:List2){
                IdList.add(s.getId());
                redisTemplate.opsForValue().set(String.valueOf(s.getId()),s,500, TimeUnit.SECONDS);
            }
            redisTemplate.opsForValue().set(String.valueOf(start)+"page",IdList,500,TimeUnit.SECONDS);
            System.out.println("缓存不存在");
        }
        return List2;
    }
    //  单个查询
    public Signup GetSignupById(long id){
        String ids = String.valueOf(id);
        Signup signup = (Signup) redisTemplate.opsForValue().get(ids);
        if (signup!=null){
            System.out.println("有缓存");
            return signup;
        }else {
            signup=signupDao.GetSignupById(id);
            if (signup!=null){
                redisTemplate.opsForValue().set(ids,signup,60*50,TimeUnit.SECONDS);
            }else {
//                memcachedClient.set(ids,60*5,null);
                redisTemplate.opsForValue().set(ids,"empty",60*5,TimeUnit.SECONDS);
            }
        }

        return signupDao.GetSignupById(id);
    }
    //更新
    public int updateByPrimaryKey(Signup signup) {
        int result = signupDao.updateByPrimaryKey(signup);
//        memcachedClient.set(String.valueOf(signup.getId()),60*12,signup);
        redisTemplate.opsForValue().set(String.valueOf(signup.getId()),signup,60*12,TimeUnit.SECONDS);
        return result;
    }

    public int InsertSign(Signup signup)  {
//        memcachedClient.flushAll();
        redisTemplate.delete("0page");
        return signupDao.insertSignup(signup);
    }

    public List<Signup> getSignAll(){
        return signupDao.GetSignAll();
    }

    public int DeleteById(long id) {
        redisTemplate.delete(String.valueOf(id));
        int result = signupDao.deleteSignupById(id);
        redisTemplate.delete("0page");
        return result;
    }

}
