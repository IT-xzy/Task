package com.task.service;

import com.task.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    //增
   int justAdd(Student student)throws Exception;
   //删，理论无用
   Boolean justDelete(int id)throws Exception;
    //更新
    Boolean justUpdate(Student student)throws Exception;
    //通过id查询
    Student justListById(int id) throws Exception;
    //通过用户名查询
    Student justListByUsername(String username) throws Exception;
    //通过学号查询，理论无用
    Student justListByStuID(int stuID) throws Exception;
    //查询总信息数
    int listCount()throws Exception;
    //查询在学弟子数
    int listIsStudy()throws Exception;
    //查询各职业在学弟子数
    int listIsStuByPro(String profession)throws Exception;
}
