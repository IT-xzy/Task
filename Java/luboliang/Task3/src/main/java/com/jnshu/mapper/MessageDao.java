package com.jnshu.mapper;

import com.jnshu.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MessageDao {
    public long addMessage(Message message);

    public boolean deleteMessage(long id);

    public boolean updateMessage(Message message);

    public Message findByMessage(long id);

    public List<Message> findAllMessage();
    
}
