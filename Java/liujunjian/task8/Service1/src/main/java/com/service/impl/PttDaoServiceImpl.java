package com.service.impl;

import com.dao.PttDao;
import com.exception.MyException;
import com.pojo.Profession;
import com.service.PttDaoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;


public class PttDaoServiceImpl implements PttDaoService {
    @Autowired
    private RedisTemplate<String, List<Profession>> redisTemplate;
    @Autowired
    private PttDao pttDao;
    private Logger logger = Logger.getLogger(PttDaoServiceImpl.class.getName());

    private List<Profession> getFromRedis() {
        return redisTemplate.opsForValue().get("professions");
    }

    private void putIntoRedis(List<Profession> professions) {
        redisTemplate.opsForValue().set("professions", professions);
    }

    @Override
    public int getStudentSum() throws MyException {
        //从redis里面查询
        List<Profession> professions = getFromRedis();
        int studentSum = 0;
        if (professions != null) {
            for (Profession profession : professions) {
                studentSum += profession.getStu_number();
            }
            logger.info("从redis取出数据：" + professions);
            return studentSum;
        }
        //redis没有的话从数据库查询
        professions = pttDao.findProfessions();
        if (professions != null) {
            for (Profession profession : professions) {
                studentSum += profession.getStu_number();
            }
            //数据库查询就结果放入redis
            putIntoRedis(professions);
            logger.info("数据放入redis：" + professions);
            return studentSum;
        }
        return 0;
    }

    @Override
    public int getGraduateSum() throws MyException {
        //从redis里面查询
        List<Profession> professions = getFromRedis();
        int graduateSum = 0;
        if (professions != null) {
            for (Profession profession : professions) {
                graduateSum += profession.getGra_number();
            }
            logger.info("从redis取出数据：" + professions);
            return graduateSum;
        }
        //redis没有的话从数据库查询
        professions = pttDao.findProfessions();
        if (professions != null) {
            for (Profession profession : professions) {
                graduateSum += profession.getGra_number();
            }
            //查询就结果放入redis
            putIntoRedis(professions);
            logger.info("数据放入redis：" + professions);
            return graduateSum;
        }
        return 0;
    }

    @Override
    public List<Profession> getAllProfession() throws MyException {
        //从redis里面查询
        List<Profession> professions = getFromRedis();
        if (professions != null) {
            logger.info("从redis取出数据：" + professions);
            return professions;
        }
        //redis没有的话从数据库查询
        professions = pttDao.findProfessions();
        if (professions != null) {
            //查询就结果放入redis
            putIntoRedis(professions);
            logger.info("数据放入redis：" + professions);
            return professions;
        }
        return null;
    }

    @Override
    public List<String> getImageAddress() {
        List<String> list = new ArrayList<String>();
        list.add("../images/banner-1.jpg");
        list.add("../images/banner-2.jpg");
        list.add("../images/banner-3.jpg");
        list.add("../images/banner-4.jpg");
        return list;
    }
}
