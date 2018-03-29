package utils;

import Service.StudyService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.utils.DesUtils;

/**
 * Created by Administrator on 2017-10-01.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class DesUtilsTest {

    private static Logger LoggerDUT = Logger.getLogger(StudyService.class);

//    @Resource
//    private DesUtils desUtils;

    @Test
    public void desUtilsTest() {

        DesUtils desUtils = new DesUtils();
        //待加密内容
        String str = "俭学街";
        //密码，长度是8的倍数
        String password = "12345678";
        byte[] result = desUtils.desCrypto(str.getBytes(),password);
        LoggerDUT.info("加密后的内容" + new String(result));

        //将内容解密
        try{
            byte[] decryResult = desUtils.decrypt(result,password);
            LoggerDUT.info("解密后的内容: " + new String(decryResult));
        }catch (Exception e)
        {
            e.printStackTrace();
            LoggerDUT.error("e.getMessage()： " + e.getMessage());
        }
    }
}
