package com.tools;

import com.dao.PttDao;
import com.exception.MyException;
import com.pojo.Profession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisUtil {
    @Autowired
    private RedisTemplate<String, List<Profession>> redisTemplate1;
    @Autowired
    private RedisTemplate<String, String> redisTemplate2;
    @Autowired
    private PttDao pttDao;
    private Logger logger = Logger.getLogger(MemcachedUtil.class.getName());

    public int[] getSum() throws MyException {
        //从redis里面查询
        List<Profession> professions = redisTemplate1.opsForValue().get("professions");
        if (professions != null) {
            int studentSum = 0;
            int graduateSum = 0;
            for (Profession profession : professions) {
                studentSum += profession.getStu_number();
                graduateSum += profession.getGra_number();
            }
            int[] sum = {studentSum, graduateSum};
            logger.info("从redis取出数据：" + professions);
            return sum;
        }
        //redis没有的话从数据库查询
        professions = pttDao.findProfessions();
        if (professions != null) {
            int studentSum = 0;
            int graduateSum = 0;
            for (Profession profession : professions) {
                studentSum += profession.getStu_number();
                graduateSum += profession.getGra_number();
            }
            int[] sum = {studentSum, graduateSum};
            //查询就结果放入redis
            redisTemplate1.opsForValue().set("professions", professions);
            logger.info("数据放入redis：" + professions);
            return sum;
        }
        return null;
    }

    public List<Profession> getProfessions() throws MyException {
        //从redis里面查询
        List<Profession> professions = redisTemplate1.opsForValue().get("professions");
        if (professions != null) {
            logger.info("从redis取出数据：" + professions);
            return professions;
        }
        //redis没有的话从数据库查询
        professions = pttDao.findProfessions();
        if (professions != null) {
            //查询就结果放入redis
            redisTemplate1.opsForValue().set("professions", professions);
            logger.info("数据放入redis：" + professions);
            return professions;
        }
        return null;
    }

    public String getString(String strName) {
        return redisTemplate2.opsForValue().get(strName);
    }

    public void setString(String strName, String strValue) {
        redisTemplate2.opsForValue().set(strName, strValue);
    }

    public void setString(String strName, String strValue, long time) {
        redisTemplate2.opsForValue().set(strName, strValue, time, TimeUnit.SECONDS);
    }

    public void deleteObject(String strName) {
        redisTemplate1.delete(strName);
        logger.info("从redis删除" + strName);
    }

}
