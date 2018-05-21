package com.dong.service;


import com.dong.dao.StudentDao;
import com.dong.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private Logger logger =Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;



    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudent();

    }

    @Override
   public Student selectStudentByStudentId(Integer studentId){
      return studentDao.selectStudentByStudentId(studentId);
    }


    @Override
    public Student selectStudentByStudentName(String studentName){
        return studentDao.selectStudentByStudentName(studentName);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudent(Student student){
       studentDao.updateStudent(student);
    }



    @Override
    public void deleteStudentById(Integer id){
        studentDao.deleteStudentById(id);
    }




//    public void setStudentDao(StudentDao StudentDao) {
//        studentDao = StudentDao;
//    }
//
//    public StudentDao getStudentDao() {
//        return studentDao;
//    }
}
