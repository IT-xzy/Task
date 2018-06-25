package com.task.dao;

import com.task.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentDao {
    int selectCount();//查询总记录数
    Boolean addStudent(Student student);//注册是添加信息
    Boolean deleteStudent(int id);//删除信息，理论上无用
    Boolean updateStudent(Student student);//用于后续更新资料
    Student getStudent(int id);//根据id查找
    int selectIsStudy();//统计在学数量
    int selectIsStuByPro(String profession);//根据职业统计在学弟子数量
    Student getByStuID(int stuID);//根据学号查找，理论上无用
    Student getByUsername(String username);//根据用户名查找

}
