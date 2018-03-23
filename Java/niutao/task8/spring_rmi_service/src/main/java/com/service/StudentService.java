package com.service;

import com.model.Student;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StudentService {

    //int deleteByPrimaryKey(Integer id);

    //动态查询，userName，phoneNumber,email

    int selectByUnique(Student student);


    int insert(Student record);

    //int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int selectByStatus(Integer status);

    List<Student> selectCollege();

    int selectByclass(String classname);

    Student selectByuserName(String userName);

    //发普通邮件
    void sendEmail(String email, String userName, String addressCode) throws Throwable;

    //发短信
    void sendSMS(String security);

    //人机识别验证码
    String getAuthCode();
    BufferedImage getAuthImg(String Code);

    //优秀学员
    Map<Integer, String> GetCollegeMap();
    List<Student> GetCollegeList();
    Map<String, String> GetCollegeStringMap();

    //云存储
    void doSelect() throws IOException;
    void doUp(String name);
    String geturl();

    //TokenUtil
//    boolean VerifyToken(HttpServletRequest httpServletRequest);
    String ProduceToken(String id, String logtime);
    
}
