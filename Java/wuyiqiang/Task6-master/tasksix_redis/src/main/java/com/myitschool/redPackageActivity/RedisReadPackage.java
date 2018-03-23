package com.myitschool.redPackageActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisReadPackage {

    @Autowired
    private ReadPackage readPackage;

    @Autowired
    private RedisTemplate redisTemplate;

    public static String UNUSEDLIST = "unusedReadPackage";
    public static String USEDLIST = "usedReadPackage";
    public static String CUSTOMERLIST = "customer";

    public void init() {
        redisTemplate.delete(UNUSEDLIST);
        redisTemplate.delete(USEDLIST);
        redisTemplate.delete(CUSTOMERLIST);
    }

    public void setUnusedReadPackageList() {
        while (!readPackage.isEmpty()) {
            redisTemplate.opsForList().leftPush(UNUSEDLIST, readPackage.getRandomMoney());
        }
    }

    public String grabReadPackage(int id) {
        String msg = "错亿";
        if (0 != redisTemplate.opsForList().size(UNUSEDLIST) && !redisTemplate.opsForSet().isMember(CUSTOMERLIST, id)) {
            double money = Double.parseDouble((redisTemplate.opsForList().rightPop(UNUSEDLIST)).toString());
            redisTemplate.opsForSet().add(CUSTOMERLIST, id);
            redisTemplate.opsForList().leftPush(USEDLIST, id + "_" + money);
//            System.out.println(redisTemplate.opsForSet().pop(CUSTOMERLIST));
//            System.out.println(redisTemplate.opsForList().range(USEDLIST, 0 ,-1));
            msg =  "恭喜" + id + "用户抽到" + money + "元红包！";
        }
        return msg;
    }
}
