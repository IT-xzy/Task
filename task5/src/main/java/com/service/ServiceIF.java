package com.service;

import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceIF {
    //累计学习人数统计
    int accountStudents();
    //找到工作人数统计
    int countOccupation();
    //课程在学人数
    int lessonAll(int number);
    //优秀学员获取类
    List<Trainees> niceStudents();
    //职业
    List<Occupation> queryAllOccupation();
    //查找所有职业和课程
    List<OcT> queryAllOccupationAndLesson();
    //根据账号查找密码
    Trainees checkPwd(String account);
    //注册账号
    int loginTrainees(Trainees trainees);
    //登录接口
    int enterPage(Trainees trainees);
    //通过id查询账号
    String findAccountById(int id);

}
