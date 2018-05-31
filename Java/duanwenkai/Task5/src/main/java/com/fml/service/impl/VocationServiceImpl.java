package com.fml.service.impl;

import com.fml.mapper.VocationMapper;
import com.fml.pojo.Vocation;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocationServiceImpl implements VocationService {
    @Autowired
    VocationMapper vocationMapper;

    @Override
    public int getTotalCount() {
        return vocationMapper.getTotalCount();
    }

    @Override
    public Vocation getByVocationId(int id) {
        return vocationMapper.getByVocationId(id);
    }


    /*@Override
    public List<Vocation> selectAll() {
        List<Vocation> list = vocationMapper.getAll();
        return null;
    }

    @Override
    public List<Vocation> getByVocationType(String type) {
        return vocationMapper.getByVocationType(type);
    }*/
}
