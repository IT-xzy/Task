package com.mapper;

import com.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper {
    //int deleteByPrimaryKey(Integer id);

    //动态查询，userName，phoneNumber,email

    int selectByUnique(Student student);


    int insert(Student record);

    //int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int selectByStatus(Integer status);

    List<Student> selectCollege();

    int selectByclass(String classname);

    Student selectByuserName(String userName);
}