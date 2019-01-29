package com.ptteng;


import com.ptteng.model.Role;
import com.ptteng.service.RoleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleTest {
    @Autowired
    RoleService roleService;
    @Autowired
    Role role ;
    Logger logger =Logger.getLogger(Role.class);
    @Test
    public void insert (){
        role.setCreateAt(1232L);
        role.setCreateBy(2L);
        role.setRoleName("运营");
        role.setUpdateAt(2313L);
        role.setUpdateBy(3L);
    logger.info(roleService.insert(role));
    }
    @Test
    public void deleteByPrimaryKey(){
        logger.info(roleService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        role.setCreateAt(1232L);
        role.setCreateBy(2L);
        role.setRoleName("产品");
        role.setUpdateAt(2313L);
        role.setUpdateBy(3L);
        role.setId(4L);
        logger.info(roleService.updateByPrimaryKey(role));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(roleService.selectByPrimaryKey(2L));
    }
    @Test
    public void selectAll(){
        logger.info(roleService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(roleService.selectByDynamicCondition("运营"));
    }
}
