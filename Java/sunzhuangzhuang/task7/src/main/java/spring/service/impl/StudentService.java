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
    private Redis redisStudent;

    Logger logger = Logger.getLogger(StudentService.class);


    @Override
    public List<Student> getGood() {
        if(redisStudent.get("goodStudent")!=null){
            logger.error("在缓存中取Good学员");
            return (List<Student>) redisStudent.get("goodStudent");
        } else {
            logger.error("添加好学生集合到缓存，返回数据库中的好学生");
            redisStudent.set("goodStudent",studentDao.getGood());
            return studentDao.getGood();
        }
    }

    @Override
    public int getOffer() {
        if(redisStudent.get("offerStudent")!=null){
            logger.error("在缓存中取有工作的人数");
            return (int) redisStudent.get("offerStudent");
        } else {
            logger.error("把数据放到缓存里面，返回数据库中的数据");
            redisStudent.set("offerStudent",studentDao.getOffer());
            return studentDao.getOffer();
        }
    }

    @Override
    public int getAll() {
        if(redisStudent.get("studentNumber")!=null){
            logger.error("在缓存里面取所有的人数");
            return (int) redisStudent.get("studentNumber");
        } else {
            logger.error("把数据放到缓存里，返回数据库中的数据。");
            redisStudent.set("studentNumber",studentDao.getAll());
            return studentDao.getAll();
        }
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public int getJava() {
        if(redisStudent.get("javaNumber")!=null){
            logger.error("在缓存里面取java的人数");
            return (int) redisStudent.get("javaNumber");
        } else {
            logger.error("把数据放到缓存里，返回数据库中的数据。");
            redisStudent.set("javaNumber",studentDao.getJava());
            return studentDao.getJava();
        }
    }

    @Override
    public int getWeb() {
        if(redisStudent.get("webNumber")!=null){
            logger.error("在缓存里面取web的人数");
            return (int) redisStudent.get("webNumber");
        } else {
            logger.error("把数据放到缓存里，返回数据库中的数据。");
            redisStudent.set("webNumber",studentDao.getWeb());
            return studentDao.getWeb();
        }
    }

    @Override
    public int getPm() {
        if(redisStudent.get("pmNumber")!=null){
            logger.error("在缓存里面取pm的人数");
            return (int) redisStudent.get("pmNumber");
        } else {
            logger.error("把数据放到缓存里，返回数据库中的数据。");
            redisStudent.set("pmNumber",studentDao.getPm());
            return studentDao.getPm();
        }
    }

    @Override
    public Student getStudentByName(String name) {
        if(redisStudent.get("getStudent"+name)!=null){
            logger.error("缓存获得个人主页");
            return (Student) redisStudent.get("getStudent"+name);
        }else {
            logger.error("个人信息放入缓存");
            redisStudent.set("getStudent"+name,studentDao.getStudentByName(name));
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
