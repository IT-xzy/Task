package com.restful.dao.mapper;

import com.restful.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    Student selectById(int id);

    int selectConut();

    List<Student> findByStudent(Student student);

    List<Student> findByPage(HashMap<String,Object> map);

    int insertOne(Student student);

    int insertForList(List<Student> list);

    int deleteOne(int id);

    int deleteForList(List list);

    int updateOne(Student student);

    int updateForList(List<Student> list);


}
