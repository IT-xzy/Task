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
}
