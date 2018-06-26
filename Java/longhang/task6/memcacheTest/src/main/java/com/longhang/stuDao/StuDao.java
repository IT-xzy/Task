
package com.longhang.stuDao;


import com.longhang.model.Curriculum;
import com.longhang.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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
    int getMajor(String major);

    void insertCu(Curriculum curriculum);//添加课程
    Curriculum selectCu(Long id);//获取课程
    boolean updateCu(Curriculum curriculum);//修改课程
    boolean updateCuByName(@Param("name") String name, @Param("onnum") int onnum);//根据名字修改课程在学人数
    boolean deleteCu(Long id);//删除课程
    List<Curriculum> getAllCu();//获取课程
    ArrayList<String> getAllCuName();//获取课程名





}
