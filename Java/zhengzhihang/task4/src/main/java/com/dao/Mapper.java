package com.dao;

import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mapper {
    //累计学习人数统计
    int accountTrainees();
    //找到工作人数统计
    int countWork();
    //课程在学人数
    int lessonCount(int number);
    //优秀学员获取类
    List<Trainees> niceTrainees();
    //职业
    List<Occupation> queryAllCareers ();
    //职业和人数
    List<OcT>  queryAllCareersAndLesson();

    Trainees checkPwd(String account);

    int loginTrainees(Trainees trainees);
}
