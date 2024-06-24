package com.jnshu.service.impl;

import com.jnshu.mapper.EnterpriseMapper;
import com.jnshu.model.Enterprise;
import com.jnshu.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> selectAll() {
        return enterpriseMapper.selectAll();
    }
}
