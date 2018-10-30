package com.jns.service;

import com.jns.entity.Jns;

import java.util.List;

public interface JnsService {
    //定义方法，以便controller层的使用

    //获取所有jns的数据
    List<Jns> list();
}
