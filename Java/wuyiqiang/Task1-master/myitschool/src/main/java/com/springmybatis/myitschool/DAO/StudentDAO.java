package com.springmybatis.myitschool.DAO;

import com.springmybatis.myitschool.student.Student;
import java.util.List;

public interface StudentDAO {
    public List<Student> allStudent();
    public void insertStudent(Student student);
    public Student selectStudent(int id);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
}
