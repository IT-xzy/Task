package com.jnshu.service.impl;

import com.jnshu.mapper.CareerMapper;
import com.jnshu.model.Career;
import com.jnshu.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerMapper careerMapper;

    @Override
    public List<Career> selectAll() {
        return careerMapper.selectAll();
    }
}
