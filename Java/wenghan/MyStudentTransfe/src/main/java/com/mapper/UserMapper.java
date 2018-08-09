package com.mapper;

import com.pojo.OccupationReunite;
import com.pojo.Student;
import java.util.List;

public interface UserMapper {
    //统计学习人数（根据学习状态）
    int statisticsInLearning(String learningState);
    //统计工作满意人数（根据工作满意度）
    int statisticaljobSatisfaction(String jobSatisfaction);
    //根据工作满意度查询学员
    List<Student> queryStudent(String jobSatisfaction);
    //查询复合的职业（根据职业方向）
    List<OccupationReunite> queryOccupationReunite(String occupationDirection);
    //查询学员的人数（根据职业id外键）
    int queryStudentNumber(int oid);
    //登录逻辑
    Student signIn(String accountNumber);
    //注册逻辑
    void registerStudent(Student student);
    //账号判重复
    int accountNumberRepeat(String accountNumber);
    //根据ID值查询用户
    Student queryStudnet(int id);
    //更新学生信息
    int updeteStudent(Student student);
    //上传头像
    int uploadHeadPortrait(Student student);
    //更新邮箱
    int updeteMail(Student student);
    //获得用户的邮箱和手机号
    Student queryStudentMailAndPhoneNumber(int id);
    //更新密码
    int updatePassword(Student student);
}
