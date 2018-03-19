package com.student.service;

import com.student.dao.StudentDao;
import com.student.model.Student;

import com.student.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentServiceIpl")
public class StudentServiceIpl implements StudentService {

    private  Logger logger = LoggerFactory.getLogger(StudentServiceIpl.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private StudentDao studentDao;

    public int deleteByPrimaryKey(Long id){
        return studentDao.deleteByPrimaryKey(id);
    }

    public int insert(Student student){
        return studentDao.insert(student);
    }

    public int insertSelective(Student record){
        return studentDao.insertSelective(record);
    }

    public Student selectByPrimaryKey(Long id){
        return studentDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Student record){
        return studentDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student student){
        return studentDao.updateByPrimaryKey(student);
    }

    public List<Student> getAll(){
        return studentDao.getAll();
    }

//    public List<Student> useMemcacheGetStudentList()  {
//
//        try {
//            logger.error(memcachedClient.get("studentList")+"");
//            if (null!= memcachedClient.get("studentList") ) {
//                logger.info("直接从缓存拿的数据");
//                return memcachedClient.get("studentList");
//
//            } else {
//                List<Student> studentList=studentDao.getAll();
//                memcachedClient.set("studentList",3600000,studentList);
//                logger.info("从数据库拿的数据");
//                return studentList;
//            }
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }
//        logger.info("不存在这种的");
//        return null;
//    }
//
    public Object useRedisGetStudentList() {

        logger.info("检查key为studentList的值为{}",redisUtil.get("studentList"));
        if (redisUtil.get("studentList") != null) {
            logger.info("缓存有，直接从缓存拿");
            return redisUtil.get("studentList");

        } else {
            logger.info("缓存没有，从数据库中拿数据");
            List<Student> studentList = studentDao.getAll();
            logger.info("放一份去缓存中");
            redisUtil.set("studentList", studentList);
            return studentList;
        }
    }


    public Object useRedisGetStudent(Long id) {
        Object student = studentDao.selectByPrimaryKey(id);
        if (student!= null) {
            logger.info("数据库有，从数据库拿的");
            return studentDao.selectByPrimaryKey(id);

        } else {
            logger.info("数据库没有，防止缓存穿透");
            redisUtil.set("student", student);
            return redisUtil.get("student");
        }
    }
}
