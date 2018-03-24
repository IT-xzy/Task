package com.mybatis.itschool.DAO;

import com.mybatis.itschool.student.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> allStudent();
    public void insertStudent(Student student);
    public Student selectStudent(int qq);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
    public void batchInsert(List<Student> list);
}
