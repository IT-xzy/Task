package com.mutesaid.impl;


import com.mutesaid.mapper.ProfessionMapper;
import com.mutesaid.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.oasisopen.sca.annotation.Remotable;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ProfessionServiceImpl implements ProfessionService {
    @Resource
    private ProfessionMapper professionMapper;

    @Override
    public Map<String, List> findProfessionList() {
        // 不支持Lambda表达式，暂时没写
//        List<String> directionList = professionMapper.findDirectionList();
//        log.info("find directionList size = [{}]", directionList.size());
//        Map<String, List> job = new HashMap<>(directionList.size());
//        directionList.forEach(item -> job.put(item, professionMapper.findProfessionList(item)));
        return null;
    }
}
