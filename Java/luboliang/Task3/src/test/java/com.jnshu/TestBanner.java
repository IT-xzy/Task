package com.jnshu;

import com.jnshu.mapper.BannerDao;
import com.jnshu.model.Banner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestBanner {
    @Autowired
    BannerDao bannerDao;
    @Test
    public void findAll(){

//        System.out.println(worksDao.findAllWorkss());
        System.out.println(bannerDao.findAllBanner());
        Banner banner=new Banner();
        banner.setState("上架");
        System.out.println(bannerDao.addBanner(banner));
    }



}
