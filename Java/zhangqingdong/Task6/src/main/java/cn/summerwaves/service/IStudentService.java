package cn.summerwaves.service;

import cn.summerwaves.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectThreeStudent();
    List<Student> selectThreeStudentFromDB();
    void insertStudent(Student student);

}


