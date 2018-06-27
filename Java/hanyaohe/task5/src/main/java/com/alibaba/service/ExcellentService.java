package com.alibaba.service;

import com.alibaba.model.Excellent;

import java.util.List;

public interface ExcellentService {
    int deleteById(Integer id);
    int insert(Excellent record);
    public int insertSelective(Excellent record);

    public Excellent selectById(Integer id);

    public int updateByIdSelective(Excellent record);

    public int updateById(Excellent record);

    public List<Excellent> getAllExcellent();
}
