package com.jnshu;

public class RmiServiceImpl implements RmiService {

    @Override
    public String getHello() {
        return "hello world!";
    }
}
