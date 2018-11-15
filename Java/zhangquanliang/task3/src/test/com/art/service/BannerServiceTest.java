package com.art.service;

import com.art.mapper.BannerMapper;
import com.art.pojo.Banner;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * created by suger on 2018/11/1
 */
public class BannerServiceTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    BannerService bannerService = ctx.getBean(BannerService.class);
    // BannerMapper bannerMapper = ctx.getBean(BannerMapper.class);
    static Logger log = Logger.getLogger(BannerServiceTest.class);
    @Test
    public void insert() throws Exception {
        Banner banner = new Banner();
        banner.setName("插入----轮播图");
        banner.setStatus(true);
        banner.setUrl("插入----url");
        Boolean tag = bannerService.insert(banner);
        log.info("插入结果："+tag);
        log.info("-----"+banner.getId());
    }
    @Test
    public void update() throws Exception {
        Banner banner = new Banner();
        banner.setId(12);
        banner.setName("更新----轮播图");
        banner.setStatus(false);
        banner.setUrl("更新-----url");
        log.info("更新结果："+bannerService.update(banner));
    }

    @Test
    public void delete() throws Exception {
        int id = 13;
        log.info("删除结果："+  bannerService.delete(id));
    }

    @Test
    public void getBanner() throws Exception {
        int id = 12;
        log.info("根据id查询："+bannerService.getBanner(id));
    }

    @Test
    public void findBanners() throws Exception {
        Boolean status = true;
        String updateBy = null;
        List banners = bannerService.findBanners(status,updateBy);
        log.info("条件查询："+banners);
    }

}