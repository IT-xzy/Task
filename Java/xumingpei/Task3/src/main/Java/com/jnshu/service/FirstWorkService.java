package com.jnshu.service;

import com.jnshu.pojo.FirstWork;
import com.jnshu.pojo.SecondWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:31
 */
public interface FirstWorkService {
    int deleteByPrimaryKey(Long firstId);

    int insert(FirstWork record);

    int insertSelective(FirstWork record);

    FirstWork selectByPrimaryKey(Long firstId);

    int updateByPrimaryKeySelective(FirstWork record);

    int updateByPrimaryKey(FirstWork record);

    List<FirstWork> selectByDynamic(@Param("firstName") String firstName, @Param("status")Integer status);


}
