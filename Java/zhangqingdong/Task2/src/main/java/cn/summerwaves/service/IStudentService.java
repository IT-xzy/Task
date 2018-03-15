package cn.summerwaves.service;

import cn.summerwaves.model.Student;

import java.io.IOException;
import java.util.List;

/**
 * Created by summerwaves on 2017/9/11.
 */
public interface IStudentService {
    void insertStudent(Student student) throws IOException;
    List<Student> getAllStudent() throws IOException;
    void deleteStudent(int id) throws IOException;
    Student getStudentById(int id) throws IOException;
    void updateStudent(Student student) throws IOException;
}
