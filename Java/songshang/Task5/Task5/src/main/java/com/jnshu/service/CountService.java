package com.jnshu.service;
import com.jnshu.model.Count;
import com.jnshu.model.Position;

import java.util.List;

public interface CountService {
    int deleteById(Integer id);
    int insert(Count record);
    int insertSelective(Count record);
    Count selectById(Integer id);
    int updateByIdSelective(Count record);
    int updateById(Count record);
    public List<Count> getAllCount();
    public Count selectByName(String name) throws Exception;
    public int countByName(String user) throws Exception;
}
