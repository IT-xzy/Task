import com.alibaba.fastjson.JSON;
import jnshu.model.ExcellentStudent;
import jnshu.model.Profession;
import jnshu.model.RestUser;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestOne {

    private static Logger logger = Logger.getLogger (TestOne.class);
    @Qualifier("studentServer")
    @Autowired
    StudentService studentService;
    ExcellentStudent student = new ExcellentStudent ();
    RestUser restUser = new RestUser ();

//    @Autowired
//    ProfessionService professionService;
//    Profession profession=new Profession ();


    long timeStamp = System.currentTimeMillis ();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)


    @Test
    public void a() {
        List st = (List) studentService.selectByName ("苏正荣");
        logger.info (JSON.toJSONString (st));

    }

}
