package com.service;
import com.dao.StudentMapper;
import com.interceptor.RedisTool;
import com.interceptor.RedisUtil;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
redis缓存设置；
添加了AOP切面
做了缓存的保护： 防止缓存穿透，防止有效期集中到期的缓存雪崩；
 */

@Service
public class IMStudentService implements IFStudentService {
    @Autowired
    private StudentMapper studentMapper;
    //声明一个redis的工具类
    private RedisUtil redisUtil;
    //声明一个日志
    private static org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(IMStudentService.class);
    //设置分钟(我redis设置的timeout是单位是s)
    private final static long min=60;
    //设置小时
    private final static long hour=min*60;
    //设置天
    private final static long day=hour*24;
    //设置月
    private final static long mouth=day*30;
    //设置空缓存有效时间：3min
    private final static long temporary=min*3;
    //生成一个15到30天到随机数
    private long ranTime=(long)(15*day+Math.random()*(30*day-15*day+1));
    //设置一个值，判断数据库是否被修改
    private boolean b=false;

    @Override
    public Student findStudentById(long id) {
        logger.info("com.server.findStudentById 的入参是long id = "+id);
        Student student;
        boolean i= RedisTool.rdGetKey(id+"");
        logger.info("查看id值是否存在"+i);
        if(i){
            logger.info("能拿到这个id的名字的key，缓存中有该key");
            return (Student) RedisTool.rdGet(id+"");
        }else {
            logger.info("不能拿到这个id的名字的key,缓存中没有该key");
            student=studentMapper.selectStudentById(id);
            if (student==null){
                logger.info("查询到的字段是空值，设置一个短暂的空值的key-value");
                RedisTool.rdSet(id+"",null,temporary);
                return null;
            }else {
                logger.info("查询到的字段非空，设置一个较长时间的key-value");
                RedisTool.rdSet(id+"",student,ranTime);
                logger.info("直接返回数据库查询结果");
                return student;
            }

        }

    }

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    //数据层返回的是一个int值，在这里对int值判断，返回一个布林值。
    public boolean inputStudent(Student student) {
        b=true;
        return studentMapper.insertStudent(student) !=0;
    }

    @Override
    public boolean outputStudentById(long id) {
        b=true;
        studentMapper.deleteStudentById(id);
        if (RedisTool.rdGetKey("id")){
            logger.info("删除的该学生有缓存，删除缓存");
            RedisTool.rdDel("id");
            return b;
        }else {
            logger.info("删除的该学生无缓存，不需要删除缓存，直接返回");
            return b;
        }

    }

    @Override
    public boolean replayStudent(Student student) {
        return studentMapper.updateStudentById(student) !=0;
    }

    @Override
    public List<Student> findStudent() {
        List<Student> students;
        if (b){
            logger.info("数据发生增删改，查找数据库，重新添加全表的缓存");
            students=studentMapper.selectStudent();
            if (students==null){
                logger.info("该值为空，添加一个短暂的key-value");
                RedisTool.rdSet("students",students,temporary);
                return students;
            }else {
                logger.info("查找了数据库，值存在，添加了长期缓存，直接返回数据库查询结果");
                RedisTool.rdSet("students",students,ranTime);
                return students;
            }

        }else {
            logger.info("数据库没有发生增删修，先查找缓存");
            if (RedisTool.rdGetKey("students")){
                logger.info("缓存中查询全表的key存在，直接调用该key");
                return (List<Student>) RedisTool.rdGet("students");

            }else{
                logger.info("缓存中查询全表的key不存在");
                students =studentMapper.selectStudent();
                if (students==null){
                    logger.info("该值为空，添加一个短暂的key-value");
                    RedisTool.rdSet("students",students,temporary);
                    return students;
                }else {
                    RedisTool.rdSet("students",students,ranTime);
                    logger.info("查找了数据库，值存在，添加了长期缓存，直接返回数据库查询结果");
                    return students;
                }

            }

        }


    }
}
