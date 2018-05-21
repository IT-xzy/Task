package utils;

import Service.StudyService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.utils.Md5Utils;

/**
 * Created by Administrator on 2017-10-01.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class Md5UtilsTest {
    private static Logger LoggerMUT = Logger.getLogger(StudyService.class);

    @Test
    public void md5Test(){

        String pwd = "qazwsx";
        LoggerMUT.info("加密前：" + pwd);
        Md5Utils md5 = new Md5Utils();
        LoggerMUT.info("16位加密后: "+ md5.getMD5(pwd));
        // 16位的加密
//        LoggerMUT.info("16位加密后: "+ md5.getMD5(pwd).substring(8, 24));

    }

}
