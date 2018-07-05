package com.jnshu.service;
import com.jnshu.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> studentList();
    Student selectByName(String Name);
}
