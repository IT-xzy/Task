package com.student.service.impl;

import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

//@Service(value = "studentServiceIpl")
public class StudentServiceIpl implements StudentService {
    private final Logger log = LoggerFactory.getLogger(StudentServiceIpl.class);

    @Resource
    private StudentDao studentDao;


    public int deleteByPrimaryKey(Long id) {
        return studentDao.deleteByPrimaryKey(id);
    }

    public int insert(Student student) {
        return studentDao.insert(student);
    }

    public int insertSelective(Student record) {
        return studentDao.insertSelective(record);
    }

    public Student selectByPrimaryKey(Long id) {
        log.info("传入的id为{}", id);
        Student student = studentDao.selectByPrimaryKey(id);
        log.info("查出学生值为{}", student);
        return student;
    }

    public int updateByPrimaryKeySelective(Student record) {
        return studentDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student student) {
        return studentDao.updateByPrimaryKey(student);
    }

    public List<Student> getAll() {
        return studentDao.getAll();
    }


    public List<Student> randomSelectStudent() {
        return studentDao.randomSelectStudent();
    }

    public Long selectIdByName(String name) {
        return studentDao.selectIdByName(name);
    }

    public Student selectByName(String name) {
        return studentDao.selectByName(name);
    }


//    public Long getIdByTokey(String token) throws Exception {
//        DesUtil desUtil = new DesUtil();
//        String s= desUtil.decrypt(token);
//        String[] idAndTime = s.split(",");
//        Long id = Long.valueOf(idAndTime[0]);
//        return id;
//    }
//
//    public String getTokenByName(String account) throws Exception {
//        Long longId = studentDao.selectIdByName(account);
//        Long longTime = System.currentTimeMillis();
//        String s = longId + "," + longTime;
//        DesUtil des = new DesUtil();
//        String token = des.encrypt(s);
//        return token;
//
//    }


    public void OSSToQiNiuYun() {


    }


}

