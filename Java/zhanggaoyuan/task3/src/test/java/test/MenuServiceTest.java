//package test;
//
//import com.alibaba.fastjson.JSON;
//import org.apache.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import jnshu.model.Banner;
//import jnshu.model.Cmenu;
//import jnshu.model.Submenu;
//import jnshu.service.MenuService;
//
//import java.util.List;
//
////@RunWith就是一个运行器，@RunWith(JUnit4.class)就是指用JUnit4来运行
////@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
//@RunWith(SpringJUnit4ClassRunner.class)
////Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//
//
//public class MenuServiceTest {
//    private static Logger logger = Logger.getLogger(MenuServiceTest.class);
//    @Autowired
//    MenuService menuService;
//    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
//    Cmenu cmenu=new Cmenu ();
//    Submenu submenu=new Submenu ();
//    Banner banner=new Banner ();
//
//    //    联表查询banner的内容
//    @Test
//    public void testSelectB() {
//        List rs=menuService.selctBanner ();
//        logger.info (JSON.toJSONString (rs));
//    }
//
////    联表查询菜单信息
//    @Test
//    public void testSelectM() {
//    List rs=menuService.selectMenu ();
//    logger.info (JSON.toJSONString (rs));
//}
//
////    新增
//    @Test
//    public void testInsertCmenu() {
////        cmenu.setCmenuId (4);
//        cmenu.setCreatTime (timeStamp);
//        cmenu.setUpdateTime (timeStamp);
//        cmenu.setCmenuName ("资讯");
//        int rs = menuService.insertCmenu (cmenu);
//        logger.info (rs);
//    }
//    @Test
//    public void testInsertSubmenu() {
//        submenu.setCreatTime (timeStamp);
//        submenu.setUpdateTime (timeStamp);
//        submenu.setSubmenuName ("33二级标题");
//        submenu.setCmenuId (3);
//        int rs = menuService.insertSubmenu (submenu);
//        logger.info (rs);
//    }
//    @Test
//    public void testInsertBanner() {
////        banner.setBannerId (1);
//        banner.setCreatTime (timeStamp);
//        banner.setUpdateTime (timeStamp);
//        banner.setBannerPutawayTime (timeStamp);
//        banner.setBannerRedactor ("张三66");
//        banner.setBannerStatus (true);
//        banner.setProductionId (6);
//        int rs = menuService.insertBanner (banner);
//        logger.info (rs);
//    }
//
//    //    删除
//    @Test
//    public void testDeleteCmenu() {
//        int rs = menuService.deleteCmenuByPrimaryKey (1);
//        logger.info (rs);
//    }
//    @Test
//    public void testDeleteSubmenu() {
//        int rs = menuService.deleteSubmenuByPrimaryKey (1);
//        logger.info (rs);
//    }
//    @Test
//    public void testDeleteBanner() {
//        int rs = menuService.deleteBannerByPrimaryKey (1);
//        logger.info (rs);
//    }
//
//    //    更新
//    @Test
//    public void testUpdateCmenu() {
//        cmenu.setCmenuId (2);
//        cmenu.setUpdateTime (timeStamp);
//        cmenu.setCmenuName ("影像.摄影");
//        int rs = menuService.updateCmenuByPrimaryKeySelective (cmenu);
//        logger.info (rs);
//    }
//    @Test
//    public void testUpdateSubmenu() {
//        submenu.setSubmenuId (2);
//        submenu.setUpdateTime (timeStamp);
//        submenu.setSubmenuName ("垂钓者空间");
//        int rs = menuService.updateSubmenuByPrimaryKeySelective (submenu);
//        logger.info (rs);
//    }
//    @Test
//    public void testUpdateBanner() {
//        banner.setBannerId (2);
//        banner.setUpdateTime (timeStamp);
//        banner.setBannerRedactor ("李四");
//        banner.setProductionId (2);
//        int rs = menuService.updateBannerByPrimaryKeySelective (banner);
//        logger.info (rs);
//    }
//
//    //    查询
//    @Test
//    public void testSelectCmenu() {
//        Cmenu rs = menuService.selectCmenuByPrimaryKey (2);
//        logger.info (JSON.toJSONString (rs));
//    }
//    @Test
//    public void testSelectSubmenu() {
//        Submenu rs = menuService.selectSubmenuByPrimaryKey (2);
//        logger.info (JSON.toJSONString (rs));
//    }
//    @Test
//    public void testSelectBanner() {
//        Banner rs = menuService.selectBannerByPrimaryKey (2);
//        logger.info (JSON.toJSONString (rs));
//    }
//}
