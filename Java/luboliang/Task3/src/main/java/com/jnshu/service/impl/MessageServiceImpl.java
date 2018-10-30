package com.jnshu.service.impl;

import com.jnshu.mapper.MessageDao;
import com.jnshu.model.Message;
import com.jnshu.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;

    @Override
    public long addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public boolean deleteMessage(long id) {
        return messageDao.deleteMessage(id);
    }

    @Override
    public boolean updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }

    @Override
    public Message findByMessage(long id) {
        return messageDao.findByMessage(id);
    }

    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }
}
