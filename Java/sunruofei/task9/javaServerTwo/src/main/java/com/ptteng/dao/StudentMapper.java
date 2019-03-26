package com.ptteng.dao;

import com.ptteng.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentMapper {

    List<Student> selectAll();
}
