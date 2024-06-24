package com.jnshu.mapper;

import com.jnshu.model.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectAll();
}