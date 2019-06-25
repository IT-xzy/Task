import cn.wp.model.Studio;
import cn.wp.service.StudioService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: StudioTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:01
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudioTest {
    @Autowired
    StudioService studioService;
    Studio studio = new Studio();
    Logger logger = Logger.getLogger(StudioTest.class);

    @Test
    public void insert() {
        studio.setId(5L);
        studio.setPicture("/asd/asd");
        studio.setText("sadasd");
        studio.setName("乌拉乌拉");
        studio.setState((byte) 5);
        studio.setCreateAt(5L);
        studio.setUpdateAt(5L);
        studio.setCreateBy(5L);
        studio.setUpdateBy(5L);
        logger.info(studioService.insert(studio));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(studioService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        studio.setId(5L);
        studio.setPicture("/asd");
        studio.setText("saaaa");
        studio.setName("乌拉乌拉");
        studio.setState((byte) 5);
        studio.setCreateAt(6L);
        studio.setUpdateAt(6L);
        studio.setCreateBy(6L);
        studio.setUpdateBy(6L);
        logger.info(studioService.updateByPrimaryKey(studio));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(studioService.selectByPrimaryKey(1L));
    }

    @Test
    public void selectAll() {
        logger.info(studioService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(studioService.selectByDynamicCondition("工作室简介", 2L));
    }

}
