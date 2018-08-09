package org.alien.mybatis.samples.service;

import org.alien.mybatis.samples.model.Student;

/**
 * @author lihoo
 * @Title: StudentService
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1214:40
 */


public interface StudentService {

    int addStudent(Student student);

    int deleteStudent(int id);

    int updateStudent(Student student);

    Student getStudentById(int id);

    Student getStudentByName(String username);
}
