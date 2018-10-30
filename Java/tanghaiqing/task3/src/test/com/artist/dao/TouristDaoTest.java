package com.artist.dao;

import com.artist.pojo.Tourist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TouristDaoTest {
    @Autowired
    private TouristDao touristDao;
    @Test
    public void queryTourists() {
        List<Tourist> list=touristDao.queryTourists();
        System.out.println(list);

    }

    @Test
    public void queryTourists1() {
        List<Tourist> list =touristDao.queryTourists1(2);
        System.out.println(list);
    }

    @Test
    public void delTourist() {
        touristDao.delTourist(4);
    }

    @Test
    public void saveTourist() {
        Tourist t =new Tourist();
        t.setTouristName("游客1");
        t.setCreateTime(System.currentTimeMillis());
        t.setExitTime(System.currentTimeMillis());
        touristDao.saveTourist(t);
    }

    @Test
    public void updateTourist() {
        Tourist t =new Tourist();
        t.setTouristId(3);
        t.setTouristName("游客4");
        t.setCreateTime(System.currentTimeMillis());
        t.setExitTime(System.currentTimeMillis());
        touristDao.updateTourist(t);
    }
}