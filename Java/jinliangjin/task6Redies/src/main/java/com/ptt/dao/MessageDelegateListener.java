package com.ptt.dao;

import java.io.Serializable;

/**
 * @ClassName: MessageDelegateListener
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/10 21:02
 * @Version: 1.0
 */
public interface MessageDelegateListener {
    void handleMessage(Serializable message);
}
