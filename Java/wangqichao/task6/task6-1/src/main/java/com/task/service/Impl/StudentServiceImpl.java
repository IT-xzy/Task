package com.task.service.Impl;

import com.task.cache.RedisCacheManager;
import com.task.dao.StudentDao;
import com.task.models.Student;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
@Autowired
    private StudentDao studentDao;
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);
    @Autowired
    RedisCacheManager redisCacheManager;
    long exp=3600L;
    @Override
    public int justAdd(Student student) throws Exception {
       studentDao.addStudent(student);
       return student.getId();
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Boolean justUpdate(Student student) throws Exception {
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

    @Override
    public List<Student> justList(String name) throws Exception {
        List<Student> list=studentDao.getByName(name);
        return list;
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
