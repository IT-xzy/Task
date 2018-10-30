package com.artist.service;

import com.artist.dao.MessageDao;
import com.artist.pojo.Message;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService {
    private Logger logger=Logger.getLogger(MessageServiceImpl.class);
    @Resource(name = "messageDao")
    private MessageDao messageDao;
    @Override
    public String saveMessage(Message message) {
        logger.info("saveMessage()");
        logger.info(message);
        String str =null;
        Integer number= messageDao.saveMessage(message);
        if (number<=0){
            str="保存失败！";
        }else {
            str="保存成功！";
        }
        logger.info(str);
        return str;
    }
}
