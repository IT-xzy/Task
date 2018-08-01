package memcached;

import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import pojo.Student;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
public class StudentRedis {
    @Autowired
    RedisTemplate redisTemplate;

//     获取redis缓存
        public Object getRed(String str) {
            return redisTemplate.opsForValue().get(str);
                   }

//存储redis缓存
public void setRed(Object key,Object value){
    redisTemplate.opsForValue().set(key,value);
}
}
