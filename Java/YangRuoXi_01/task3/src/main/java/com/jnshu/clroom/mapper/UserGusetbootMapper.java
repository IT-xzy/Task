package com.jnshu.clroom.mapper;

import com.jnshu.clroom.UserGusetboot;
import com.jnshu.clroom.beans.UserGusetbootExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGusetbootMapper {
    int countByExample(UserGusetbootExample example);

    int deleteByExample(UserGusetbootExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGusetboot record);

    int insertSelective(UserGusetboot record);

    List<UserGusetboot> selectByExample(UserGusetbootExample example);

    UserGusetboot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGusetboot record, @Param("example") UserGusetbootExample example);

    int updateByExample(@Param("record") UserGusetboot record, @Param("example") UserGusetbootExample example);

    int updateByPrimaryKeySelective(UserGusetboot record);

    int updateByPrimaryKey(UserGusetboot record);
}