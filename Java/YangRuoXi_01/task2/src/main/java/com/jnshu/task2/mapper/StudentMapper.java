package com.jnshu.task2.mapper;

import com.jnshu.task2.beans.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {

    boolean batchUpdate(Map<String, Object> map);

    void addStu(Student student);

    boolean updateStuTypeById(Student student);

    Student selectStuById(Integer id);

    boolean delStuById(Integer id);

    List<Student> selectStuAll();

    Student selectStuByName(String name);

    Student selectStuByOnlineNumber(Integer onlineNumber);

    List<Student> selectStuByPage(Integer start,Integer pageSize);

}
