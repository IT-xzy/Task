import jnshu.Service.JsonService;
import jnshu.Service.JsonServiceImpl.JsonServiceImpl;
import jnshu.controller.JsonController;
import jnshu.entity.Json;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    //    @Resource(name = "JsonServiceImp")
//    public JsonService jsonService;
    @Autowired
    JsonController jsonController;
    Logger logger = Logger.getLogger(test.class);

    @Test
    public void task() {

//        jsonController.selectById(1L);

//        List<Long> ids = jsonService.selectAllIds();
//        logger.info("ids=====" + ids);


//        List<Json> json = jsonService.selectByIdList(ids);
//        logger.info("json=====" + json);

//        List<Json> json=  jsonService.selectAll();
    }


}