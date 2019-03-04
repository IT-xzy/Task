package com.jnshu.clroom.mapper;

import com.jnshu.clroom.beans.Painting;

public interface PaintingMapper {
    int deleteByPrimaryKey(Long paintingId);

    int insert(Painting record);

    int insertSelective(Painting record);

    Painting selectByPrimaryKey(Long paintingId);

    int updateByPrimaryKeySelective(Painting record);

    int updateByPrimaryKey(Painting record);
}