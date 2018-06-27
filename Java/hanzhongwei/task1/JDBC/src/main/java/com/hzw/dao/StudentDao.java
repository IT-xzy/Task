package com.hzw.dao;

import com.hzw.pojo.Student;

import java.util.List;

public interface StudentDao {
    public long addStu(Student student);

    public void deleteStu(long s_id);

    public void updateStu(Student student);

    public Student getId(long s_id);

    public List<Student> getName(String s_name,int s_num);

    public List<Student> getAll();
}
