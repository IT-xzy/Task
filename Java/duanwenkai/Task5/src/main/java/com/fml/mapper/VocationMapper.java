package com.fml.mapper;

import com.fml.pojo.Vocation;

public interface VocationMapper {
    /*List<Vocation> getAll();
    List<Vocation> getByVocationType(String type);*/
    Vocation getByVocationId(int id);
    int getTotalCount();
}
