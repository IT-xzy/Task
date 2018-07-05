package com.ptt.service;

import com.ptt.pojo.Student;

/**
 * @ClassName: IStudentService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/12 10:38
 * @Version: 1.0
 */
public interface IStudentService {
    Integer register(Student student);//注册
    Student login(Student student);//登录
    Student edit(Student student);//修改信息
    Student getStudentByName(String name);//查询
    Student fileUpload(String url, String name);//文件上传
    String sendEmail(Student student);//根据输入的email发送带有验证码的邮件，返回验证码
    Student update(Student student);//根据name更新
    String sendSMessage(Student student);//发送短信
}
