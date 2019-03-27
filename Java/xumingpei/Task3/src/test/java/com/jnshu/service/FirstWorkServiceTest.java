package com.jnshu.service;

import com.jnshu.pojo.FirstWork;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 2:31
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class  FirstWorkServiceTest {
    private static Logger logger = Logger.getLogger(FirstWorkServiceTest.class);

    @Autowired
    FirstWorkService firstWorkService;
    FirstWork firstWork = new FirstWork();

    @Test
    public void insert(){

        firstWork.setFirstName("架上绘画装置");
        firstWork.setStatus(0);
        firstWork.setCreateAt(System.currentTimeMillis());
        firstWork.setUpdateAt(System.currentTimeMillis());
        firstWork.setCreateBy("徐铭培1");
        firstWork.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(firstWorkService.insert(firstWork)));
    }

    @Test
    public void update(){

        firstWork.setFirstName("改变名字");
        firstWork.setStatus(0);
        firstWork.setCreateAt(2019);
        firstWork.setUpdateAt(2019);
        firstWork.setCreateBy("rewadwd");
        firstWork.setUpdateBy("fsdfesr");
        firstWork.setFirstId(4);
        logger.info(String.valueOf(firstWorkService.updateByPrimaryKey(firstWork)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(firstWorkService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(firstWorkService.deleteByPrimaryKey((long)4)));
    }
}
