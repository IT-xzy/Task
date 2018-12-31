package com.mutesaid.mapper;

import com.mutesaid.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    /**
     * 根据提供的参数查找留言
     * @param workId 留言id列表
     * @param status 留言状态0/1
     * @return 留言表
     */
    List<Message> getMsgList(@Param("workId") Long workId,
                             @Param("status") Boolean status);


    void deleteMsg(Long msgId);


    void deleteWork(Long workId);

    void updateStatus(@Param("msgId") Long msgId,
                      @Param("status") Boolean status);

    Message getMsg(Long msgId);

    void insertMsg(Message msg);
}
