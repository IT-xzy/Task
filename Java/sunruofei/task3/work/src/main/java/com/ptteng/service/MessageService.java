package com.ptteng.service;

import com.ptteng.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageService  {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectAll();

    List<Message> selectByDynamicCondition(@Param("name")String name , @Param("state")Long state);
}
