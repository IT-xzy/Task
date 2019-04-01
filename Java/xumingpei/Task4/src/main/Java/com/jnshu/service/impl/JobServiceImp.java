package com.jnshu.service.impl;

import com.jnshu.dao.JobMapper;
import com.jnshu.pojo.Job;
import com.jnshu.service.JobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 5:51
 */
@Service
public class JobServiceImp implements JobService {
    private static Logger logger = Logger.getLogger(JobServiceImp.class);

    @Autowired
    JobMapper jobMapper;

    @Override
    public int insertSelective(Job record) {
        return insertSelective(record);
    }

    @Override
    public List<Job> getAll() {
        List<Job> job = jobMapper.getAll();
        logger.info(toString());
        return job;
    }
}
