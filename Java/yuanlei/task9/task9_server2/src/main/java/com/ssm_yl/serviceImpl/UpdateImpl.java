package com.ssm_yl.serviceImpl;

import com.ssm_yl.dao.Mapper;
import com.ssm_yl.pojo.Category;
import com.ssm_yl.service.UpdateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UpdateImpl implements UpdateInterface {
    @Autowired
    Mapper mapper;
    public int update(Category category){
        System.out.println(category.toString());
        return mapper.update(category);
    }
}
