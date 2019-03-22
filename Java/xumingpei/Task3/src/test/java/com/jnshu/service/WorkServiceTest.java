package com.jnshu.service;

import com.jnshu.pojo.Work;
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
public class WorkServiceTest {
    @Autowired
    WorkService workService;
    Work work = new Work();
    private static Logger logger = LoggerFactory.getLogger(WorkServiceTest.class);

    @Test
    public void insert(){

        work.setName("游客1");
        work.setIntroduction("作品介绍");
        work.setStatus(1);
        work.setFirstId(2432);
        work.setSecondId(47645);
        work.setThumbnail("缩略图");
        work.setUrl("www.jnshu.com");
        work.setPicture("画");
        work.setContent("正文");
        work.setCreateAt(System.currentTimeMillis());
        work.setUpdateAt(System.currentTimeMillis());
        work.setCreateBy("徐铭培1");
        work.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(workService.insert(work)));
    }

    @Test
    public void update(){

        work.setName("213efswe");
        work.setIntroduction("作品介绍ew21321");
        work.setStatus(0);
        work.setFirstId(2432);
        work.setSecondId(47645);
        work.setThumbnail("缩略图1");
        work.setUrl("www.jnshu.com/html");
        work.setPicture("画面");
        work.setContent("正文内容");
        work.setCreateAt(System.currentTimeMillis());
        work.setUpdateAt(System.currentTimeMillis());
        work.setCreateBy("管理员");
        work.setUpdateBy("更改人");
        work.setId(1);
        logger.info(String.valueOf(workService.updateByPrimaryKey(work)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(workService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(workService.deleteByPrimaryKey((long)1)));
    }
}
