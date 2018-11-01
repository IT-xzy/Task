package jnshu.service;

import jnshu.pojo.Student;

import java.util.List;

public interface StudentService {
    //    Student
    Student findByStudentID(int id);

    int insertStudent(Student record);

    int insertSelectiveStudent(Student record);


    List<Student> listStudent()throws Exception;

    List<Student> listExcellent()throws Exception;

}
