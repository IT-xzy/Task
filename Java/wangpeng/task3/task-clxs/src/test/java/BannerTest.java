import cn.wp.model.Banner;
import cn.wp.service.BannerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: BannerTest
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/11 12:31
 * @Version: 1.0
 */

@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerTest {
    @Autowired
    BannerService bannerService;
    Banner banner = new Banner();
    Logger logger = Logger.getLogger(BannerTest.class);

    @Test
    public void insert() {
        banner.setId(6L);
        banner.setPicture("/88www");
        banner.setUrl("/sad/qqq");
        banner.setState((byte) 6);
        banner.setCreateAt(2020L);
        banner.setUpdateAt(2020L);
        banner.setCreateBy(2020L);
        banner.setUpdateBy(2020L);
        logger.info(bannerService.insert(banner));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(bannerService.deleteByPrimaryKey(1L));
    }

    @Test
    public void updateByPrimaryKey() {
        banner.setId(5L);
        banner.setPicture("asd65416");
        banner.setUrl("/www/com");
        banner.setState((byte) 6);
        banner.setCreateAt(2020L);
        banner.setUpdateAt(2020L);
        banner.setCreateBy(6L);
        banner.setUpdateBy(6L);
        logger.info(bannerService.updateByPrimaryKey(banner));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(bannerService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(bannerService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(bannerService.selectByDynamicCondition(2, "梵高"));
    }
}