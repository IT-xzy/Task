package com.task1.dao;

import com.task1.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //增
    long add(Student student) throws SQLException;

    //删
    boolean delete(long id) throws SQLException;

    //改
    boolean update(Student student) throws SQLException;

    //查

    //根据名字查询
     List showOneN(String name) throws SQLException;

    //根据学号查询
    Student showOneI(String id_num) throws SQLException;

    //查询全部
    List<Student> showAll() throws SQLException;
}
