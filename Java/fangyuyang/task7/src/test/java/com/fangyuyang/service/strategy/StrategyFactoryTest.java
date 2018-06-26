package com.fangyuyang.service.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StrategyFactoryTest {
@Autowired
private Strategy strategy;
    @Test
    public void doStrategy() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("E:\\学习资料\\JAVA工作\\90线.png"));
         if(inputStream!=null) System.out.println("inputstream 不为空");
         strategy.getStorage(inputStream);

    }
}