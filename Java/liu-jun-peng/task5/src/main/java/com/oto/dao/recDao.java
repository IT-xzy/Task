package com.oto.dao;

import com.oto.pojo.rec;

import java.awt.geom.RectangularShape;
import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/7 上午10:03
 */

public interface recDao {
   
    List<rec> findALL();
    
}
