package com.tools;

import com.dao.PttDao;
import com.pojo.Profession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Profession> redisTemplate;
    @Autowired
    private RedisTemplate<String, List<Profession>> redisTemplate1;
    @Autowired
    private PttDao pttDao;
    private Logger logger = Logger.getLogger(MemcachedUtil.class.getName());

    public Profession getProfession(String professionName) {
        try {
            //从redis里面查询
            Profession profession = redisTemplate.opsForValue().get(professionName);
            if (profession != null) {
                logger.info("从redis取出数据：" + profession.getProfession());
                return profession;
            }
            //redis没有的话从数据库查询
            profession = pttDao.findProfessionByName(professionName);
            if (profession != null) {
                //查询就结果放入redis
                redisTemplate.opsForValue().set(profession.getProfession(), profession);
                logger.info("数据放入redis：" + profession.getProfession());
                return profession;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Profession> getProfessions() {
        try {
            //从redis里面查询
            List<Profession> professions = redisTemplate1.opsForValue().get("professions");
            if (professions != null) {
                logger.info("从redis取出数据：" + professions);
                return professions;
            }
            //redis没有的话从数据库查询
            professions = pttDao.findProfessionNumber();
            if (professions != null) {
                //查询就结果放入redis
                redisTemplate1.opsForValue().set("professions", professions);
                logger.info("数据放入redis：" + professions);
                return professions;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteObject(String objectName) {
        try {
            redisTemplate.delete(objectName);
            logger.info("从redis删除" + objectName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public Boolean setObject(String name, Object object) {
//        redisTemplate.opsForValue().set(name, object);
//        return true;
//    }
//
//    public Object getObject(String objectName) {
//        return redisTemplate.opsForValue().get(objectName);
//    }
//
//    public Boolean deleteObject(String objectName) {
//        redisTemplate.delete(objectName);
//        return true;
//    }

}
