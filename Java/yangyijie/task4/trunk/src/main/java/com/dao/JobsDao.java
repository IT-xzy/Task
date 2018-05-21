package com.dao;

import com.bean.Jobs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Arike
 * Create_at 2018/1/2 14:19
 */
public interface JobsDao {
    
    List<Jobs> selectJobs();
}
