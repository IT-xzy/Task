package com.ssm_yl.serviceImpl;

import com.ssm_yl.dao.Mapper;
import com.ssm_yl.service.DeleteInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteImpl implements DeleteInterface{
    @Autowired
    Mapper mapper;
    public void delete(int id) {
        mapper.delete(id);
    }
}
