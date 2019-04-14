package com.ptteng;


import com.ptteng.model.Banner;
import com.ptteng.service.BannerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerTest {
    @Autowired
    BannerService bannerService;
    Banner banner = new Banner();
    Logger logger = Logger.getLogger(BannerTest.class);
    @Test
    public void insert() {
        banner.setPicture("/dsfdsf/dsfs");
        banner.setUpdateBy(2L);
        banner.setState(2);
        banner.setCreateAt(2018L);
        banner.setUpdateAt(2019L);
        banner.setCreateBy(2L);
        banner.setUrl("/sad/cxv");
        logger.info(bannerService.insert(banner));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(bannerService.deleteByPrimaryKey(1L));
    }

    @Test
    public void updateByPrimaryKey() {
        banner.setPicture("/dsfdsf/dsfs");
        banner.setUpdateBy(2L);
        banner.setState(2);
        banner.setCreateAt(2018L);
        banner.setUpdateAt(2019L);
        banner.setCreateBy(2L);
        banner.setUrl("/aaaad/cxv");
        banner.setId(2L);
        logger.info(bannerService.updateByPrimaryKey(banner));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(bannerService.selectByPrimaryKey(2L));
    }
    @Test
    public void selectAll(){
        logger.info(bannerService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){

        logger.info(bannerService.selectByDynamicCondition(2 , "梵高"));
    }
}
