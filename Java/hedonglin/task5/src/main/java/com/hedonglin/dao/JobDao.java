package com.hedonglin.dao;


import com.hedonglin.model.Job;


import java.util.List;


public interface JobDao {
    int deleteByPrimaryKey(Long id);

    int insert(Job job);

    int insertSelective(Job job);

    Job selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Job job);

    int updateByPrimaryKey(Job record);

    List<Job> getAll();
}