package com.service;

import com.dao.StudentMapper;
import com.pojo.Student;
import com.tools.Memcache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class IMStudentService implements IFStudentService {
    @Autowired
    StudentMapper studentMapper;
    private static Logger logger=Logger.getLogger(IMStudentService.class);
    //设置正常缓存失效期时间常量（单位是ms）(1000ms * 60s * 60min *24h * n day)
    //设置分钟
    private final static long min=1000*60;
    //设置小时
    private final static long hour=min*60;
    //设置天
    private final static long day=hour*24;
    //设置月
    private final static long mouth=day*30;
    //设置空缓存有效时间：3min
    private final static long temporary=min*3;
    //设置一个值，判断数据库是否被修改
    private boolean b=false;
    //生成一个15到30天到随机数
    private long ranTime=(long)(15*day+Math.random()*(30*day-15*day+1));

    @Override
    //通过id查找学生
    public Student findStudentById(long id) {
        Student student;

        //如果能添加这个key,key不存在，也就是该数据不存在，就去设置
        if (Memcache.addKey(String.valueOf(id),"空",temporary)){
            logger.info("能add该key的缓存，那么缓存中没有这个key，查找数据库去添加这个key到缓存中");
            student=studentMapper.selectStudentById(id);
            logger.info("数据库执行了");
            if(student==null){
                //这个key查找到值是空，数据库没有对应数据，返回一个空值，并且添加该key的值为string的"空"（这个工具不能存空值）
                logger.info("缓存穿透，直接返回空值；在判的时候就已经为这类型的key存了一个固定值用于断后续判断");
                return null;
            }else {
                //缓存雪崩一般有三种情况，这里设置一个随机有效期，防止第三种：大量缓存同时到期；
                logger.info("数据库有对应的数据，设置较长的随机有效期键值对");
                Memcache.setKey(id+"",student,ranTime);
                return student;
            }
        }else /* 不能添加这个key,key存在，那么直接返回这个key*/{
            //缓存中有该key对应的数据，返回这个数据；空值应对穿透，有数据的应对正常请求
            if("空".equals(Memcache.getKey(String.valueOf(id)))){
                logger.info("该key数据库中没有，返回null");
                return null;
            }else {
                logger.info("该key存在缓存中，从缓存中调用该key-value");
                return (Student) Memcache.getKey(id+"");
            }

        }
    }

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    //增加学生
    public boolean inputStudent(Student student) {
        b=true;
        logger.info("增加了一行学生");
        return studentMapper.insertStudent(student) !=0;
    }

    @Override
    //通过id删除学生
    public boolean outputStudentById(long id) {
        studentMapper.deleteStudentById(id);
        b=true;
        if (Memcache.getKey(id+"")==null){
            logger.info("删除行，不需要删除缓存，直接返回");
            return b;
        }else {
            logger.info("该学生行有缓存，删除该缓存");
            return Memcache.deleteKet(id+"");
        }
    }

    @Override
    public boolean replayStudent(Student student) {
        b=true;
        logger.info("对某个学生行进行了修改");
        studentMapper.updateStudentById(student);
        return Memcache.deleteKet(student.getId()+"");
    }

    @Override
    //查找全表
    public List<Student> findStudent() {
        List<Student> students;
        if(b){
            logger.info("成员发生增删改，需要重新设置全表缓存");
            students =studentMapper.selectStudent();
            Memcache.setKey("students",students,ranTime);
            logger.info("调用了数据库，重设缓存之后，直接返回数据库IO结果");
            return students;
        }else {
            logger.info("成员变量没有变化，根据缓存状态判断执行");
            if(Memcache.addKey("students","准备重置你",temporary)){
                logger.info("缓存没有对应的key-value,查找数据库，进行缓存设置");
                students=studentMapper.selectStudent();
                if(students==null){
                    logger.info("防止缓存击穿，保存返回的空值和key到缓存");
                    Memcache.setKey("students",null,temporary);
                    return null;
                }else {
                    logger.info("缓存中有对应的key,保存缓存");
                    Memcache.setKey("students",students,ranTime);
                    return students;
                }
            }else {
                logger.info("缓存中有对应的key,调用缓存，返回结果");
                return (List<Student>) Memcache.getKey("students");
            }
        }
    }

}
