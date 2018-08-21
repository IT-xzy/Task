package com.service;

import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.apache.ibatis.annotations.Param;
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
    //通过id查询学员
    Trainees findTraineesById(int id);
    //通过id查找图片
    String findPicById (int id);
    //通过账号修改密码
    int updatePwd(String password, String account);
    //通过id更新图片
    int updatePicById(String pic,int id);
    //通过id完成上传图片，并且返回更改后的图片；
    String uploadPic(int id);

    //获取邮箱验证码
    void getMailCore(String mail,String account);
    //获取短信验证码
    void getMessageCore(String phoneNumber, String account);

}
