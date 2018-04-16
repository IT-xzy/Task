package com.DAO;

import com.POJO.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    //根据id查询用户信息
    public Student findUserById(int id) throws Exception;
    //根据用户名模糊查询
//    public List<Student> findUserByName(String name) throws Exception;
    List<Student> findAll(HashMap<String,Object> map);
    List<Student> findUserByName(HashMap<String,Object> map)throws IOException;
    //添加用户信息
    public int insertUser(Student student) throws Exception;
    //删除用户信息
    public int deleteUser(int id) throws Exception;
    //更新用户信息
    public int updateUser(Student student) throws Exception;
    int selectCount();
    int selectCount2(String name);
}
