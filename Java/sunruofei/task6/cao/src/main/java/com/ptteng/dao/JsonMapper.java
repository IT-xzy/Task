package com.ptteng.dao;

import com.ptteng.entity.Json;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsonMapper {
    boolean insert(Json json);
    boolean deleteByPrimaryKey(Long id);
    boolean updateByPrimaryKey(Json json);
    Json selectByPrimaryKey(Long id);
    List<Long>  selectAllIds();
    List<Json> selectByIdList(List<Long> ids);
}
