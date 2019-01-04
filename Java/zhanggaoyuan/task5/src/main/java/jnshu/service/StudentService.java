package jnshu.service;


import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;

import java.util.List;


public interface StudentService {
    int insertStudent(ExcellentStudent record);
    //    查询优秀学员信息
    List<ExcellentStudent> selectStudent();

//    注册学员
    int insertUser(RestUser record);

//    通过名字查询学员信息
    RestUser selectUserByName(String name);

//    判断是否存在登录的角色
    Boolean exists(String name,String pwd);

    //    根据id查询盐
    String selectSalt (Long id);

}
