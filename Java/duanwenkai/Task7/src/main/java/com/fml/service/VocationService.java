package com.fml.service;

import com.fml.pojo.Vocation;

import java.util.List;

public interface VocationService {
    Vocation getByVocationId(int id);
    int getTotalCount();
    List<Vocation> getAllVocation();
}
