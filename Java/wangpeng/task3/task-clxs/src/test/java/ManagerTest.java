import cn.wp.model.Manager;
import cn.wp.service.ManagerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: ManagerTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:02
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerTest {
    @Autowired
    ManagerService managerService;
    Logger logger = Logger.getLogger(ManagerTest.class);
    Manager manager = new Manager();

    @Test
    public void insert() {
        manager.setId(5L);
        manager.setName("阿迪达斯");
        manager.setPassword(12323213L);
        manager.setRole(5L);
        manager.setCreateAt(2020L);
        manager.setUpdateAt(2020L);
        manager.setCreateBy(5L);
        manager.setUpdateBy(5L);
        logger.info(managerService.insert(manager));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(managerService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        manager.setId(5L);
        manager.setName("卡巴斯基");
        manager.setPassword(233333L);
        manager.setRole(5L);
        manager.setCreateAt(2019L);
        manager.setUpdateAt(2019L);
        manager.setCreateBy(5L);
        manager.setUpdateBy(5L);
        logger.info(managerService.updateByPrimaryKey(manager));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(managerService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(managerService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(managerService.selectByDynamicCondition(1L, "梵高"));
    }
}
