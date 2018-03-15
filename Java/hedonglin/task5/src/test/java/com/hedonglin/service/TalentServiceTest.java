package com.hedonglin.service;


import com.hedonglin.model.Talent;
import com.hedonglin.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;


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
        Talent talent=talentService.selectByPrimaryKey(1L);
        System.out.println(talent);
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


    @Test
    public void selectIdByName() {
        Long id=talentService.selectIdByName("韩要贺");
        System.out.println(id);
    }

    @Test
    public void saltTest() {
        String salt = UUID.randomUUID().toString();
        System.out.println("salt:"+salt);
        String password = MD5Util.mixPasswordWithSalt("123456", salt);
        System.out.println("password:"+password);
    }


    @Test
    public void selectByName() {
        Talent talent=talentService.selectByName("张庆东");
        System.out.println(talent);
    }

    @Test
    public void getToken() throws Exception {
        String fuck = "123,456";
        String[] fuck1 = fuck.split(",");
        for (String s : fuck1) {
            System.out.println(s);
        }
    }
}
