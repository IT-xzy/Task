package com.ptteng.service.Impl;

import com.ptteng.dao.OccupationDao;
import com.ptteng.dao.StudentsDao;
import com.ptteng.model.Occupation;
import com.ptteng.model.Student;
import com.ptteng.redis.Redis;
import com.ptteng.service.OccupationService;
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
    Redis redis;
    @Autowired
    SerializableUtilForRedis serializableUtilForRedis;

    Logger logger = Logger.getLogger(OccupationServiceImpl.class);

    @Override
    public List<Occupation> get() throws Exception {

        List<Occupation> occupations= null;
        byte[] value =redis.get("home3");
        if (value != null){
            occupations= (List<Occupation>) serializableUtilForRedis.deSerializable(value);
            logger.info("The date of home3 gets from Redis. ");
        }else {
            occupations = occupationDao.getAll();
            value = serializableUtilForRedis.enSerializable(occupations);
            redis.save("home3".getBytes(), value);
            logger.info("The date of home3 gets from MySQL. " );
        }
        return occupations;
    }

    @Autowired
    StudentsDao studentsDao;
    public List<Student> get1() throws  Exception{
        List<Student> students= null;
        byte[] value = redis.get("home1");
        if (value != null){
            students= (List<Student>) serializableUtilForRedis.deSerializable(value);
            logger.info("The date of home1 gets from Redis. ");
        }else {
            students = studentsDao.getall();
            value = serializableUtilForRedis.enSerializable(students);
            redis.save("home1".getBytes(), value);
            logger.info("The date of home1 gets from MySQL. " );
        }
        return students;
    }
}
