package com.jnshu.dao;

import com.jnshu.model.StudentNum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SNDao")
public interface StudentNumMapper {
    StudentNum selectByPrimaryKey(Integer id);
    List<StudentNum> listAll();

}