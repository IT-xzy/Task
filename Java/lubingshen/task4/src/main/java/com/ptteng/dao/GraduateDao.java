package com.ptteng.dao;

import com.ptteng.bean.Graduate;

import java.util.HashMap;
import java.util.List;

public interface GraduateDao {
    //毕业生计数
    public int selectCount();
    //返回一定数量毕业生的集合
    public List<Graduate> findGraduates(HashMap<String,Object> map)throws Exception;
    //根据主键来寻找指定的毕业生
    public Graduate findById(Long id) throws Exception;
}
