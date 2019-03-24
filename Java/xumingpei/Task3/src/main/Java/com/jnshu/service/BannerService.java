package com.jnshu.service;

import com.jnshu.pojo.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/10 - 12:26
 */
public interface BannerService {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectByDynamic(@Param("updateBy")String updateBy, @Param("status")Integer status);
}
