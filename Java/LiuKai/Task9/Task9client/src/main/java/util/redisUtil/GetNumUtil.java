package util.redisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetNumUtil {
    @Autowired
    RedisUtil redisUtil;

    /**
     * @Description 次数限制 过期时间10小时
     * @Param
     * @return 次数
     **/
    public int getRedisNum(String key) {
        if (redisUtil.getRedis(key) == null) {
            // 过期时间10小时，
            redisUtil.setRedis(key, 60*10,1);
            return (int) redisUtil.getRedis(key);
        } else {
            int i = (int) redisUtil.getRedis(key);
            i = i + 1;
            redisUtil.setRedis(key,60*10, i);
            return i;
        }
    }
}
