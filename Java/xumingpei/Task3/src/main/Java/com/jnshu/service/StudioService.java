package com.jnshu.service;

import com.jnshu.pojo.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:35
 */
public interface StudioService {
    int deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> selectByDynamic(@Param("name")String name, @Param("status")Integer status);
}
