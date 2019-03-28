package com.jnshu.dao;

import com.jnshu.pojo.SecondWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondWorkMapper {
    int deleteByPrimaryKey(Long secondId);

    int insert(SecondWork record);

    int insertSelective(SecondWork record);

    SecondWork selectByPrimaryKey(Long secondId);

    int updateByPrimaryKeySelective(SecondWork record);

    int updateByPrimaryKey(SecondWork record);

    List<SecondWork> selectByDynamic(@Param("name")String name, @Param("status")Integer status);

    List<SecondWork> selectFirstId(Long firstId);
}