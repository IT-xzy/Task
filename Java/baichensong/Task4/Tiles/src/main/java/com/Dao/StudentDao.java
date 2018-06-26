package com.Dao;

import com.model.Student;
import com.model.zhiwei;

import java.util.List;

public interface StudentDao {
     List<Student> findAll() ;
     List<zhiwei> findAlls();
     int findName();
     zhiwei addlist(zhiwei zhi);
}
