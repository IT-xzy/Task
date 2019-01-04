package com.xiaobo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xiaobo.demo.service.UserService;

@Component
public class App {
    @Autowired
    private UserService userService;
}
