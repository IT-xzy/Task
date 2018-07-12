package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.OccupationReunite;
import com.pojo.Student;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
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

}
