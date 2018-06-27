package com.task.dao;

import com.task.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentDao {
    int selectCount();//查询总记录数
    Boolean addStudent(Student student);
    Boolean deleteStudent(int id);
    Boolean updateStudent(Student student);
    Student getStudent(int id);
    int selectIsStudy();//统计在学数量
    int selectIsStuByPro(String profession);//根据职业统计在学弟子数量
    Student getByStuID(int stuID);//根据学号查找
    List<Student> getByName(String name);//根据姓名模糊查询

}
