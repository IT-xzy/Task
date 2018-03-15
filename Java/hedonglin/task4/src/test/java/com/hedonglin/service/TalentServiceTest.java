package com.hedonglin.service;


import com.hedonglin.model.Talent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TalentServiceTest {

    @Autowired
    private TalentService talentService;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void randomSelectTalent() {
        List<Talent> talentList=talentService.randomSelectTalent();
        System.out.println(talentList);
    }
}
