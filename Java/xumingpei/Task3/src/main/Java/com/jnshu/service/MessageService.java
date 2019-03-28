package com.jnshu.service;

import com.jnshu.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:31
 */
public interface MessageService {
    int deleteByPrimaryKey(Long msgId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long msgId);

    List<Message> selectworkId(@Param("workId") Long workId, @Param("status")String status);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectByDynamic(@Param("name") String name, @Param("status")Integer status);
}
