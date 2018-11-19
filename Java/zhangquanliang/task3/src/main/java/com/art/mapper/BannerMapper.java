package com.art.mapper;

import com.art.pojo.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);
    List<Banner> selectByCondition(@Param("status") Boolean status, @Param("updateBy") String updateBy);
    // List<Banner> selectByCondition(Boolean status, String updateBy);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}