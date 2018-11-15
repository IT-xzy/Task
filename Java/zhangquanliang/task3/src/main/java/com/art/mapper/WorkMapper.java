package com.art.mapper;

import com.art.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);
    List<Work> selectByCondition(@Param("status") Boolean status, @Param("updateBy") String updateBy);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}