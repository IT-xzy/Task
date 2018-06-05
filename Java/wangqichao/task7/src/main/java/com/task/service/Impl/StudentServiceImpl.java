package com.task.service.Impl;

import com.task.cache.RedisCacheManager;
import com.task.dao.StudentDao;
import com.task.models.Student;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentDao studentDao;
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);
    @Resource
    RedisCacheManager redisCacheManager;
    long exp=3600L;
    @Override
    public int justAdd(Student student) throws Exception {
       logger.info("进入service层");
       studentDao.addStudent(student);
       logger.info("插入成功");
       return student.getId();
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Boolean justUpdate(Student student) throws Exception {
        student.setUpdatedAt(System.currentTimeMillis());
        return studentDao.updateStudent(student);
    }

    @Override
    public Student justListById(int id) throws Exception {
        Student student;
        if(redisCacheManager.get("student"+id)!=null){
         student=(Student) redisCacheManager.get("student"+id);
            logger.info("取出缓存"+id);
        }else{
            student=studentDao.getStudent(id);
           redisCacheManager.set("student"+id,student,exp);
            logger.info("存入缓存"+id);
        }
        return student;
    }

    /**
     * 按照用户名取出数据，因为要实时刷新不涉及缓存
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Student justListByUsername(String username) throws Exception {
        Student student;
//        if(redisCacheManager.get("username")!=null){
//            student=(Student) redisCacheManager.get("username");
//            logger.info("取出缓存总数");
//        }else {
            student=studentDao.getByUsername(username);
//            redisCacheManager.set("username",student,exp);
//            logger.info("存入缓存总数");
//        }
        return student;
    }

    @Override
    public Student justListByStuID(int stuID) throws Exception {
        return studentDao.getByStuID(stuID);
    }

    @Override
    public int listCount() throws Exception {
        int count;
        if(redisCacheManager.get("listcount")!=null){
            count=(int)redisCacheManager.get("listcount");
            logger.info("取出缓存总数");
        }else {
            count=studentDao.selectCount();
            redisCacheManager.set("listcount",count,exp);
            logger.info("存入缓存总数");
        }
        return count;
    }

    @Override
    public int listIsStudy() throws Exception {
        int count;
        if(redisCacheManager.get("liststudy")!=null){
            count=(int)redisCacheManager.get("liststudy");
            logger.info("取出缓存学生总数");
        }else {
            count=studentDao.selectIsStudy();
            redisCacheManager.set("liststudy",count,exp);
            logger.info("存入缓存学生总数");
        }
        return count;
}

    @Override
    public int listIsStuByPro(String profession) throws Exception {
        int count;
        if(redisCacheManager.get("stucount"+profession)!=null){
            count=(int)redisCacheManager.get("stucount"+profession);
            logger.info("取出缓存职业在学数"+profession);
        }else {
            count=studentDao.selectIsStuByPro(profession);
            redisCacheManager.set("stucount"+profession,count,exp);
            logger.info("存入缓存职业在学数"+profession);
        }
        return count;

    }
}
