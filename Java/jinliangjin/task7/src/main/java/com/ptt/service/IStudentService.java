package com.ptt.service;

import com.ptt.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @ClassName: IStudentService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/12 10:38
 * @Version: 1.0
 */
public interface IStudentService {
    Integer register(Student student);//注册
    Integer login(Student student, String rememberMe, HttpSession session, HttpServletResponse response);//登录
    boolean edit(Student student, HttpServletRequest request, HttpServletResponse response);//修改信息
    boolean delete(Student student, HttpServletResponse response, HttpServletRequest request);//注销
    boolean logout(HttpServletRequest request, HttpServletResponse response);//退出
    Student getStudentByName(String name);//查询
    List<Student> getAllStudents();//查询全部
    String getStudentName(HttpServletRequest request);
    Student fileUpload(MultipartFile file, HttpServletRequest request, String name);//文件上传
    String sendEmail(Student student, HttpServletRequest request);//根据输入的email发送带有验证码的邮件，返回验证码
    String vCodeValidation(String vCode, HttpServletRequest request, String name);//邮箱验证码比对
    String sendSMessage(Student student, HttpServletRequest request);//发送短信
    String vCodeSMessageValidation(String vCode, HttpServletRequest request, String name);//短信验证码比对
}
