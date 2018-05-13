package com.fangyuyang.Dao;

import com.fangyuyang.model.Student;

import java.util.List;

public interface StudentDao {
    public void add(Student student);
    public void delete(int id);
    public Student get(int id);
    public void update(Student student);
    public List<Student> list();

}
