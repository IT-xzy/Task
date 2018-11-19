package com.art.service;

import com.art.pojo.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author suger
 * @date 2018/11/5 22:26
 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class WorkServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(WorkServiceTest.class);

    @Autowired
    WorkService workService;
    @Test
    public void delete() throws Exception {
        int id = 2;
        logger.info("删除结果："+workService.delete(id));
    }

    @Test
    public void insert() throws Exception {

        Work work = new Work();
        work.setName("绘画");
        // 所属作品集
        work.setFirstId(1);
        // 所属作品分类
        work.setSecondId(1);
        work.setStatus(true);
        // 作品简介
        work.setIntroduce("风景画");
        work.setUrl("作品链接");
        work.setUpdateBy("李白");
        logger.info("插入："+workService.insert(work));
    }

    @Test
    public void getWork() throws Exception {

        int id = 2;
        logger.info("单个作品查询："+workService.getWork(id));
        logger.info("------------------------------------------------");

        Boolean status  = null;
        String updateBy = null;
        logger.info("条件查询："+workService.getWork(status,updateBy));
    }

    @Test
    public void update() throws Exception {
        Work work = new Work();
        work.setName("绘画-----更新");
        // 所属作品集
        work.setFirstId(1);
        // 所属作品分类
        work.setSecondId(1);
        work.setStatus(false);
        // 作品简介
        work.setIntroduce("风景画");
        work.setUrl("作品链接");
        work.setUpdateBy("李白");
        logger.info("插入："+workService.insert(work));
    }

}