package com.art.mapper;

import com.art.pojo.Banner;
import com.art.pojo.First;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(First record);

    int insertSelective(First record);

    First selectByPrimaryKey(Integer id);

    List<First> selectByCondition(@Param("status") Boolean status, @Param("updateBy") String updateBy);

    int updateByPrimaryKeySelective(First record);

    int updateByPrimaryKey(First record);
}