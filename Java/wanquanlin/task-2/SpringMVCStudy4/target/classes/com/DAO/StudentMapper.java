package com.DAO;

import com.POJO.Student;

import javax.naming.Name;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface StudentMapper {

    Student findUserById(Long ID) throws IOException;//查询
//    List<Student> findAll(Page page) throws IOException;//查询
    List<Student> findAll(HashMap<String,Object> map);
//    List<Student> findUserByName(String name)throws IOException;
    List<Student> findUserByName(HashMap<String,Object> map)throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    int insertUser(Student student) throws  Exception;//增加
    int deleteUser(int id) throws  Exception;//删除指定id的记录
    int updateUser(Student student) throws Exception;//更改指定id的数据
     int selectCount();
    int selectCount2(String name);

}
