package cn.wyq.service.impl;

import cn.wyq.mapper.EngineerMapper;
import cn.wyq.pojo.Engineer;
import cn.wyq.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EngineerServiceImpl implements EngineerService {
    @Autowired
    EngineerMapper engineerMapper;

    @Override
    public List<Engineer> get(){
        return engineerMapper.get();
    }
}
