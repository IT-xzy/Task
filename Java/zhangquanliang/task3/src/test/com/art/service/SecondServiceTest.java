package com.art.service;

import com.art.pojo.Second;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author suger
 * @date 2018/11/5 19:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})
public class SecondServiceTest {

    @Autowired
    SecondService secondService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecondServiceTest.class);

    @Test
    public void insert() throws Exception {
        Second second = new Second();
        second.setName("绘画");
        second.setFirstId(1);
        second.setStatus(false);
        second.setUpdateBy("张大千");
        boolean s = secondService.insert(second);
        logger.info("----新增作品集----:"+s);
    }

    @Test
    public void delete() throws Exception {
        int id = 1;
        boolean s = secondService.delete(id);
        logger.info("----删除----："+s);

    }

    @Test
    public void getSecond() throws Exception {
        int id = 1;
        Second second = secondService.getSecond(id);
        logger.info("----单个查询----:"+second);
        logger.info("---------------------------------------");
        Boolean status  = true;
        String updateBy = null;
        List<Second> secondList = secondService.getSecond(status,updateBy);
        logger.info("----条件查询，返回列表----"+secondList);
    }


    @Test
    public void update() throws Exception {
        Second second = new Second();
        second.setId(1);
        second.setName("摄影");
        second.setFirstId(1);
        second.setStatus(true);
        second.setUpdateBy("张大千");
        boolean s = secondService.update(second);
        logger.info("----修改作品集----:"+s);
    }

}