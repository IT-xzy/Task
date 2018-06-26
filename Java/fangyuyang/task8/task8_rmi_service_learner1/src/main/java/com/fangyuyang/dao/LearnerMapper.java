package com.fangyuyang.dao;

import com.fangyuyang.model.Learner;

public interface LearnerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Learner record);

    int insertSelective(Learner record);

    Learner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Learner record);

    int updateByPrimaryKey(Learner record);
    int countAll();
    Learner selectByName(String name);
}