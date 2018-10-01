package com.jns.service;

import com.jns.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();


    /**
     * @return Student
     * @Description 查询学生手机号
     * @Param phoneNum
     **/
    Student selectPhoneNum(String phoneNum);

    /**
     * @return Student
     * @Description 查询学生姓名
     * @Param stuNum
     **/
    Student selectStuName(String stuName);

    /**
     * @return Student
     * @Description 根据学员ID查询
     * @Param stuNum
     **/
    Student selectStuID(Integer StuID);
    
    /**
     * @Description 动态sql 通过学生姓名 id phonenum password 查询学生
     * @Param
     * @return 
     **/
    Student selectWithNameIDPhoneNumPassWord(Student student);
    

    /**
     * @Description 更新登陆时间
     * @Param 登陆时间 long
     * @return true/false
     **/
    boolean updateLoginTime(Student student);

    /**
     * @Description 更新学生信息
     * @Param 姓名 电话 密码 头像 email 更新时间
     * @return
     **/
    boolean updateStudent(Student student);


    /**
     * @Description 注册学员 将注册时间 修改时间封装
     * @Param 姓名 密码 电话号码
     * @return 学员id
     **/
    Integer signUpStudent(String stuName,String passoWord,String phoneNum);



    // 查询所有学员数
    int countAll();
    // 查询已工作人数
    int countJob();
    // 查询各个课程人数
    int countCourse(String cour);
    // 查询优秀学员
    List<Student> findGood();


}
