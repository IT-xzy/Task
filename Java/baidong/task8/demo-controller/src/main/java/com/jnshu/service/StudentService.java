package com.jnshu.service;

import com.jnshu.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
       List<Student> selectAll();
}
