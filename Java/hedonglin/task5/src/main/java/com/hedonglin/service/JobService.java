package com.hedonglin.service;

import com.hedonglin.model.Job;


import java.util.List;

public interface JobService {

    int deleteByPrimaryKey(Long id);

    int insert(Job job);

    int insertSelective(Job job);

    Job selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Job job);

    int updateByPrimaryKey(Job record);

    List<Job> getAll();




}
