package com.DAO;

import com.POJO.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    //根据id查询用户信息
    Student findUserById(Integer ID);
    //根据用户名模糊查询
//    public List<Student> findUserByName(String name) throws Exception;
    List<Student> findAll(HashMap<String, Object> map);
    List<Student> testJson();
    List<Student> findUserByName(HashMap<String, Object> map)throws IOException;
    //添加用户信息
    int insertUser(Student student) throws Exception;
    //删除用户信息
    int deleteUser(int id) throws Exception;
    //更新用户信息
    int updateUser(Student student) throws Exception;
    int selectCount();
    int selectCount2(String name);
}
