package com.task.service.impl;


import com.task.dao.StudentDao;
import com.task.entity.Student;
import com.task.service.StudentService;
import com.task.util.StudentPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentDao studentDao;


    public List<Student> findById(int id) {

        logger.info("id:"+id);

        List<Student> students = studentDao.findById(id);

        System.out.println(students);
        if(students != null){

            return students;
        }
        return null;
    }


    public List<Student> findByName(String name) {

        logger.info("name:"+name);
        List<Student> students = studentDao.findByName(name);
        if(students != null){

            return students;
        }
        return null;
    }


    public List<Student> findByNumber(int number) {

        logger.info("number:"+number);
        List<Student> students = studentDao.findByNumber(number);
        if(students != null){

            return students;
        }
        return null;
    }


    public void delete(Student student){
        logger.info("student:"+student);

        studentDao.delete(student.getId());
    }


    public List<Student> findByPage(StudentPage studentpage) {

        logger.info("page:");

        List<Student> students = null;

        students = studentDao.findByPage(studentpage);

        return students;
    }


    public int total() {
        int realTotal = studentDao.total();

        logger.info("total:"+realTotal);

        return realTotal;
    }
}
