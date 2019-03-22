package com.jnshu.clroom.mapper;

import com.jnshu.clroom.beans.Studio;

public interface StudioMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);
}