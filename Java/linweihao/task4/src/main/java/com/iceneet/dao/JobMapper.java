package com.iceneet.dao;

import com.iceneet.entity.Job;
import com.iceneet.qo.JobQo;

import java.util.List;
import java.util.Map;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKeyWithBLOBs(Job record);

    int updateByPrimaryKey(Job record);

    List<Job> selectJob();
    List<JobQo> selectWebFort();
}