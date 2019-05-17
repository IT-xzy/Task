import cn.wp.model.CollectionManage;
import cn.wp.service.CollectionManageService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: CollectionManageTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:03
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CollectionManageTest {
    @Autowired
    CollectionManageService collectionManageService;
    CollectionManage collectionManage = new CollectionManage();
    Logger logger = Logger.getLogger(CollectionManageTest.class);

    @Test
    public void insert() {
        collectionManage.setId(5L);
        collectionManage.setName("安安");
        collectionManage.setState(5L);
        collectionManage.setcollectionClassId(5L);
        collectionManage.setCreateAt(2020L);
        collectionManage.setUpdateAt(2020L);
        collectionManage.setCreateBy(5L);
        collectionManage.setUpdateBy(5L);
        logger.info(collectionManageService.insert(collectionManage));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(collectionManageService.deleteByPrimaryKey(1L));
    }

    @Test
    public void updateByPrimaryKey() {
        collectionManage.setId(5L);
        collectionManage.setName("瓦特");
        collectionManage.setState(5L);
        collectionManage.setcollectionClassId(5L);
        collectionManage.setCreateAt(2019L);
        collectionManage.setUpdateAt(2019L);
        collectionManage.setCreateBy(5L);
        collectionManage.setUpdateBy(5L);
        logger.info(collectionManageService.updateByPrimaryKey(collectionManage));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(collectionManageService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(collectionManageService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(collectionManageService.selectByDynamicCondition("绘画", 1L));
    }
}
