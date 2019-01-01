package com.mutesaid.rmi_demo_service.impl;


import com.mutesaid.rmi_demo_core.model.Expert;
import com.mutesaid.rmi_demo_core.service.ExpertService;
import com.mutesaid.rmi_demo_service.mapper.ExpertMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ExpertServiceImpl implements ExpertService {
    @Resource
    private ExpertMapper expertMapper;

    @Override
    public List<Expert> findList() {
        System.out.println("8772");
        return expertMapper.findList();
    }
}
