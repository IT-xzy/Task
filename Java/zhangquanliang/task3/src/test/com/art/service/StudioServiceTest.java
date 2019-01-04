package com.art.service;

import com.art.pojo.Studio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author suger
 * @date 2018/11/5 20:05
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})

public class StudioServiceTest {
    @Autowired
    StudioService studioService;
    private static final Logger logger = LoggerFactory.getLogger(StudioServiceTest.class);
    @Test
    public void insert() throws Exception {
        Studio  studio =  new Studio();
        studio.setName("简介");
        studio.setType("艺术家简介");
        studio.setImg("这是图片");
        studio.setContent("----这是正文----");
        studio.setUpdateBy("管理员");
        boolean s = studioService.insert(studio);

        logger.info("----新增工作室简介----:"+s);
    }

    @Test
    public void delete() throws Exception {
        int id = 1;
        boolean s  = studioService.delete(id);
        logger.info("----删除简介----："+s);
    }

    @Test
    public void getStudio() throws Exception {
        int id = 1;
        Studio studio = studioService.getStudio(id);
        logger.info("----单个简介查询----:"+studio);
        logger.info("----------------我是查询分隔线-----------------------");
        Boolean status  = null;
        String updateBy = null;
        List<Studio> list = studioService.getStudio(status,updateBy);
        logger.info("----简介查询，返回列表----"+list);
    }

    @Test
    public void update() throws Exception {

        Studio  studio =  new Studio();
        studio.setName("更新简介");
        studio.setType("作者简介");
        studio.setImg("关系图片");
        studio.setContent("----这是正文，已经更新----");
        studio.setUpdateBy("超级管理员");
        boolean s = studioService.update(studio);

        logger.info("----新增工作室简介----:"+s);

    }

}