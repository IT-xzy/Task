package com.jnshu.service;
import com.jnshu.model.Excellent;

import java.util.List;

public interface ExcellentService {
    public int deleteByid(Integer id);

    public int insert(Excellent record);

    public int insertSelective(Excellent record);

    public Excellent selectByid(Integer id);

    public int updateByidSelective(Excellent record);

    public int updateByid(Excellent record);

    public List<Excellent> getAllExcellent();
}
