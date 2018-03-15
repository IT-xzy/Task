package com.service;

import com.bean.GoodStudent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 16:06
 */
@Service
public interface IGoodStudentService {
    //查询所有
    List<GoodStudent> selectAll();
    
    Integer count();
    
    Integer countGood();
}
