package com.ptteng.service.Impl;

import com.ptteng.dao.OccupationDao;
import com.ptteng.dao.StudentsDao;
import com.ptteng.model.Occupation;
import com.ptteng.model.Student;
import com.ptteng.service.OccupationService;
import com.ptteng.util.RedisUtil;
import com.ptteng.util.SerializableUtilForRedis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("occupationServiceImpl")
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    OccupationDao occupationDao;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    SerializableUtilForRedis serializableUtilForRedis;

    Logger logger = Logger.getLogger(OccupationServiceImpl.class);

    @Override
    public List<Occupation> get() throws Exception {

        List<Occupation> occupations= null;
        List<Occupation> value = (List<Occupation>) redisUtil.get("home2");

        if (null != value){
            occupations = value;
            System.out.println((null != value));
            logger.info("The date of home2 gets from Redis. ");
            return occupations;
        }
        occupations = occupationDao.getAll();
        redisUtil.set("home2", occupations);
        logger.info("The date of home2 gets from MySQL. ");
        return occupations;
    }

    @Autowired
    StudentsDao studentsDao;
    public List<Student> get1() throws  Exception{
        List<Student> students= null;
        List<Student> value = (List<Student>) redisUtil.get("home1");
        if (value != null){
            students= value;
            logger.info("The date of home1 gets from Redis. ");
        }else {
            students = studentsDao.getall();
            redisUtil.set("home1", students);
            logger.info("The date of home1 gets from MySQL. " );
        }
        return students;
    }
}
