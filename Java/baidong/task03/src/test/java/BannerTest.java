import jnshu.model.*;
import jnshu.service.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import java.util.List;


@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerTest {
    @Autowired
    BannerService bannerService;

    private static Logger logger = Logger.getLogger(BannerTest.class);


    @Test
    public void select() {
        Long status = 1L;
        String name = "x";

        List<Banner> banner = bannerService.selectByDynamicCondition(status, name);
        System.out.println(banner);

    }
}
//}
////        firstWorks.setFirstName("wang");
//        firstWorks.setStateAt(20190506L);
//        firstWorks.setCreateBy(1L);
//        firstWorks.setStatus(1L);
//        firstWorks.setUpdateAt(20190506L);
////        firstWorks.setUpdateBy(1L);
////        调用service层进行运行
//        int insert = firstWorksService.insert(firstWorks);
//        logger.info(insert);
//    }
//
//    @Test
//    public void deleteByPrimaryKey() {
//        int deleteByPrimaryKey = firstWorksService.deleteByPrimaryKey(1L);
//        logger.info(deleteByPrimaryKey);
//    }
////
////    @Test
////    public void updateByPrimaryKey() {
////        banner.setPictureUrl("/dsfdsf/dsfs");
////        banner.setUpdateBy(2L);
////        banner.setStatus(1L);
////        banner.setCreateAt(2018L);
////        banner.setUpdateAt(2019L);
////        banner.setCreateBy(20130206L);
////        banner.setId(2L);
////        logger.info(bannerService.updateByPrimaryKey(banner));
////    }
////
////    @Test
////    public void selectByPrimaryKey() {
////      logger.info(bannerService.selectByPrimaryKey(2L));
////    }
////
////
////    @Test
////    public void selectByDynamicCondition(){
////        logger.info(bannerService.selectByDynamicCondition(1,"梵高"));
////    }
//
//}
