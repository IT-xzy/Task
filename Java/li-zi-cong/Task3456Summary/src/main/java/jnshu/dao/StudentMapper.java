package jnshu.dao;

import jnshu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //    Student
    Student findByStudentID(int id);

    int insertStudent(Student record);

    int insertSelectiveStudent(Student record);


    List<Student> listStudent()throws Exception;

    List<Student> listExcellent()throws Exception;
}
