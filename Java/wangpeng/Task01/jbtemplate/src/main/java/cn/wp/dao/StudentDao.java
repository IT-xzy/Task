package cn.wp.dao;

import cn.wp.po.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //增
    void add(Student student) throws SQLException;

    //改
    void update(Student student) throws SQLException;

    //删
    void delete(int ID) throws SQLException;

    //查询返回值类型为int的总记录数
    int findtotalCount();

    //查询指定id信息、查询所有信息
    Student findById(int Id) throws SQLException;

    //查询所有
    List<Student> findAll() throws SQLException;
}
