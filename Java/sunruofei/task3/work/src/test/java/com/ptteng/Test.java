package com.ptteng;

import com.ptteng.model.RoleModuleRelation;
import com.ptteng.service.RoleModuleRelationService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/1/27  20:56
 * @Version 1.0
 **/
@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
@Autowired
RoleModuleRelationService roleModuleRelationService;

@org.junit.Test
public void ooooo(){

    System.out.println( roleModuleRelationService.selectByDynamicCondition(2L));
}


}
