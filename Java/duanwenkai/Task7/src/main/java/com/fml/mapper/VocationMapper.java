package com.fml.mapper;

import com.fml.pojo.Vocation;

public interface VocationMapper {

    Vocation getByVocationId(int id);

    int getTotalCount();
}
