package com.ptt.dao.impl;

import com.ptt.dao.MessageDelegateListener;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName: MessageDelegateListenerImpl
 * @Description: 订阅者
 * @Author: Jin
 * @CreateDate: 2018/6/10 21:00
 * @Version: 1.0
 */
@Component
public class MessageDelegateListenerImpl implements MessageDelegateListener {
    private Logger logger = Logger.getLogger(MessageDelegateListener.class);
    @Override
    public void handleMessage(Serializable message) {
        if(null == message){
            logger.info("null message!");
        } else {
            logger.info(message);
        }
    }
}
