package com.lyh.service;

import com.lyh.entity.Student;
import com.lyh.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    //    数据条数
    public int total();
    //    增加学院数据
    public int addStudent(Student student);
    //    根据id删除数据
    public int deleteStudent(Long id);
    //    更新学员数据
    public int updateStudent(Student student);
    //    根据id查找信息
    public Student getStudent(Long id);
    //    查询全表数据
    public List<Student> listStudent();
    //    查询全表数据，数据分页
    public List<Student> listPageStudent(Page page);
    //根据名字模糊查询
    public List<Student> byName(String name);
}
