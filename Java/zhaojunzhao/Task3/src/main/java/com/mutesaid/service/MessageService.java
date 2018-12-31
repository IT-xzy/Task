package com.mutesaid.service;

import com.mutesaid.pojo.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MessageService {
    /**
     * 根据提供的参数查找留言
     * @param workName 作品标题
     * @param status 留言状态0/1
     * @return 留言表
     */
    List<Message> getMsgList(String workName, Boolean status);

    /**
     * 根据id删除留言
     * @param msgId 留言id
     */
    void deleteMsg(Long msgId);


    /**
     * 改变当前留言状态
     * @param msgId 留言id
     */
    void updateStatus(Long msgId);

    /**
     * 查询指定留言
     * @param msgId 留言id
     * @return 留言
     */
    Message getMsg(Long msgId);

    /**
     * 新增一条留言
     * @param content 留言内容
     * @param workId 留言所在作品
     */
    void insertMsg(String content, Long workId);
}
