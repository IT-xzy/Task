package com.jnshu.dao;

import com.jnshu.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(Long workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Long workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> selectByDynamic(@Param("name")String name, @Param("introduction")String introduction);

    List<Work> selectsecondId(Long secondId);
}