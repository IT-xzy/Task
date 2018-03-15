package com.hedonglin.service;

import com.hedonglin.dao.JobDao;
import com.hedonglin.model.Job;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "jobServiceImpl")
public class JobServiceImpl implements JobService {

    @Resource
    private JobDao jobDao;

    public int deleteByPrimaryKey(Long id){
        return jobDao.deleteByPrimaryKey(id);
    }

    public int insert(Job job){
        return jobDao.insert(job);
    }

    public int insertSelective(Job job){
        return jobDao.insertSelective(job);
    }

    public Job selectByPrimaryKey(Long id){
        return jobDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Job job){
        return jobDao.updateByPrimaryKeySelective(job);
    }

    public int updateByPrimaryKey(Job job){
        return jobDao.updateByPrimaryKey(job);
    }


    public List<Job> getAll(){
        return jobDao.getAll();
    }



}
