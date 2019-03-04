package com.jnshu.springrmi.service.impl;

import com.jnshu.springrmi.service.Message;

public class MessageImpl implements Message {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
