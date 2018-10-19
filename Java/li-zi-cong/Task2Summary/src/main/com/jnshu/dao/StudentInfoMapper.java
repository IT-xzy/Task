package main.com.jnshu.dao;

import main.com.jnshu.pojo.Admin;
import main.com.jnshu.pojo.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {
    //插入，并返回主键插入
    public Integer insertSTU(StudentInfo studentInfo)throws Exception;

    //按所给的ID删除一条记录
    public void deleteByID(Integer id)throws Exception;

    //查询整个表，返回包含所有记录的结果集
    public List<StudentInfo> listTable()throws Exception;

    //按照所给的POJO对象里的ID更新，更改为POJO对象中其它字段的内容
    public void updateByID(StudentInfo studentInfo)throws Exception;

    //姓名模糊查询，返回结果集
    public List<StudentInfo> findByLikeName(String studentName)throws Exception;

    //按id精确查询，返回一条记录
    public StudentInfo findByStudentID(Integer id)throws Exception;

    //注册账号
    public Integer register(Admin admin)throws Exception;

    //验证模块
    public Admin checkLogin(Admin admin)throws Exception;
}