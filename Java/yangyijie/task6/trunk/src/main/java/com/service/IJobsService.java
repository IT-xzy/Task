package com.service;

import com.bean.Jobs;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2018/1/2 16:12
 */
@Service
public interface IJobsService {
    List<Jobs> selectJobs();
}
