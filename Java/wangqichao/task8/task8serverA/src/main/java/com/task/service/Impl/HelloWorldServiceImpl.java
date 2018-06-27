package com.task.service.Impl;

import com.task.service.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * 自定义远程接口实现类
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    /**
     * 获取信息
     * @return
     */
    @Override
    public String getMsg() {
        return "Hello World!";
    }
}
