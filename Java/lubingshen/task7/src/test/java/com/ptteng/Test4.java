package com.ptteng;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.ptteng.dao.UserDAO;
import com.ptteng.manager.Redis;
import com.ptteng.pojo.model.User;
import com.ptteng.utils.SMSUtil;
import com.ptteng.pojo.model.Graduate;
import com.ptteng.dao.GraduateDAO;
import com.ptteng.service.HomeService;
import com.ptteng.utils.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test4 {
    @Autowired
    private Redis redis;
    @Autowired
    private HomeService graduateService;
    @Autowired
    private GraduateDAO graduateDAO;
    @Autowired
    private UserDAO userDAO;



    @Test
    public void currenTime(){
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testLazyLoading() throws Exception {
        Graduate graduate = graduateDAO.findById(4L);
        System.out.println(graduate);
        //System.out.println(graduate.getStudent());
        System.out.println(graduate.getClass().getSimpleName());
        Field[] fields = graduate.getClass().getDeclaredFields();
        for(Field field : fields)
            System.out.println(field);
    }


    @Test
    public void cellphone() throws Exception{

        //发短信
        SendSmsResponse response = SMSUtil.sendSms("123456","xxxxxxxxxx");
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
    }

    @Test
    public void randomTest(){
        System.out.println(RandomUtil.getRandom(6));
        System.out.println(RandomUtil.getRandom(5));
        System.out.println(RandomUtil.getRandom(6));
    }

    @Test
    public void StudentTest() throws Exception {
        redis.put("abc","1","1",100L);
        System.out.println(redis.get("abc","1"));
        redis.put("abc","2","2",100L);
        System.out.println(redis.get("abc","1"));
        System.out.println(redis.get("abc","2"));
    }

}
