package com.myspring.aop.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Arike
 * Create_at 2017/12/7 16:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/myspring/aop/xml/aop.xml")
public class RunTest {
    @Autowired
    Run run;
    @Test
    public void circle() throws Exception {
        run.circle();
    }
    @Test
    public void test()throws Exception {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
    }
    
}