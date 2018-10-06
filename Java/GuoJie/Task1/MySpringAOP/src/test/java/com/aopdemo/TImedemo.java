package com.aopdemo;

import com.springAOP3.BulkInsert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:springAOP2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TImedemo {
    @Resource
    private BulkInsert bulkInsert;

    @Test
    public void Test1() {
        bulkInsert.Insert();
    }
}
