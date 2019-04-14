package com.ptteng;


import com.ptteng.model.Manager;
import com.ptteng.service.ManagerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerTest {
    @Autowired
    ManagerService managerService;
    Logger logger = Logger.getLogger(ManagerTest.class);
    Manager manager = new Manager();

    @Test
    public void insert() {
        manager.setCreateAt(2018L);
        manager.setCreateBy(3L);
        manager.setName("qweqe");
        manager.setPassword(12323213L);
        manager.setRoleId(1L);
        manager.setUpdateAt(2018L);
        manager.setUpdateBy(2L);
        logger.info(managerService.insert(manager));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(managerService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        manager.setUpdateBy(2L);
        manager.setUpdateAt(1990L);
        manager.setCreateAt(2018L);
        manager.setCreateBy(3L);
        manager.setName("asfdaas");
        manager.setPassword(12323213L);
        manager.setRoleId(1L);
        manager.setId(4L);
        logger.info(managerService.updateByPrimaryKey(manager));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(managerService.selectByPrimaryKey(2L));
    }

    @Test
    public void selecctAll() {
        logger.info(managerService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(managerService.selectByDynamicCondition(1L,"梵高"));
    }
}






