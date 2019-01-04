package com.art.mapper;

import com.art.pojo.Banner;
import com.art.pojo.Second;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Second record);

    int insertSelective(Second record);

    Second selectByPrimaryKey(Integer id);
    List<Second> selectByCondition(@Param("status") Boolean status, @Param("updateBy") String updateBy);


    int updateByPrimaryKeySelective(Second record);

    int updateByPrimaryKey(Second record);
}