package com.iceneet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iceneet.dao.SignupDao;
import com.iceneet.entity.Signup;
import com.iceneet.service.Signupservice;
import com.iceneet.untils.RedisUntils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-redis.xml"})
public class MemcacheTest {
    @Autowired
    private MemcachedClient memcachedClient;

//    @Autowired
//    private RedisTemplate template;

    @Autowired
    private Signupservice signupservice;

    @Autowired
    private SignupDao signupDao;


    @Test
    public void memcachetest() throws InterruptedException, MemcachedException, TimeoutException {
        System.out.println(signupservice.GetSignupById(1));
    }

//    @Test
//    public void redisTest() throws JsonProcessingException {
//        List<Signup> list = signupDao.selectSignup(0,10);
////        ObjectMapper mapper = new ObjectMapper();
////        String jsonInString = mapper.writeValueAsString(list);
////        template.opsForValue().set("hello",jsonInString);
//        byte[] b = RedisUntils.serializeList(list);
//        List<Signup> s = (List<Signup>) RedisUntils.unserializeList(b);
//        template.execute(new RedisCallback() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return redisConnection.setNX("ooo".getBytes(),b);
//            }
//        });
//       byte[] bt = (byte[]) template.execute(new RedisCallback() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return redisConnection.get("ooo".getBytes());
//            }
//        });
//        List<Signup> l2 = (List<Signup>) RedisUntils.unserializeList(bt);
//        System.out.println(l2);
//    }

}
