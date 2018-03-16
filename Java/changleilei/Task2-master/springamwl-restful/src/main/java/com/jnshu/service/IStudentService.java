package com.jnshu.service;

import com.jnshu.model.Student;

import java.io.IOException;
import java.util.List;

public interface IStudentService {
    public int insertStudent(Student student) throws IOException;

    public List<Student> getAllStudent() throws IOException;

    public int deleteStudent(int id) throws IOException;

    public Student getStudentById(int id) throws IOException;

    public int updateStudent(Student student) throws IOException;

    public int countStudentById(int id) throws IOException;

    public int countAll() throws IOException;

}