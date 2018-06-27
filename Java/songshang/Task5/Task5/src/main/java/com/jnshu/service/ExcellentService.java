package com.jnshu.service;
import com.jnshu.model.Excellent;

import java.util.List;

public interface ExcellentService {
    public int deleteById(Integer id);

    public int insert(Excellent record);

    public int insertSelective(Excellent record);

    public Excellent selectById(Integer id);

    public int updateByIdSelective(Excellent record);

    public int updateById(Excellent record);

    public List<Excellent> getAllExcellent();
}
