package com.mutesaid.rmi_demo_web.controller;

import com.mutesaid.rmi_demo_core.model.Response;
import com.mutesaid.rmi_demo_core.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@EnableCaching
@CacheConfig(cacheNames = "profession")
@Slf4j
public class ProfessionController {
    @Resource
    private ProfessionService professionService;

    @GetMapping("/a/profession")
    @Cacheable
    public Response findPofessionList() {
        Map<String, List> professionList = professionService.findProfessionList();
        log.info("find professionList size = {}", professionList.size());
        return new Response<>(0, "success", professionList);
    }
}
