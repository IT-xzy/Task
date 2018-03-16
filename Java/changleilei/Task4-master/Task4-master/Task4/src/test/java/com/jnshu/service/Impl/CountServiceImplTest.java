package com.jnshu.service.Impl;
import com.jnshu.dao.ExcellentMapper;
import com.jnshu.model.Count;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CountServiceImplTest {
    @Resource
    private CountServiceImpl countServiceImpl;
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
        Count c=countServiceImpl.selectByid(1);
        System.out.println(c.getId());
    }

    @Test
    public void updateByidSelective() throws Exception {
    }

    @Test
    public void updateByid() throws Exception {
    }
}