import cn.wp.model.Works;
import cn.wp.service.WorksService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: WorksTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:01
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorksTest {
    @Autowired
    WorksService worksService;
    Works works = new Works();
    Logger logger = Logger.getLogger(Works.class);

    @Test
    public void insert() {
        works.setId(5L);
        works.setName("随便画画");
        works.setIntroduction("好");
        works.setThumbnail("/sdadas/adsas");
        works.setvideoLink("/sad/asd");
        works.setdetailPicture("/asd/asda");
        works.setintroductionWord("真好");
        works.setcollectionManageId(5L);
        works.setCreateAt(2222L);
        works.setUpdateAt(1212L);
        works.setCreateBy(5L);
        works.setUpdateBy(5L);
        works.setState(5L);
        logger.info(worksService.insert(works));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(worksService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        works.setId(5L);
        works.setName("画画");
        works.setIntroduction("好");
        works.setThumbnail("/sdadas");
        works.setvideoLink("/sad");
        works.setdetailPicture("/asd");
        works.setintroductionWord("真好");
        works.setcollectionManageId(5L);
        works.setCreateAt(2222L);
        works.setUpdateAt(1212L);
        works.setCreateBy(5L);
        works.setUpdateBy(5L);
        works.setState(5L);
        logger.info(worksService.updateByPrimaryKey(works));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(worksService.selectByPrimaryKey(1L));
    }

    @Test
    public void selectAll() {
        logger.info(worksService.selectAll());
    }

    @Test
    public void selectByDynamic() {
        logger.info(worksService.selectByDynamicCondition("梵高的老舅", 1L));
    }
}
