package jnshu.service;

import jnshu.pojo.*;

import javax.servlet.http.Cookie;
import java.util.List;

//复合接口
public interface CompoundService {
    //    封装首页数据
    List<Student> homePage() throws Exception;

    //    封装职业页数据
    List<Job> positionPageCon() throws Exception;

    //    封装JSON路由数据
    Student jsonPage(int id) throws Exception;

    //    处理注册页面返回的数据
    void Register(RegisterAccount registerAccount) throws Exception;

    //    处理登录页面返回的数据,并检验token
    Cookie checkLogin(LoginAccount loginAccount) throws Exception;


//  CRUD缓存接口---------------

    //    插入学生信息
    String insertStudent(StudentInfo studentInfo) throws Exception;

    //    删除学生信息
    String deleteStudentbyID(Integer id) throws Exception;

    //    更新学生信息
    List updateStudent(StudentInfo studentInfo,Integer pageCount) throws Exception;

    //    查找学生信息
    StudentInfo findByStudentID(Integer id,Integer pageCount) throws Exception;

    //    展示学生信息复用接口
    List listInfo(String function, Integer pageCount) throws Exception;


}


