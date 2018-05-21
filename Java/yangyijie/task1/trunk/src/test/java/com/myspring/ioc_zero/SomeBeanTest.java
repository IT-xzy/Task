package com.myspring.ioc_zero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Arike
 * Create_at 2017/12/3 16:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SomeBean.class)
public class SomeBeanTest {
    @Resource//@Autowired
    ApplicationContext ctx;
    
    @Test
    public void someBean()throws Exception {
        ctx.getBean(Bean1.class);
 
    }
}