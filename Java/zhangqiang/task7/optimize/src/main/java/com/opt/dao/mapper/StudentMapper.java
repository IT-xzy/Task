package com.opt.dao.mapper;

import com.opt.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface StudentMapper {

    Student findByID(int id);

    int findAllCount();

    List<Student> findByStudent(Student student);

    List<Student> findByPage(HashMap<String, Object> map);

    List<Student> findAll();

    int insertOne(Student student);

    int updateOne(Student student);

    int updateHeadIcoById(Map<String,Object> map);

}
