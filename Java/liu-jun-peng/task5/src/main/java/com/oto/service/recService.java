package com.oto.service;

import com.oto.pojo.rec;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/7 上午10:06
 */

public interface recService {
    
    List<rec> findAll();
    
}
