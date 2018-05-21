package com.service;

import com.bean.Jobs;
import com.dao.JobsDao;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author Arike
 * Create_at 2018/1/2 16:12
 */
@Service
public class JobsServiceImpl implements IJobsService {
    @Autowired
    JobsDao jobsDao;
    @Autowired
    MemcachedClient memcachedClient;
    
    @Override
    public List<Jobs> selectJobs() {
        try {
            if (null == memcachedClient.get("selectJobs")) {
                memcachedClient.add("selectJobs", 60 * 60, jobsDao.selectJobs());
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        try {
            return memcachedClient.get("selectJobs");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return jobsDao.selectJobs();
    }
}
