package cn.wp.dao;

import cn.wp.entity.Json;
import cn.wp.service.JsonService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring-mvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonTest {
  @Autowired JsonService jsonService;
  Json json = new Json();

  Logger logger = Logger.getLogger(JsonTest.class);

  @Test
  public void selectAll() {
    logger.info(jsonService.selectAll());
  }
}
