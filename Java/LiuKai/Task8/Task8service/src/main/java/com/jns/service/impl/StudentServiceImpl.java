package com.jns.service.impl;

import com.jns.dao.StudentDao;
import com.jns.pojo.Student;
import com.jns.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
Logger logger=LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentDao studentDao;
    public List<Student> selectAll() {
        logger.info("service selectAll");
        return  studentDao.selectAll();
    }

    @Override
    public Student selectPhoneNum(String phoneNum) {
        return studentDao.selectPhoneNum(phoneNum);
    }

    @Override
    public Student selectStuName(String stuName) {
        return studentDao.selectStuName(stuName);
    }

    @Override
    public Student selectStuID(Integer StuID) {
        return studentDao.selectStuID(StuID);
    }

    /**
   * @Description 根据用户名 id phonenum查询
   * @Param
   * @return 单个学员
   **/
    @Override
    public Student selectWithNameIDPhoneNumPassWord(Student student) {
        return studentDao.selectWithNameIDPhoneNumPassWord(student);
    }

    /**
     * @Description 更新登陆时间
     * @Param 登陆时间 long
     * @return true/false
     **/
    @Override
    public boolean updateLoginTime(Student student) {

        return studentDao.updateLoginTime(student);
    }

    /**
     * @Description 更新学生信息
     * @Param 姓名 电话 密码 头像 email 更新时间
     * @return
     **/
    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    /**
     * @Description 注册学员 将注册时间 修改时间封装
     * @Param 姓名 密码 电话号码
     * @return 学员id
     **/
//    @Transactional
    public Integer signUpStudent(String stuName,String passoWord,String phoneNum) {
        Student student=new Student();
        long time=System.currentTimeMillis();
        student.setStuName(stuName);
        student.setPassWord(passoWord);
        student.setPhoneNum(phoneNum);
        student.setCreateTime(time);
        student.setUpdateTime(time);
        studentDao.signUpStudent(student);
        return student.getStuID();
    }

    @Override
    public int countAll() {
        return studentDao.countAll();
    }
    @Override
    public int countJob() {
        return studentDao.countJob();
    }

    @Override
    public int countCourse(String cour) {
        return studentDao.countCourse(cour);
    }

    @Override
    public List<Student> findGood() {
        return studentDao.findGood();
    }
}
