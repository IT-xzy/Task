package com.jnshu.dao;


import com.jnshu.model.JobInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("JIDao")
public interface JobInfoMapper {
    JobInfo selectByPrimaryKey(Integer id);
    List<JobInfo> listAll();

}