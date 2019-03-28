package com.jnshu.dao;

import com.jnshu.pojo.Reply;
import com.jnshu.pojo.SecondWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Long replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Long replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> selectByDynamic(@Param("replyId")Long replyId, @Param("replyName")String replyName);

    Reply selectmsgId(Long msgId);
}