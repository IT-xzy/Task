package com.tiles.dao;

import com.tiles.model.Home;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HomeMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(HomeMapperTest.class);
    @Autowired
    private HomeMapper homeMapper;

    @Test
    public void addHome() {
        Home home = new Home();
        home.setOline_num(1234);
        home.setFind_job(1000);
        home.setConsultant("宁姚");
        home.setIntroduce("才华横溢");
        home.setImg_path("/imges/fdsfafdasfadfsdafa.jpg");
        home.setCreate_at(System.currentTimeMillis());
        home.setUpdate_at(System.currentTimeMillis());

//        homeMapper.addHome(home);
        logger.info(""+home);
    }

    @Test
    public void test1() {
        List<Home> homeList = homeMapper.getAll();
        Home home = homeList.get(homeList.size()-1);

        logger.info("home{}",home.toString());
        logger.info("在线人数{}",home.getOline_num());
        logger.info("找到工作的{}",home.getFind_job());
    }
}