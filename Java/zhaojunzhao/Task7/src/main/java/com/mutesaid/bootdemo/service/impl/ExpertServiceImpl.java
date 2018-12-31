package com.mutesaid.bootdemo.service.impl;

import com.mutesaid.bootdemo.mapper.ExpertMapper;
import com.mutesaid.bootdemo.model.Expert;
import com.mutesaid.bootdemo.service.ExpertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Resource
    private ExpertMapper expertMapper;

    @Override
    public List<Expert> findList() {
        return expertMapper.findList();
    }
}
