package com.xiuzhenyuan.dao;

import com.xiuzhenyuan.bean.Graduate;

import java.util.List;

public interface GraduateDao {
    //使用懒加载
    public List<Graduate> findGraduates()throws Exception;

    //毕业生计数
    public int selectCount();
}
