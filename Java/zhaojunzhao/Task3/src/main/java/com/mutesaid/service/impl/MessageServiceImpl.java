package com.mutesaid.service.impl;

import com.mutesaid.mapper.MessageMapper;
import com.mutesaid.mapper.WorkMapper;
import com.mutesaid.pojo.Message;
import com.mutesaid.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private WorkMapper workMapper;

    private Logger logger = LogManager.getLogger(MessageServiceImpl.class);

    @Override
    public List<Message> getMsgList(String workName, Boolean status) {
        Long workId = null;
        logger.info("判断是否传入workName");
        if(workName != null) {
            logger.info("传入了workName");
            workId = workMapper.getWorkId(workName);
        }
        return messageMapper.getMsgList(workId, status);
    }

    @Override
    public void deleteMsg(Long msgId) {
        messageMapper.deleteMsg(msgId);
    }

    @Override
    public void updateStatus(Long msgId) {
        Message msg = messageMapper.getMsg(msgId);
        messageMapper.updateStatus(msgId, !(msg.getStatus()));
    }

    @Override
    public Message getMsg(Long msgId) {
        return messageMapper.getMsg(msgId);
    }


    @Override
    public void insertMsg(String content, Long workId) {
        long currentTime = System.currentTimeMillis();

        Message msg = new Message();
        msg.setAdminId(110L);
        msg.setContent(content);
        msg.setVisitorName("萨尔");
        msg.setStatus(false);
        msg.setCreateAt(currentTime);
        msg.setUpdateAt(currentTime);
        msg.setWorkId(workId);

        messageMapper.insertMsg(msg);
    }
}
