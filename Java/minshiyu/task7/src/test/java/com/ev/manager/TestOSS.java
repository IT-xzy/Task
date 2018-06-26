package com.ev.manager;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * RedisCache Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/19/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOSS {


    /*
     * Constructs a client instance with your account for accessing OSS
     */
    OSSClient ossClient = new OSSClient("http://oss-cn-hangzhou.aliyuncs.com", "LTAIhflo77A6ZuOo", "CIKWZaLiu25tOStdPxVlL8Id8yDUbM");

    @Test
    public void test() throws Exception{
        File file = new File("C:\\Users\\ElmVector\\Pictures\\时光守护者.jpg");
        InputStream in = null;
        in = new FileInputStream(file);
        int tempbyte;
        while ((tempbyte = in.read()) != -1) {
            System.out.write(tempbyte);
        }
        in.close();

        /*
         * Upload an object to your bucket
         */
        System.out.println("Uploading a new object to OSS from a file\n");
        ossClient.putObject(new PutObjectRequest("msy-task7", "test_01", file));

    }

    @Test
    public void test2() throws  Exception{

    }
}
