package com.DAO;

import com.Student.Student;

import java.util.List;

public interface StudentMapper {
    public Student findStudentById(int id);
    public List<Student> findStudentByname(String name);
    public void addStudent(Student student);
    public boolean deleteStudnetById(int id);
    public boolean updateStudnet(Student student);
    public List<Student> selectAllStudent();
}
