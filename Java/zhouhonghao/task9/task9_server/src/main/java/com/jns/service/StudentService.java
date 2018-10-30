package com.jns.service;


import com.jns.entity.Page;
import com.jns.entity.Student;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;
@Remotable
public interface StudentService {
    //定义方法，以便controller层的使用

    //添加学生
    void add(Student student);

    //根据id删除某个学生信息
    void delete(int id);

    //根据id获取某个学生信息
    Student get(int id);

    //更新学生信息
    void update(Student student);

    //获取所有学生信息
    List<Student> list();

    //总计
    int total();

    //展示当前页面的内容
    Page<Student> showByPage(int currPage);
}
