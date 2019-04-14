package com.ptteng;


import com.ptteng.model.Module;
import com.ptteng.service.ModuleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ModuleTest {
    @Autowired
    ModuleService moduleService;
    Module module = new Module();
    Logger logger = Logger.getLogger(Module.class);
    @Test
    public void insert(){
        module.setCreateAt(1212L);
        module.setCreateBy(2L);
        module.setFatherNodeId(3L);
        module.setName("留言管理");
        module.setUpdateAt(3121L);
        module.setUpdateBy(2L);
        module.setUrl("/asda/afaf");
     logger.info( moduleService.insert(module));
    }
    @Test
    public void deleteByPrimaryKey(){
        logger.info(moduleService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        module.setCreateAt(1212L);
        module.setCreateBy(2L);
        module.setFatherNodeId(3L);
        module.setName("管理");
        module.setUpdateAt(3121L);
        module.setUpdateBy(2L);
        module.setUrl("/asda/afaf");
        module.setId(4L);
        logger.info(moduleService.updateByPrimaryKey(module));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(moduleService.selectByPrimaryKey(2L));
    }
    @Test
    public void selectAll(){
        logger.info(moduleService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(moduleService.selectByDynamicCondition("留言管理"));
    }
}
