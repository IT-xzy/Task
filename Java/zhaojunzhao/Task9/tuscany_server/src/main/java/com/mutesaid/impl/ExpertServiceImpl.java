package com.mutesaid.impl;


import com.mutesaid.mapper.ExpertMapper;
import com.mutesaid.model.Expert;
import com.mutesaid.service.ExpertService;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Remotable
public class ExpertServiceImpl implements ExpertService {
    @Resource
    private ExpertMapper expertMapper;

    @Override
    public List<Expert> findList() {
        return expertMapper.findList();
    }
}
