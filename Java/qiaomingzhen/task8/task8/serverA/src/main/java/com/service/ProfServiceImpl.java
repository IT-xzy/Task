package com.service;/*
 * @ClassName:ProfServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/7/28 14:16
 **/

import com.mapper.ProfMapper;
import com.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfServiceImpl implements ProfService {
    @Autowired
    private ProfMapper profMapper;

    @Override
    public List<Profession> group() {
        return profMapper.group();
    }

    @Override
    public void checkService() {

    }
}
