package com.service;

import com.model.Student;
import com.model.zhiwei;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    List<zhiwei> findAlls();
    int findName();
   zhiwei addlist(zhiwei zhi);
}
