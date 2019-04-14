package com.ptteng;


import com.ptteng.model.RoleModuleRelation;
import com.ptteng.service.RoleModuleRelationService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleModuleRelationTest {
    @Autowired
    RoleModuleRelationService roleModuleRelationService;
    RoleModuleRelation roleModuleRelation = new RoleModuleRelation();
    Logger logger =Logger.getLogger(RoleModuleRelationTest.class);
@Test
    public void insert (){
    roleModuleRelation.setRoleId(2L);
    roleModuleRelation.setModuleId(2L);
    logger.info(roleModuleRelationService.insert(roleModuleRelation));
}
@Test
    public void deleteByPrimaryKey(){
    logger.info(roleModuleRelationService.deleteByPrimaryKey(3L));
}
@Test
    public void updateByPrimaryKey(){
    roleModuleRelation.setRoleId(3L);
    roleModuleRelation.setModuleId(3L);
    roleModuleRelation.setId(3L);
    logger.info(roleModuleRelationService.updateByPrimaryKey(roleModuleRelation));
}
@Test
    public void selectByPrimaryKey(){
    logger.info(roleModuleRelationService.selectByPrimaryKey(1L));
}
@Test
    public void selectAll(){
    logger.info(roleModuleRelationService.selectAll());
}
}
