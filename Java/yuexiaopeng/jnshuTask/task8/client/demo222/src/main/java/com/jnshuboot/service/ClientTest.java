package com.jnshuboot.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientTest {
    @Autowired
    IUserService iUserService;

    public String testOne(String str) {
        str = iUserService.test(str);
        return str;
    }
}
