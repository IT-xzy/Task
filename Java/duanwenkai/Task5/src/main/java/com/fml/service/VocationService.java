package com.fml.service;

import com.fml.pojo.Vocation;

public interface VocationService {
    /*List<Vocation> selectAll();
    List<Vocation> getByVocationType(String type);*/
    Vocation getByVocationId(int id);
    int getTotalCount();
}
