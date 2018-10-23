package com.jnshu;

import com.jnshu.mapper.ShowreelDao;

import com.jnshu.model.ShowreelOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestShowreelOneController {
    @Autowired
    ShowreelDao showreelDao;
    ShowreelOne showreelOne = new ShowreelOne();

    @Test
    public void add() {
        showreelOne.setCreate_at(System.currentTimeMillis());
        showreelOne.setUpdate_at(System.currentTimeMillis());
        showreelOne.setShowreel_name("绘画装置");
        showreelOne.setState("下架");
        showreelOne.setEditor("扣脚大汉");
        showreelDao.addShowreelOne(showreelOne);
        System.out.println("id===================" + showreelOne.getId());
    }

    @Test
    public void delete() {
        System.out.println(showreelDao.deleteShowreelOne(20));

    }

    @Test
    public void update() {
        showreelOne.setCreate_at(System.currentTimeMillis());
        showreelOne.setUpdate_at(System.currentTimeMillis());
        showreelOne.setShowreel_name("文字.诗");
        showreelOne.setState("下架");
        showreelOne.setEditor("小龙女");
        showreelOne.setId(2);
        System.out.println(showreelDao.updateShowreelOne(showreelOne));
    }

    @Test
    public void findBy() {
        System.out.println(showreelDao.findByShowreelOne(1));
    }

    @Test
    public void findAll() {
        System.out.println(showreelDao.findAllShowreelOne());

    }
}

