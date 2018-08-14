package com.service.impl;

import com.exception.MyException;
import com.pojo.Profession;
import com.service.PttDaoService;
import com.tools.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PttDaoServiceImpl implements PttDaoService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int getStudentSum() throws MyException {
        return redisUtil.getSum()[0];
    }

    @Override
    public int getGraduateSum() throws MyException {
        return redisUtil.getSum()[1];
    }

    @Override
    public List<Profession> getAllProfession() throws MyException {
        return redisUtil.getProfessions();
    }

    @Override
    public List<String> getImageAddress() {
        List<String> list = new ArrayList<>();
        list.add("../images/banner-1.jpg");
        list.add("../images/banner-2.jpg");
        list.add("../images/banner-3.jpg");
        list.add("../images/banner-4.jpg");
        return list;
    }
}
