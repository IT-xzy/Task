import cn.wp.model.RoleModule;
import cn.wp.service.RoleModuleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: roleModuleTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:04
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleModuleTest {
    @Autowired
    RoleModuleService roleModuleService;
    RoleModule roleModule = new RoleModule();
    Logger logger = Logger.getLogger(RoleModuleTest.class);

    @Test
    public void insert() {
        roleModule.setId(5L);
        roleModule.setRoleId(5L);
        roleModule.setModuleId(5L);
        logger.info(roleModuleService.insert(roleModule));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(roleModuleService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        roleModule.setId(6L);
        roleModule.setRoleId(6L);
        roleModule.setModuleId(6L);

        logger.info(roleModuleService.updateByPrimaryKey(roleModule));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(roleModuleService.selectByPrimaryKey(1L));
    }

    @Test
    public void selectAll() {
        logger.info(roleModuleService.selectAll());
    }
}
