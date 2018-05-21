package com.ptteng.dao;

import com.ptteng.pojo.model.Graduate;

import java.util.HashMap;
import java.util.List;

public interface GraduateDAO {
    //毕业生计数
    public Integer selectCount();
    //返回一定数量毕业生的集合
    public List<Graduate> findGraduates(HashMap<String,Object> map)throws Exception;
    //根据主键来寻找指定的毕业生
    public Graduate findById(Long id) throws Exception;
}
