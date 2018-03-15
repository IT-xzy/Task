package com.dao;

import com.bean.GoodStudent;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 15:13
 */
public interface GoodStudentDao {
    //查询所有
    List<GoodStudent> selectAll();
    
    Integer count();
    
    Integer countGood();
    
}
