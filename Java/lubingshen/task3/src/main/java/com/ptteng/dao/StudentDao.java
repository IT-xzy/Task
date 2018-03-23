package com.ptteng.dao;

import com.ptteng.bean.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    //查询记录总条数
    public int selectCount();
    //分页查询
    public List<Student> findByPage(HashMap<String,Object> map);
    //根据id查询用户信息
    public Student findById(long id) throws Exception;
    //根据姓名模糊查询
    public List<Student> findByName(String name) throws Exception;
    //根据学号精确查询
    public Student findByNum(String num) throws Exception;
    //***********前方高能，注意神坑************
    //mybatis的版本若是太低，只能接受Integer类型的返回类型！高版本则不受影响！！！！
    //添加用户信息
    public boolean insertStudent(Student stu) throws Exception;
    //删除用户信息
    public boolean deleteStudent(long id) throws Exception;
    //更新用户信息
    public boolean updateStudent(Student stu) throws Exception;
}
