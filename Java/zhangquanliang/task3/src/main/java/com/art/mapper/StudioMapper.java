package com.art.mapper;

import com.art.pojo.Studio;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer id);

    List<Studio> selectByCondition(@Param("status") Boolean status, @Param("updateBy") String updateBy);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);
}