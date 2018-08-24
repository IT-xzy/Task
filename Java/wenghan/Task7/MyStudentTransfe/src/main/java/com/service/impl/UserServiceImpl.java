package com.service.impl;

import com.encryption.MD5;
import com.mapper.UserMapper;
import com.pojo.OccupationReunite;
import com.pojo.Student;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Logger logger=Logger.getLogger(UserServiceImpl.class);

    @Autowired
    public UserMapper userMapper;
    //统计学习人数（根据学习状态）
    public int statisticsInLearning(String learning_State){
        return userMapper.statisticsInLearning(learning_State);
    }
    //统计工作满意人数（根据工作满意度）
    public int statisticaljobSatisfaction(String jobSatisfaction){
        return userMapper.statisticaljobSatisfaction(jobSatisfaction);
    }
    //根据工作满意度查询学员
    public List<Student> queryStudent(String jobSatisfaction){
        return userMapper.queryStudent(jobSatisfaction);
    }
    //查询复合的职业（根据职业方向），调用查询学员的人数（根据职业id外键）的方法
    public List<OccupationReunite> queryOccupationReunite(String occupationDirection){
        List<OccupationReunite> occupationReuniteList=userMapper.queryOccupationReunite(occupationDirection);
        for (OccupationReunite anOccupationReuniteList : occupationReuniteList) {
            anOccupationReuniteList.setStudentNumber(userMapper.queryStudentNumber(anOccupationReuniteList.getId()));
        }
        return occupationReuniteList;
    }
    //登录逻辑
    public Student signIn(Student student){
        Student studentDate=userMapper.signIn(student.getAccountNumber());
        //如果根据账号可以查询到用户
        // 并且查询到的盐跟用户输入的密码使用MD5加密后跟查询到的用户密码一致，判断登录成功，返回用户
        if(studentDate!=null&&studentDate.getPassword().equals
                (MD5.encode(student.getPassword()+studentDate.getSalt()))){
            return studentDate;
        }
        //如果没有登录成功返回null
        return null;
    }
    //注册逻辑
    public void registerStudent(Student student){
        student.setSalt(UUID.randomUUID().toString());
        student.setPassword(MD5.encode(student.getPassword()+student.getSalt()));
        userMapper.registerStudent(student);
    }
    //账号判重复
    public boolean accountNumberRepeat(String accountNumber){
        return userMapper.accountNumberRepeat(accountNumber)==0;
    }
    //根据ID值查询用户
    public Student queryStudnet(int id){
        return userMapper.queryStudnet(id);
    }
    //更新学生信息
    public boolean updeteStudent(Student student){
        return userMapper.updeteStudent(student)!=0;
    }
    //上传头像
    public boolean uploadHeadPortrait(Student student){
     return userMapper.uploadHeadPortrait(student)!=0;
    }
    //更新邮箱
    public boolean updeteMail(Student student){
        return userMapper.updeteMail(student)!=0;
    }
    //获得用户的邮箱和手机号
    public Student queryStudentMailAndPhoneNumber(int id){
        return userMapper.queryStudentMailAndPhoneNumber(id);
    }
    //更新密码
    public boolean updatePassword(Student student){
        //随机生成盐并设置到student中
        student.setSalt(UUID.randomUUID().toString());
        //通过随机生成的盐和用户设置的新密码加密生成新的密码
        student.setPassword(MD5.encode(student.getPassword()+student.getSalt()));
        return userMapper.updatePassword(student)!=0;
    }
}
