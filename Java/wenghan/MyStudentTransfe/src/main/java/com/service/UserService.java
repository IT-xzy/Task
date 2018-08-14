package com.service;

import com.pojo.OccupationReunite;
import com.pojo.Student;

import java.util.List;

public interface UserService {
    //统计学习人数（根据学习状态）
    int statisticsInLearning(String learning_State);
    //统计工作满意人数（根据工作满意度）
    int statisticaljobSatisfaction(String JobSatisfaction);
    //根据工作满意度查询学员
    List<Student> queryStudent(String jobSatisfaction);
    //查询复合的职业（根据职业方向）
    List<OccupationReunite> queryOccupationReunite(String occupationDirection);
    //登录逻辑
    Student signIn(Student student);
    //注册逻辑
    void registerStudent(Student student);
    //账号判重复
    boolean accountNumberRepeat(String accountNumber);
    //根据ID值查询用户
    Student queryStudnet(int id);
    //更新学生信息
    boolean updeteStudent(Student student);
    //上传头像
    boolean uploadHeadPortrait(Student student);
    //更新邮箱
    boolean updeteMail(Student student);
    //获得用户的邮箱和手机号
    Student queryStudentMailAndPhoneNumber(int id);
    //更新密码
    boolean updatePassword(Student student);
}
