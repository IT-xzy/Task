package com.jnshu.service;

import com.jnshu.pojo.Studio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 3:05
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudioServiceTest {
    @Autowired
    StudioService studioService;
    Studio studio = new Studio();
    private static Logger logger = LoggerFactory.getLogger(StudioServiceTest.class);

    @Test
    public void insert(){

        studio.setName("游客1");
        studio.setStatus(1);
        studio.setPicture("画");
        studio.setContent("正文");
        studio.setCreateAt(System.currentTimeMillis());
        studio.setUpdateAt(System.currentTimeMillis());
        studio.setCreateBy("徐铭培1");
        studio.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(studioService.insert(studio)));
    }

    @Test
    public void update(){

        studio.setName("被更改的游客");
        studio.setStatus(0);
        studio.setPicture("画面");
        studio.setContent("内容");
        studio.setCreateAt(System.currentTimeMillis());
        studio.setUpdateAt(System.currentTimeMillis());
        studio.setCreateBy("管理员");
        studio.setUpdateBy("更改人");
        studio.setId(1);
        logger.info(String.valueOf(studioService.updateByPrimaryKey(studio)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(studioService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(studioService.deleteByPrimaryKey((long)1)));
    }
}
