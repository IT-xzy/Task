package com.art.service;

import com.art.pojo.First;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * @author suger
 * @date 2018/11/5 16:44
 */
public class FirstServiceTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    FirstService firstService = ctx.getBean(FirstService.class);
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FirstServiceTest.class);

    @Test
    public void insert() throws Exception {
        First first = new First();
        first.setName("架上绘画");
        // 上架状态
        first.setStatus(false);
        first.setUpdateBy("李白");
        boolean t = firstService.insert(first);
        logger.info("-----新增-----"+t);
    }

    @Test
    public void delete() throws Exception {
        int id = 6;
        boolean t = firstService.delete(id);
        logger.info("-----删除-----"+t);

    }

    @Test
    public void getFirst() throws Exception {
        int id = 1;
        First first = firstService.getFirst(id);
        logger.info("-----查询-----"+first);
        logger.info("==================================================");
        Boolean status = null;
        String updateBy = null;
        List results = firstService.getFirst(status,updateBy);
        logger.info("----查询列表----"+results);
    }

    @Test
    public void update() throws Exception {
        First first = new First();
        first.setId(1);
        first.setName("架上绘画---测试");
        // 上架状态
        first.setStatus(false);
        first.setUpdateBy("梵高");
        boolean t = firstService.update(first);
        logger.info("----更新----"+t);

    }

}