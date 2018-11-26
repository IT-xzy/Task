package com.tiles.service;

import com.tiles.pojo.Profession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @author suger
 * @date 2018/11/17 20:26
 */
public class ProfessionServiceTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    ProfessionService professionService = ctx.getBean(ProfessionService.class);
    static Logger log = Logger.getLogger(ProfessionServiceTest.class);
    @Test
    public void listProfession() throws Exception {

        List<Profession> professionList = professionService.listProfession();
        for (Profession p : professionList){
            log.info("根据类型查询职业：----"+p);
        }
    }

}