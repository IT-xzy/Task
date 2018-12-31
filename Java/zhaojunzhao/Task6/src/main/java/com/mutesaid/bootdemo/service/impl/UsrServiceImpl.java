package com.mutesaid.bootdemo.service.impl;

import com.mutesaid.bootdemo.mapper.UsrMapper;
import com.mutesaid.bootdemo.model.Usr;
import com.mutesaid.bootdemo.service.UsrService;
import com.mutesaid.bootdemo.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
@Slf4j
public class UsrServiceImpl implements UsrService {
    @Resource
    private UsrMapper usrMapper;

    @Override
    public ArrayList<Usr> findByValue(String value) {
        log.info("查找用户 value = {}", value);
        return usrMapper.select(value);
    }

    @Override
    public Boolean matchPwd(String inputPwd, Usr usr) {
        return usr.getPwd().equals(MD5Util.encrypt(inputPwd, usr.getUpdateAt().toString()));
    }

    @Override
    public Usr findById(Long id) {
        log.info("查找用户 id = {}", id);
        return usrMapper.selectById(id);
    }

    @Override
    public Long insert(Usr usr) {
        log.info("新增用户");
        usrMapper.insert(usr);
        return usr.getId();
    }

    @Override
    public Long update(Usr usr) {
        log.info("更新用户 id = {}", usr.getId());
        return usrMapper.update(usr);
    }
}
