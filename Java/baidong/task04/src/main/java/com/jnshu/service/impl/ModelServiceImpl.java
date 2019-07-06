package com.jnshu.service.impl;

import com.jnshu.mapper.ModelMapper;
import com.jnshu.model.Model;
import com.jnshu.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<String> selectAll() {
        return modelMapper.selectAll();
    }
}
