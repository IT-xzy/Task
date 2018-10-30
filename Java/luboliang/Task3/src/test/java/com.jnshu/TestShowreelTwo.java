package com.jnshu;

import com.jnshu.model.ShowreelTwo;
import com.jnshu.mapper.ShowreelTwoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestShowreelTwo {
    @Autowired
    ShowreelTwoDao showreelTwoDao;

    ShowreelTwo showreelTwo = new ShowreelTwo();

    @Test
    public void add() {
        showreelTwo.setCreate_at(System.currentTimeMillis());
        showreelTwo.setEditor("梵高");
        showreelTwo.setUpdate_at(System.currentTimeMillis());
        showreelTwo.setShowreel_name("梦雨童生");
        showreelTwo.setShowreel_one_name("绘画.装置");
        showreelTwo.setState("上架");
        showreelTwoDao.addShowreelTow(showreelTwo);
        System.out.println("id........======...====" + showreelTwo.getId());
    }

    @Test
    public void delete() {
        System.out.println(showreelTwoDao.deleteShowreelTow(20));

    }

    @Test
    public void update() {
        showreelTwo.setCreate_at(System.currentTimeMillis());
        showreelTwo.setEditor("梵高");
        showreelTwo.setUpdate_at(System.currentTimeMillis());
        showreelTwo.setShowreel_name("梦雨童生");
        showreelTwo.setShowreel_one_name("绘画.装置");
        showreelTwo.setState("上架");
        showreelTwo.setId(2);
        System.out.println(showreelTwoDao.updateShowreelTow(showreelTwo));

    }

    @Test
    public void findBy() {
        System.out.println(showreelTwoDao.findByShowreelTow(1));

    }

    @Test
    public void findAll() {
        System.out.println(showreelTwoDao.findAllShowreelTow());

    }

}
