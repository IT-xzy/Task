package com.tiles.dao.mapper;

import com.tiles.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    Student findByID(int id);

    int findAllCount();

    List<Student> findByStudent(Student student);

    List<Student> findByPage(HashMap<String,Object> map);

    List<Student> findAll();

    int insertOne(Student student);

}
