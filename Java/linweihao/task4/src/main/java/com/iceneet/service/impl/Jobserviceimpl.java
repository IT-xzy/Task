package com.iceneet.service.impl;

import com.iceneet.dao.JobMapper;
import com.iceneet.qo.JobQo;
import com.iceneet.service.Jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Jobserviceimpl implements Jobservice{
    @Autowired
    private JobMapper jobMapper;

    public List<JobQo> selectJobTypeNum(){
        return jobMapper.selectWebFort();
    }
}
