package com.alibaba.service.impl;

import com.alibaba.utils.RedisUtil;
import com.alibaba.dao.StudentDao;
import com.alibaba.model.Student;
import com.alibaba.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = Logger.getLogger(StudentServiceImpl.class);
    @Resource
    private StudentDao studentDao;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<Student> studentList() {
        List<Student> studentList = (List<Student>) redisUtil.get("studentList");
        if (studentList != null) {
            //todo 从缓存读取数据
            logger.error("=============缓存=========");
//            for (Student studentOne : studentList) {
//                System.out.println(studentOne.toString());
//            }
            return studentList;
        } else {
            logger.error("==========数据库==========");
            //todo List<Student> userList = 从数据库取
            studentList = studentDao.selectAll();
            redisUtil.set("studentList", studentList, 60 * 60L);
        }
        //todo 业务逻辑
        return studentList;
    }

//    @Override
//    public Student selectByName(String name) {
//        Student student = null;
//        //todo 定义一个如果是数据库不存在的数据的签名，查询数据前，先查询这条缓存不存在
//        String namecheck = name + "nulls";
//        Boolean bool = redisUtil.haskey(namecheck);
//        //todo 如果缓存中存在该条空数据，就停止查询，直接向控制器返回空数据，让控制器处理视图
//        if (bool == true) {
//            return student;
//        } else {
//            //todo 如果缓存中不存在该条空数据，就从缓存中读取真实数据
//            student = (Student) redisUtil.get(name);
//            if (student == null) {
//                //todo 如果缓存中存在该条真数据，那就这直接返回 如果缓存中不存在该条数据，就去数据库查询是否存在此条记录
//                student = studentDao.selByName(name);
//                if (student != null) {
//                    //todo 如果数据库中存在真实的记录，那就将真实数据写入缓存
//                    redisUtil.set(name, student, 60l);
//                    logger.error("==========数据库真实记录==========" + student.getName());
//                } else {
//                    //todo 如果数据库表示此记录不存在，那么便向缓存写入空数据缓存，该缓存会在短时间后消失
//                    logger.error("=============空数据缓存=========" + namecheck);
//                    redisUtil.set(namecheck, student, 30l);
//                }
//            }
//        }
//        return student;
//    }
}
