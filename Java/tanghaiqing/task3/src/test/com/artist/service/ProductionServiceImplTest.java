package com.artist.service;

import com.artist.pojo.Production;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductionServiceImplTest {
    @Resource(name = "productionServiceImpl")
    private ProductionService productionService;

    @Test
    public void idparticulars() {
        Production production=productionService.idparticulars(3);
        System.out.println(production);
    }
}