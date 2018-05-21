package com.service;

import com.bean.Jobs;
import com.dao.JobsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2018/1/2 16:12
 */
@Service
public class JobsServiceImpl implements IjobsService {
   @Autowired
    JobsDao jobsDao;
    @Override
    public List<Jobs> selectJobs() {
        return jobsDao.selectJobs();
    }
}
