package com.fangyuyang.service;

import sun.plugin2.message.Message;

public interface MobileService {
    String sendMessages(String number);
    String MessagesCheck(String number);
//    boolean dealMessage(Message message);
    String sendMoreMessages();
}
