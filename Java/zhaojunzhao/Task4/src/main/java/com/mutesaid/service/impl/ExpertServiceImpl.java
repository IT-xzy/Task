package com.mutesaid.service.impl;

import com.mutesaid.mapper.ExpertMapper;
import com.mutesaid.pojo.Expert;
import com.mutesaid.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    @Override
    public List<Expert> getAllExpert() {
        return expertMapper.getAllExpert();
    }
}
