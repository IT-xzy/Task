package com.student;

import org.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.util.List;
@MapperScan
public interface StudentMapper {

    Student findUserById(int id) throws IOException;//查询
    List<Student> findUserByName(String name)throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
}
