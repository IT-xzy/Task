package com.artist.dao;

import com.artist.pojo.Message;

import java.util.List;

public interface MessageDao {
    List<Message> queryMessages(Integer productionId);
    Integer delMdessage(Integer messageId);
    Integer saveMessage(Message message);
    void updateMessage(Message message);
}
