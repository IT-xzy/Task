package com.mutesaid.bootdemo.service.impl;

import com.mutesaid.bootdemo.mapper.ProfessionMapper;
import com.mutesaid.bootdemo.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
