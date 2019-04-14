package com.ptteng.Service;

import com.ptteng.entity.Json;

import java.util.List;

public interface JsonService {
    boolean insert(Json json);
    boolean deleteByPrimaryKey(Long id);
    boolean updateByPrimaryKey(Json json);
    Json selectByPrimaryKey(Long id);
    List<Long> selectAllIds();
    List<Json> selectByIdList(List<Long> ids);
    
    
}
