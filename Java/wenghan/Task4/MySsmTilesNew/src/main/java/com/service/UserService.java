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
}
