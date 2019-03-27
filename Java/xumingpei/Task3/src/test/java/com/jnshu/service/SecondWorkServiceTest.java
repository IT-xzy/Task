package com.jnshu.service;

import com.jnshu.pojo.SecondWork;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 3:05
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SecondWorkServiceTest {
    private static Logger logger = Logger.getLogger(SecondWorkServiceTest.class);


    @Autowired
    SecondWorkService secondWorkService;
    SecondWork secondWork = new SecondWork();

    @Test
    public void insert(){

        secondWork.setName("游客1");
        secondWork.setFirstId(1);
        secondWork.setStatus(1);
        secondWork.setCreateAt(System.currentTimeMillis());
        secondWork.setUpdateAt(System.currentTimeMillis());
        secondWork.setCreateBy("徐铭培1");
        secondWork.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(secondWorkService.insert(secondWork)));
    }

    @Test
    public void update(){

        secondWork.setName("被更改的游客");
        secondWork.setFirstId(1);
        secondWork.setStatus(0);
        secondWork.setCreateAt(System.currentTimeMillis());
        secondWork.setUpdateAt(System.currentTimeMillis());
        secondWork.setCreateBy("管理员");
        secondWork.setUpdateBy("更改人");
        secondWork.setSecondId(1);
        logger.info(String.valueOf(secondWorkService.updateByPrimaryKey(secondWork)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(secondWorkService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(secondWorkService.deleteByPrimaryKey((long)1)));
    }
}
