import com.lihoo.ssm.util.MD5Encryption;
import com.lihoo.ssm.util.MD5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

import static com.lihoo.ssm.util.MD5Util.MD5;
import static com.lihoo.ssm.util.MD5Util.getMD5;

/**
 * #Title: Md5Test
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-15:23
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class Md5Test {
    private static Logger logger = LogManager.getLogger(Md5Test.class);

    @Test
    public void testmd5() throws Exception{
        logger.info("1111");
        String pwd = MD5Encryption.getEncryption("buquhuisi4835");
        logger.info(pwd);
    }

    //    public static void main(String[] args) throws UnsupportedEncodingException {
//        String password = MD5Encryption.getEncryption("hello");
//        System.out.println(password);
//    }



//    public static void main(String[] args) throws UnsupportedEncodingException {
//
//////          大写MD5加密
////        String md5 = MD5("password21211212");
////        logger.info(md5);
//////          小写MD5加密
////        String md52 = getMD5("password");
////        logger.info(md52);
//
//        String md_salt1 = MD5Encryption.getEncryption("123456");
//        logger.info(md_salt1);
//
//        String md_salt2 = MD5Encryption.md5_salt("123456");
//        logger.info(md_salt2);
////        String md_salt4 = MD5Encryption.md5_salt("888888");
////        logger.info(md_salt4);
//
//        String a = "577f8783912b24278d160a4c012b60d3a133d20f31918a06";
//        boolean md_salt_back =
//                MD5Encryption.verify("123456", a);
//        logger.info(md_salt_back);
//    }


    // 测试主函数
    public static void main(String args[]) throws UnsupportedEncodingException {
        // 原文
        String plaintext = "123";
        //  plaintext = "123456";202cb962ac597F5b964b7F152d234b70
        logger.info("原始：" + plaintext);
        logger.info("普通MD5后：" + MD5Encryption.getEncryption(plaintext));
        logger.info("随机盐：" + MD5Encryption.saltInDB());

        // 获取加盐后的MD5值
        String ciphertext = MD5Encryption.md5_salt(plaintext);
        logger.info("加盐后MD5：" + ciphertext);
        logger.info("是否是同一字符串:" + MD5Encryption.verify(plaintext, ciphertext));
        /**
         * 其中某次plaintext中字符串的MD5值
         */
        String[] tempSalt = { "27d94bb5964ad3065dc1b519c21488b4bf6251f30116f712",
                              "a12395831368261156e4c60c679d6cc16573c2cb2eb0cf25",
                              "e9987a215f2ae4563d73cb1c025c83d8da05767167c0cd34" };

        for (String temp : tempSalt) {
            logger.info("是否是同一字符串:" + MD5Encryption.verify(plaintext, temp));
        }
    }



    @Test
    public void testmd5_2() throws UnsupportedEncodingException {
        logger.info("测试MD5");

        String pwd1 = MD5Encryption.getEncryption("123123");

        String pwd2 = MD5Utils.encryptPwd("123123", "0x3y95dt");

        logger.info("未加盐:" + pwd1);
        logger.info("加盐:" + pwd2);
    }
}

