package test;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import jnshu.model.People;
import jnshu.model.Production;
import jnshu.model.Studio;
import jnshu.service.ProductionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith就是一个运行器，@RunWith(JUnit4.class)就是指用JUnit4来运行
//@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})

public class ProductionServiceTest {
    private static Logger logger = Logger.getLogger(ProductionServiceTest.class);
    @Autowired
    ProductionService productionService;
    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
    Production production=new Production ();
    Studio studio=new Studio ();
    People people=new People ();

//    //    查询二级菜单对应的图片信息
//    @Test
//    public void testSelectS(){
//
//        List rs= productionService.selectSubmenu (2);
//        logger.info (JSON.toJSONString (rs));
//    }
//    查询作品总条数
    @Test
    public void testSelectP(){

        int rs= productionService.selectProductionTotal ();
        logger.info (rs);
    }

    //    新增
    @Test
    public void testInsertProduction() {
//        production.setProductionId (1);
        production.setCreatTime (timeStamp);
        production.setUpdateTime (timeStamp);
        production.setProductionName ("蒙娜丽莎的微笑888");
        production.setProductionPutaway (true);
        production.setProductionPutawayTime (timeStamp);
        production.setSubmenuId (1);
        production.setArtistName ("张三");
        production.setProductionFinishTime ("2016年3月32号");
        production.setProductionSynopsis ("88从前有一座山，山上有一座庙。。。。。。");
        production.setProductionDetail ("老和尚对小和尚说，从前有一座山，山上有一座庙。。。。。。");
        production.setProductionExperience ("这幅画是在一个夜黑风高的晚上梦游的时候作的。。。。。。");
        production.setImageLinks ("http://134.175.119.11/88.jpg");
        production.setVideoLink ("视频的链接是。。。。。。");
        int rs = productionService.insertProduction (production);
        logger.info (rs);
    }
    @Test
    public void testInsertStudio() {
        studio.setCreatTime (timeStamp);
        studio.setUpdateTime (timeStamp);
        studio.setStudioName ("快乐水组新");
        studio.setStudioDetail ("新工作室创建于2018年13月8号。。。。。。");
        studio.setStudioContactWay ("有事请拨打119，谢谢");
        int rs = productionService.insertStudio (studio);
        logger.info (rs);
    }
    @Test
    public void testInsertPeople() {
        people.setCreatTime (timeStamp);
        people.setUpdateTime (timeStamp);
        people.setPeopleName ("黄五55");
        people.setPeopleImage ("5图片的链接是。。。。。。");
        people.setPeopleDetail ("5这个人详细介绍是。。。。。。");
        people.setPeopleProductionIntro ("5这个人的作品主要有。。。。。。");
        people.setPeopleContactWay ("5这个人的联系方式是。。。。。。");
        people.setIfArtist (true);
        people.setIfWorker (true);
        people.setPeoplePutaway (true);
        int rs = productionService.insertPeople (people);
        logger.info (rs);
    }

    //    删除
    @Test
    public void testDeleteProduction() {
        int rs = productionService.deleteProductionByPrimaryKey (1);
        logger.info (rs);
    }
    @Test
    public void testDeleteSubmenu() {
        int rs = productionService.deleteStudioByPrimaryKey (1);
        logger.info (rs);
    }
    @Test
    public void testDeleteBanner() {
        int rs = productionService.deletePeopleByPrimaryKey (1);
        logger.info (rs);
    }

    //    更新
    @Test
    public void testUpdateProduction() {
        production.setProductionId (2);
        production.setProductionName ("蒙娜丽莎的眼泪");
        int rs = productionService.updateProductionByPrimaryKeySelective (production);
        logger.info (rs);
    }
    @Test
    public void testUpdateStudio() {
        studio.setStudioId (2);
        studio.setUpdateTime (timeStamp);
        studio.setStudioContactWay ("联系方式更改为119");
        int rs = productionService.updateStudioByPrimaryKeySelective (studio);
        logger.info (rs);
    }
    @Test
    public void testUpdatePeple() {
        people.setPeopleId (2);
        people.setUpdateTime (timeStamp);
        people.setPeopleContactWay ("这人的联系方式更改为。。。。。。");
        int rs = productionService.updatePeopleByPrimaryKeySelective (people);
        logger.info (rs);
    }

    //    查询
    @Test
    public void testSelectProduction() {
        Production rs = productionService.selectProductionByPrimaryKey (2);
        logger.info (JSON.toJSONString (rs));
    }
    @Test
    public void testSelectStudio() {
        Studio rs = productionService.selectStudioByPrimaryKey (2);
        logger.info (JSON.toJSONString (rs));
    }
    @Test
    public void testSelectPeople() {
        People rs = productionService.selectPeopleByPrimaryKey (2);
        logger.info (JSON.toJSONString (rs));
    }
}
