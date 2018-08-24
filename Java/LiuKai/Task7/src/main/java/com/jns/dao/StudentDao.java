package com.jns.dao;

import com.jns.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * @return 所有学生list
     * @Description 查询所有
     * @Param no
     **/
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
     * @return
     * @Description 根据用户名 id phonenum查询
     * @Param 用户名 id phonenum查询
     **/
    Student selectWithNameIDPhoneNumPassWord(Student student);


    /**
     * @return 学员id
     * @Description 注册/增加学员
     * @Param 姓名 密码 电话号码 注册时间 修改时间
     **/
    Integer signUpStudent(Student student);

    /**
     * @return true/false
     * @Description 更新登陆时间
     * @Param 登陆时间 long
     **/
    boolean updateLoginTime(Student student);

    /**
     * @return
     * @Description 更新学生信息
     * @Param 姓名 电话 密码 头像 email 更新时间
     **/
    boolean updateStudent(Student student);

    // 查询所有
    int countAll();

    // 查询已工作人数
    int countJob();

    // 查询各个课程人数
    int countCourse(String cour);

    // 查询优秀学员
    List<Student> findGood();


    // 删除所有
    void deleteAll();
}
