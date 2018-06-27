package com.task.service;

/**
 * 自定义包含了RMI服务端远程接口某些抽象方法的RMI客户端接口
 */
public interface HelloWorldService {
    /**
     * 获取信息
     * @return
     */
     String getMsg();
}
