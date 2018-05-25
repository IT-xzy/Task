package com.task.service.Impl;

import com.task.cache.SpyMemcachedManager;
import com.task.dao.StudentDao;
import com.task.models.Student;
import com.task.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    private ApplicationContext app=new ClassPathXmlApplicationContext("app-context-spymemcached.xml");;
    private SpyMemcachedManager memcachedManager=(SpyMemcachedManager) app.getBean("memcachedManager");;
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);
    private static int exp=60*1000;
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
        //首先在缓存中查询是否有这个键值对，如果有直接取出来
        Student student;
        if (memcachedManager.get("student"+id)!=null){
            student=(Student)memcachedManager.get("student"+id);
            logger.info("取出缓存"+id);
        }else{
            student=studentDao.getStudent(id);
            memcachedManager.set("student"+id,student,exp);
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
        if(memcachedManager.get("listcount")!=null){
            count=(int)memcachedManager.get("listcount");
            logger.info("取出缓存总数");
        }else {
            count=studentDao.selectCount();
            memcachedManager.set("listcount",count,exp);
            logger.info("存入缓存总数");
        }
        return count;
    }

    @Override
    public int listIsStudy() throws Exception {
        int count;
        if(memcachedManager.get("liststudy")!=null){
            count=(int)memcachedManager.get("liststudy");
            logger.info("取出缓存学生总数");
        }else {
            count=studentDao.selectIsStudy();
            memcachedManager.set("liststudy",count,exp);
            logger.info("存入缓存学生总数");
        }
        return count;

    }

    @Override
    public int listIsStuByPro(String profession) throws Exception {
        int count;
        if(memcachedManager.get("stucount"+profession)!=null){
            count=(int)memcachedManager.get("stucount"+profession);
            logger.info("取出缓存职业在学数"+profession);
        }else {
            count=studentDao.selectIsStuByPro(profession);
            memcachedManager.set("stucount"+profession,count,exp);
            logger.info("存入缓存职业在学数"+profession);
        }
        return count;
    }
}
