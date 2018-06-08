package com.fangyuyang.dao;

import com.fangyuyang.model.Career;

import java.util.List;

public interface CareerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Career record);

    int insertSelective(Career record);

    Career selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Career record);

    int updateByLearningMan(Career record);
     List<Career> list();
    int countCareer1();
    int countCareer2();
    int countCareer3();
    int countCareer4();
    int countCareer5();
    int countCareer6();
    int countCareer7();
    int countCareer8();
    int countCareer9();

}