package com.ptteng.service;

import com.ptteng.pojo.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface StudentService {

    //通过用户名修改关联的学员信息的头像值（以OSS上的key值保存）
    boolean updateStudentAvatar(String userName, String url) throws Exception;

    //判断用户是否成功报名
    boolean hasStudentInfo(String userName) throws Exception;

    //通过用户的姓名获取关联的学员信息
    User getStudentInfo(String userName) throws Exception;

    //通过技能树用户系统报名一个学员信息
    String addStudentByUser(String userName, String studentName) throws Exception;

}
