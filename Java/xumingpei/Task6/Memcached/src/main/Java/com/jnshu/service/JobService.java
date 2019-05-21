package com.jnshu.service;

import com.jnshu.pojo.Job;

import java.util.List;

public interface JobService {
    int insertSelective(Job record);

    List<Job> getAll();
}
