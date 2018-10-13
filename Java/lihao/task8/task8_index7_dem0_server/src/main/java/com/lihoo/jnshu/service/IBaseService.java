package com.lihoo.jnshu.service;

import com.lihoo.jnshu.pojo.User;

/**
 * #Title: IBaseService
 * #ProjectName task8_index7
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-13:55
 */


public interface IBaseService {
    /**
     * 简单Hello Word
     * @param name
     * @return
     */
    public String getHelloWord(String name);
    /**
     * 获得User对象
     * @param user
     * @return
     */
    public String getUser(User user);

}
