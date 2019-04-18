package com.jnshu.service;

import com.jnshu.pojo.Job;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 5:49
 */
public interface JobService {
    int insertSelective(Job record);

    List<Job> getAll();
}
