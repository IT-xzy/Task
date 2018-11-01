package com.lyh.dao;

import com.lyh.pojo.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentDao {
    //接口写curd方法
    public int insert(Student student);
    public boolean insertBatch(Student student);
    public boolean delete(int id);
    public boolean update(Student student);
    public void selectByIdAndName(String name, int id);
    public List<Student> selectAll();
}
