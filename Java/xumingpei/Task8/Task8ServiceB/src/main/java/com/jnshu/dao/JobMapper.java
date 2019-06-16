package com.jnshu.dao;

import com.jnshu.pojo.Job;

import java.util.List;

public interface JobMapper {
    int insertSelective(Job record);

    List<Job> getAll();
}