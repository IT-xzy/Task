package spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.StudentDao;
import spring.model.Student;
import spring.service.IstudentService;
import utils.Redis;
import java.util.List;

@Service
public class StudentService implements IstudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private Redis redis;

    Logger logger = Logger.getLogger(StudentService.class);

    @Override
    public List<Student> getGood() {
        if(redis.get("goodStudent")!=null){
            logger.error("缓存中获取Good学员");
            return (List<Student>) redis.get("goodStudent");
        }else {
            logger.error("添加好学生到缓存");
            redis.set("goodStudent",studentDao.getGood());
            return studentDao.getGood();
        }
    }

    @Override
    public int getOffer() {
        if(redis.get("offerStudent")!=null){
            logger.error("在缓存中获取有工作人数");
            return (Integer) redis.get("offerStudent");
        }else {
            logger.error("把数据放到缓存");
            redis.set("offerStudent",studentDao.getOffer());
            return studentDao.getOffer();
        }
    }

    @Override
    public int getAll() {
        if(redis.get("studentNumber")!=null){
            logger.error("在缓存中获取所有人数");
            return (Integer) redis.get("studentNumber");
        }else {
            logger.error("把数据放到缓存");
            redis.set("studentNumber",studentDao.getAll());
            return studentDao.getAll();
        }
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public int getJava() {
        if(redis.get("javaNumber")!=null){
            logger.error("在缓存中获取Java人数");
            return (Integer) redis.get("javaNumber");
        }else {
            logger.error("把数据放到缓存");
            redis.set("javaNumber",studentDao.getJava());
            return studentDao.getJava();
        }
    }

    @Override
    public int getWeb() {
        if(redis.get("webNumber")!=null){
            logger.error("在缓存中取web人数");
            return (Integer) redis.get("webNumber");
        }else {
            logger.error("把数据放到缓存");
            redis.set("webNumber",studentDao.getWeb());
            return studentDao.getWeb();
        }
    }

    @Override
    public int getPm() {
        if(redis.get("pmNumber")!=null){
            logger.error("在缓存中获取pm人数");
            return (Integer)redis.get("pmNumber");
        }else {
            logger.error("把数据放到缓存");
            redis.set("pmNumber",studentDao.getPm());
            return studentDao.getPm();
        }

    }

    @Override
    public Student getStudentByName(String name) {
        if(redis.get("getStudent"+name)!=null){
            logger.error("在缓存中获得个人主页信息");
            return (Student) redis.get("getStudent"+name);
        }else {
            logger.error("个人信息放入缓存");
            redis.set("getStudent"+name,studentDao.getStudentByName(name));
            return studentDao.getStudentByName(name);
        }
    }

    @Override
    public boolean selectByName(String name) {
        return studentDao.selectByName(name);
    }

    @Override
    public void updateByName(Student student) {
        studentDao.updateByName(student);
    }
}
