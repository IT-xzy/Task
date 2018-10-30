package com.ptteng.dao;

import com.ptteng.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

//    @Insert("insert into student (name,QQ,wish,createAt,updateAt) values (#{name},#{QQ},#{wish},#{createAt},#{updateAt})")
//   设置返回主键id
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    long insertStudent(Student student);

    List<Student> findAll();

    boolean updateStudent(Student student);

    boolean deleteStudent(long id);

    Student findById(long id);
}
