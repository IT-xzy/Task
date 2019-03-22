package com.jnshu.service;

import com.jnshu.pojo.FirstWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:31
 */
public interface FirstWorkService {
    int deleteByPrimaryKey(Long id);

    int insert(FirstWork record);

    int insertSelective(FirstWork record);

    FirstWork selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstWork record);

    int updateByPrimaryKey(FirstWork record);

    List<FirstWork> selectByDynamic(@Param("name") String name, @Param("status")Integer status);
}
