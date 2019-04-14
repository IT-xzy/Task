package com.ptteng.service;

import com.ptteng.model.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkService {
    int deleteByPrimaryKey(Long id);

    int insert(Work record);

    int insertSelective(Work record);

   Work selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectAll();

    List<Work> selectByDynamicCondition(@Param("workName")String name, @Param("state")Long state);
}
