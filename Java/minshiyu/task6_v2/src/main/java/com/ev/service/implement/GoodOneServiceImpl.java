package com.ev.service.implement;

import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import com.ev.service.GoodOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodOneServiceImpl implements GoodOneService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private GoodOneDAO goodOneDAO;


    @Override
    public List<GoodOne> selectGoodOne() throws Exception {
        return null;
    }

    @Override
    public void add(GoodOne goodOne) {
        // TODO Auto-generated method stub
        /*
         * boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
         * public Boolean doInRedis(RedisConnection redisConnection) throws
         * DataAccessException { RedisSerializer<String> redisSerializer =
         * redisTemplate .getStringSerializer(); byte[] key =
         * redisSerializer.serialize(user.getId()); byte[] value =
         * redisSerializer.serialize(user.getName()); return
         * redisConnection.setNX(key, value); } }); return result;
         */
        ValueOperations<String, GoodOne> valueops = redisTemplate.opsForValue();
        valueops.set(goodOne.getId().toString(), goodOne);
    }

    @Override
    public Long addGoodOne(GoodOne goodOne) throws Exception {
        goodOne.setCreateAt(System.currentTimeMillis());
        return goodOneDAO.addGoodOne(goodOne);
    }
}
