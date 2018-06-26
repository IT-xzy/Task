
package com.longhang.stuDao;


import com.longhang.model.Student;

import java.util.List;

public interface StuDao
{

    void insert(Student student);//添加学生
    boolean update(Student student);//更新学生
    boolean delete(Long id);//删除学生
    Student select(Long id);//查询学生
    Student selects(Student student);
    List<Student> getAll() ;//学生表
    List<Student> getAllExcellent();//优秀学员
    int getCount();//获取总人数
    int getCountG();//工作人数
    int getMajor(String major);//获取课程在学人数
    String[] getPicture();//获取图片名称









}
