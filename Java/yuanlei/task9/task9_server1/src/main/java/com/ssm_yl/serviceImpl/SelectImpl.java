package com.ssm_yl.serviceImpl;

import com.ssm_yl.dao.Mapper;
import com.ssm_yl.pojo.Category;
import com.ssm_yl.service.SelectInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectImpl implements SelectInterface {
    @Autowired
    Mapper mapper;
    public Category select(int id){
        return mapper.select(id);
    }

}
