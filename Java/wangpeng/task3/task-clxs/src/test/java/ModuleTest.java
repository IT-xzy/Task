import cn.wp.model.Module;
import cn.wp.service.ModuleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: ModuleTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:03
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ModuleTest {
    @Autowired
    ModuleService moduleService;
    Module module = new Module();
    Logger logger = Logger.getLogger(Module.class);

    @Test
    public void insert() {
        module.setId(5L);
        module.setName("留言管理");
        module.setFatherNodeId(5L);
        module.setUrl("/ppk");
        module.setCreateAt(5L);
        module.setUpdateAt(5L);
        module.setCreateBy(5L);
        module.setUpdateBy(5L);
        logger.info(moduleService.insert(module));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(moduleService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        module.setId(5L);
        module.setName("管理");
        module.setFatherNodeId(5L);
        module.setUrl("/asda");
        module.setCreateAt(6L);
        module.setUpdateAt(6L);
        module.setCreateBy(6L);
        module.setUpdateBy(6L);
        logger.info(moduleService.updateByPrimaryKey(module));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(moduleService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(moduleService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(moduleService.selectByDynamicCondition("留言管理"));
    }
}
