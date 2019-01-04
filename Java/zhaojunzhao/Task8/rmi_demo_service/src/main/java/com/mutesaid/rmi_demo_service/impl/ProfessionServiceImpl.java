package com.mutesaid.rmi_demo_service.impl;

import com.mutesaid.rmi_demo_core.service.ProfessionService;
import com.mutesaid.rmi_demo_service.mapper.ProfessionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ProfessionServiceImpl implements ProfessionService {
    @Resource
    private ProfessionMapper professionMapper;

    @Override
    public Map<String, List> findProfessionList() {
        List<String> directionList = professionMapper.findDirectionList();
        log.info("find directionList size = [{}]", directionList.size());
        Map<String, List> job = new HashMap<>(directionList.size());
        directionList.forEach(item -> job.put(item, professionMapper.findProfessionList(item)));
        return job;
    }
}
