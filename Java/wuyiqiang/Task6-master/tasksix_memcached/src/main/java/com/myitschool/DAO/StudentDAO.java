package com.myitschool.DAO;

import com.myitschool.student.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    public List<Student> allStudent();
    public void insertStudent(Student student);
    public Student selectStudent(int id);
    public int deleteStudent(int id);
    public int updateStudent(Student student);
}
