package com.jnshu.service;

import com.jnshu.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentService {
    List<Student> all();

    int count();

int number();
  int java();
}
