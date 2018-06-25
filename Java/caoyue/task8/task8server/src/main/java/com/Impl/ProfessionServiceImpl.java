package com.Impl;

import com.POJO.Profession;
import com.mappers.ProfessionMapper;
import com.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 职业（后端前端）实现类
 * @create: 2018/5/7 下午5:35
 */

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    
    public List<Profession> findFront() {
        return professionMapper.findFront();
    }
    
    public List<Profession> findAfter() {
        return professionMapper.findAfter();
    }
    
    public List<Profession> findOP() {
        return professionMapper.findOP();
    }
    
    public List<Profession> findPM() {
        return professionMapper.findPM();
    }
    
}
