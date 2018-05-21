package com.service;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 职业操作实现接口
 * @create: 2018/5/7 下午5:40
 */

public interface ProfessionService {
    List<com.POJO.Profession> findFront();
    List<com.POJO.Profession> findAfter();
    List<com.POJO.Profession> findOP();
    List<com.POJO.Profession> findPM();
}
