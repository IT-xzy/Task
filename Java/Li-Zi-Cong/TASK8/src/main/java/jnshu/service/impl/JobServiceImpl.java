package jnshu.service.impl;

import jnshu.dao.JobMapper;
import jnshu.pojo.Job;
import jnshu.service.JobService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    private Logger logger = LogManager.getLogger(JobServiceImpl.class);

    @Override
    public List<Job> listJob() throws Exception {
        try {
            return jobMapper.listJob();
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);

        }
        return null;
    }
}
