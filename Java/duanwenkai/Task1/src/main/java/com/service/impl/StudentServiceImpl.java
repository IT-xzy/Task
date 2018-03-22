package com.service.impl;

import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/6 11:38
 * @version: [1.0]
 */

public class StudentServiceImpl implements StudentService {
    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

    private static ApplicationContext context;
    private static StudentDao studentDao;
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentDao = context.getBean(StudentDao.class);
    }
    /*@Autowired
    StudentDao studentDao;*/

    @Override
    public int add(Student student) {
        //System.out.println(studentDao);//NullPointerException,studentDao确实是null
        //必须在所有使用dao的地方，包括调用它的service都要进行@Autowired注入，否则之后的注入就会失败
        //不用注解了，直接读取配置文件，getBean
        //System.out.println(studentDao);
        studentDao.add(student);
        return student.getId();
    }

    @Override
    public String delete(int id) {
        int result = studentDao.delete(id);
        if (result == 1){
            logger.info("delete successfully");
            return "success";
        }
        logger.info("delete failed");
        return "fail";
    }

    @Override
    public String deleteAll() {
        int result = studentDao.deleteAll();
        if (result != 1){
            logger.info("delete successfully");
            return "success";
        }
        logger.info("delete failed");
        return "fail";
    }

    @Override
    public String update(Student student) {
        int result = studentDao.update(student);//返回0，但是更新成功了，并不是改动的记录数吗？
        System.out.println(result);
        if (result == 1){
            logger.info("update successfully");
            return "success";
        }else {
            logger.info("update failed");
            return "fail";
        }
    }

    @Override
    public Student selectById(int id) {
        //System.out.println(studentDao);  拿得到的呀
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> selectByName(String name) {
        List<Student> students = studentDao.selectByName(name);
        return students;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = studentDao.selectAll();
        return students;
    }

    @Override
    public int selectCount() {
        return studentDao.selectCount();
    }
}
