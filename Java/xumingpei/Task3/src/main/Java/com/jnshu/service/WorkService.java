package com.jnshu.service;

import com.jnshu.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:35
 */
public interface WorkService {
    int deleteByPrimaryKey(Long id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectByDynamic(@Param("name")String name, @Param("status")Integer status);
}
