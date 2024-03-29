package jnshu.dao;


import jnshu.pojo.Admin;
import jnshu.pojo.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {
    //插入，并返回主键插入
    Integer insertSTU(StudentInfo studentInfo)throws Exception;

    //按所给的ID删除一条记录
    void deleteByID(Integer id)throws Exception;

    //查询整个表，返回包含所有记录的结果集
    List<StudentInfo>listAll()throws Exception;

    //获取表中第(pageCount后+每页展示数)条记录
    List<StudentInfo> listTable(Integer id)throws Exception;

    //获取整张表条数
    int allCount()throws Exception;

    //按照所给的POJO对象里的ID更新，更改为POJO对象中其它字段的内容
    void updateByID(StudentInfo studentInfo)throws Exception;

    //姓名模糊查询，返回结果集
    List<StudentInfo> findByLikeName(String studentName)throws Exception;

    //按id精确查询，返回一条记录
    StudentInfo findByStudentID(Integer id)throws Exception;

    //注册账号
    Integer register(Admin admin)throws Exception;

    //验证模块
    Admin checkLogin(Admin admin)throws Exception;
}