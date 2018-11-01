package com.lyh.mapper;



import com.lyh.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //接口写curd方法
    public Student selectById(int id);
    public List<Student> selectByName(String name);
    public void addStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(int id);
}
