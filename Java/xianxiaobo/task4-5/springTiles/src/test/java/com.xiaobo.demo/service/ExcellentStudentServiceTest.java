package com.xiaobo.demo.service;
import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.pojo.ExcellentStudent;
import com.xiaobo.demo.pojo.Profession;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.util.DesUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml" })
public class ExcellentStudentServiceTest {
    private static Logger log=Logger.getLogger(ExcellentStudentService.class);
    @Autowired
    private ExcellentStudentService excellentStudentService;
    @Autowired
    private ProfessionService professionService;
    @Autowired
    private User user;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private DesUtil desUtil;
    @Test
    public void testGet(){
        ExcellentStudent excellentStudent = excellentStudentService.get(1);
        System.out.println(excellentStudent.toString());
        log.info(excellentStudent.toString());
    }
    @Test
    public void testService(){
        Profession profession = new Profession();
        profession.setDevelopmentDirection(Profession.OPTION_DEVELOPMENT_DIRECTION_FRONTEND);
        List<Profession> professionList1 = professionService.selectByDevelopmentDirection(profession);
        for(Profession professionItem:professionList1){
            System.out.println(professionItem.toString());
        }
    }
    @Test
    public void testAddUserService(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test2");
        Boolean result = userService.insert(user);
        System.out.println(result);
        log.warn(result);
    }
    @Test
    public void testCommonService(){
        Boolean result = commonService.isDataExist("user","password","test2");
        System.out.println(result);
        log.warn(result);
    }
    @Test
    public void testDesUtil(){
        String userId = "20";
        String userName = "30";
        try{
            String encryptedUserId = desUtil.encrypt(userId);
            System.out.println(encryptedUserId);
            String decreptedUserId = desUtil.decrypt(encryptedUserId);
            System.out.println(decreptedUserId);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
