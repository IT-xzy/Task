package com.jnshu.service.impl;

import com.jnshu.dao.JobMapper;
import com.jnshu.pojo.Job;
import com.jnshu.pojo.tool.memcached.MemcachedUtil;
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

    @Autowired
    MemcachedUtil memcachedUtil;

    @Override
    public int insertSelective(Job record) {
        return insertSelective(record);
    }

    @Override
    public List<Job> getAll() {
        List<Job> rs = (List<Job>) memcachedUtil.get("job");
        if (rs!=null){
            logger.info("从缓存里取");
            return rs;
        }else{
            logger.info("从数据库里取");
            List<Job> job = jobMapper.getAll();
        boolean state =  memcachedUtil.set("job",18000,job);
        logger.info("从数据库取的："+state);
            return job;
        }
    }
}
