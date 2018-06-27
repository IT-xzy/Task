package com.hzw.mapper;

import com.hzw.pojo.Student;
import com.hzw.util.Page;

import java.util.List;

public interface StudentMapper {
    void addStu(Student student);

    void deleteStu(long s_id);
//    boolean deleteStu(long s_id);

    void updateStu(Student student);
//    boolean updateStu(Student student);

    Student getId(long s_id);

    List<Student> getAll();

    List<Student> getName(Student stu);

    //增加total方法用于调用StudentMapper.xml 中total对应的sql语句
    //增加 getAll(Page page)，根据分页来查询数据
    /*List<Student> getAll(Page page);

    int total();*/
}
