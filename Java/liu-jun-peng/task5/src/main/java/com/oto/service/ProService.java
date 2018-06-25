package com.oto.service;

import com.oto.pojo.pro;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/5 上午10:44
 */


public interface ProService {
    
    List<pro> query();
}
