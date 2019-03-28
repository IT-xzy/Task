package com.jnshu.service;

import com.jnshu.pojo.Banner;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author pipiretrak
 * @date 2019/3/10 - 12:34
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerServiceTest {
    private static Logger logger = Logger.getLogger(BannerServiceTest.class);
    @Autowired
    BannerService bannerService;
    Banner banner = new Banner();
    long timeStmo= System.currentTimeMillis();

    @Test
    public void insert(){

        banner.setCover("cover1");
        banner.setUrl("www.ewq23.com");
        banner.setStatus(1);
        banner.setCreateAt(timeStmo);
        banner.setUpdateAt(timeStmo);
        banner.setCreateBy("徐铭培");
        banner.setUpdateBy("海清");
        banner.setWorkId(10);
        logger.info(String.valueOf(bannerService.insert(banner)));
    }

    @Test
    public void update(){

        banner.setCover("updatecover");
        banner.setUrl("www.update.com");
        banner.setStatus(0);
        banner.setCreateAt(2019);
        banner.setUpdateAt(2019);
        banner.setCreateBy("1423GDFGFD");
        banner.setUpdateBy("123124WRA");
        banner.setId(18);
        logger.info(String.valueOf(bannerService.updateByPrimaryKey(banner)));

    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(bannerService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(bannerService.deleteByPrimaryKey((long)2)));
    }
}
