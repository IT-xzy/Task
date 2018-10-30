package com.artist.service;

import com.artist.pojo.Tourist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TouristServiceImplTest {
    @Resource(name = "touristServiceImpl")
    private TouristService touristService;

    @Test
    public void saveTourist() {
        Tourist t =new Tourist();
        t.setTouristName("游客1");
        t.setCreateTime(System.currentTimeMillis());
        t.setExitTime(System.currentTimeMillis());
        String str=touristService.saveTourist(t);
        System.out.println(str);
    }
}