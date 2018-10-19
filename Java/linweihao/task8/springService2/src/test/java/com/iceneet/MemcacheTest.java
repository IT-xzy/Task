package com.iceneet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iceneet.dao.SignupDao;
import com.iceneet.service.Signupservice1;
import com.iceneet.untils.SerializeUntils;
import com.weihao.entity.Signup;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-redis.xml"})
public class MemcacheTest {
    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private RedisTemplate template;

    @Autowired
    private Signupservice1 signupservice1;

    @Autowired
    private SignupDao signupDao;


    @Test
    public void memcachetest() throws InterruptedException, MemcachedException, TimeoutException {
        Object o = memcachedClient.get("cctv");
        List list = new ArrayList();
        list.add(o);
        System.out.println(list.size());
    }

    @Test
    public void redisTest() throws JsonProcessingException {
        List<Signup> list = signupDao.selectSignup(0,10);
        byte[] b = SerializeUntils.serializeList(list);
        template.opsForValue().set("test",b,50,TimeUnit.SECONDS);
//        RedisUntils.SetByte(template,"world",b,50);
//        byte[] bt = (byte[]) RedisUntils.GetByte(template,"world");
//        List<Signup> l2 = (List<Signup>) SerializeUntils.unserializeList(bt);
//        List<Signup> l2 = (List<Signup>) template.opsForValue().get("test");
//        System.out.println(l2);
    }

}
