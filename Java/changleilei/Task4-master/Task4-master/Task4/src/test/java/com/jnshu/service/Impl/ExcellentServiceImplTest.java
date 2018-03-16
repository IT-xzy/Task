package com.jnshu.service.Impl;
import com.jnshu.dao.ExcellentMapper;
import com.jnshu.model.Excellent;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class ExcellentServiceImplTest {
    @Resource
    private ExcellentMapper excellentMapper;
    @Test
    public void deleteByid() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByid() throws Exception {

        Excellent a=excellentMapper.selectByid(1);
        System.out.println("------------");
        System.out.println(a);
    }

    @Test
    public void updateByidSelective() throws Exception {
    }

    @Test
    public void updateByid() throws Exception {
    }

    @Test
    public void getAllExcellent() throws Exception {
    }
}