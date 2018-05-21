package com.jnshu.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ExcellentMapperTest {
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
    }

    @Test
    public void updateByidSelective() throws Exception {
    }

    @Test
    public void updateByid() throws Exception {
    }
}