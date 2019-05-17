import cn.wp.model.Role;
import cn.wp.service.RoleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: RoleTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:01
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleTest {
    @Autowired
    RoleService roleService;
    Role role = new Role();
    Logger logger = Logger.getLogger(Role.class);

    @Test
    public void insert() {
        role.setId(5L);
        role.setRoleName("运营");
        role.setCreateAt(5L);
        role.setUpdateAt(5L);
        role.setCreateBy(5L);
        role.setUpdateBy(5L);
        logger.info(roleService.insert(role));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(roleService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        role.setId(5L);
        role.setRoleName("运营管理");
        role.setCreateAt(5L);
        role.setUpdateAt(5L);
        role.setCreateBy(5L);
        role.setUpdateBy(5L);
        logger.info(roleService.updateByPrimaryKey(role));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(roleService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(roleService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(roleService.selectByDynamicCondition("运营"));
    }
}
