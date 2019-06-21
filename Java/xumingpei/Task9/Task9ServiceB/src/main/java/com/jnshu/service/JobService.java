package com.jnshu.service;

import com.jnshu.pojo.Job;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;


@Remotable
public interface JobService {
    int insertSelective(Job record);

    List<Job> getAll();
}
