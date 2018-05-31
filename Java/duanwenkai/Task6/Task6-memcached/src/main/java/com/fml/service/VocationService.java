package com.fml.service;

import com.fml.pojo.Vocation;

import java.util.List;

public interface VocationService {
    /*List<Vocation> selectAll();
    List<Vocation> getByVocationType(String type);*/
    Vocation getByVocationId(int id);
    int getTotalCount();
    List<Vocation> getAllVocation();
}
