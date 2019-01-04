package com.mutesaid.rmi_demo_service.impl;

import com.mutesaid.rmi_demo_core.model.Usr;
import com.mutesaid.rmi_demo_core.service.UsrService;
import com.mutesaid.rmi_demo_service.mapper.UsrMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@Slf4j
public class UsrServiceImpl implements UsrService {
    @Resource
    private UsrMapper usrMapper;

    @Override
    @GetMapping("/feign/usr")
    public ArrayList<Usr> findByValue(@RequestParam("value") String value) {
        log.info("查找用户 value = {}", value);
        return usrMapper.select(value);
    }

    @Override
    @GetMapping("/feign/u/usr/{id}")
    public Usr findById(@PathVariable("id") Long id) {
        log.info("查找用户 id = {}", id);
        return usrMapper.selectById(id);
    }

    @Override
    @PostMapping("/feign/u/usr")
    public Long insert(@RequestBody Usr usr) {
        log.info("新增用户");
        usrMapper.insert(usr);
        return usr.getId();
    }

    @Override
    @PutMapping("/feign/u/usr")
    public Long update(@RequestBody Usr usr) {
        log.info("更新用户 id = {}", usr.getId());
        return usrMapper.update(usr);
    }

}
