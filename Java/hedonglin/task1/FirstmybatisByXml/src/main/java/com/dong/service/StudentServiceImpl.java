package com.dong.service;


import com.dong.dao.StudentDao;
import com.dong.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//创建子实现类，覆盖了接口中所有的抽象方法
@Service
public class StudentServiceImpl implements StudentService{
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);

  @Autowired
    private StudentDao studentDao;


    @Override
    public Student selectStudentById(Integer id) {
        long start = System.currentTimeMillis();
        Student student = studentDao.selectStudentById(id);
        long end = System.currentTimeMillis();
        logger.info("删除数据用时：" + (end - start) + "ms");
        return student;


    }

    @Override
    public Student selectStudentByStudentId(Integer studentId) {
        return studentDao.selectStudentByStudentId(studentId);
    }

    @Override
    public Student selectStudentByStudentName(String studentName) {
        return studentDao.selectStudentByStudentName(studentName);
    }

    @Override
    public boolean updateStudent(Student student) {
//        boolean check = false;
//        if (studentDao.updateStudent(student) != 0) {
//            check = true;
//        }
//        return check;
    return  studentDao.updateStudent(student);
    }


    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public Integer deleteStudentById(Integer id) {
        return studentDao.deleteStudentById(id);
    }


}
