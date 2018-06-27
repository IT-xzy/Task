package com.fml.mapper;

import com.fml.pojo.Vocation;

import java.util.List;

public interface VocationMapper {
    /*List<Vocation> getAll();
    List<Vocation> getByVocationType(String type);*/
    Vocation getByVocationId(int id);
    int getTotalCount();
}
