package com.service;

import java.util.List;
import com.POJO.Profession;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 职业操作实现接口
 * @create: 2018/5/7 下午5:40
 */

public interface ProfessionService {
    List<Profession> findFront();
    List<Profession> findAfter();
    List<Profession> findOP();
    List<Profession> findPM();
}
