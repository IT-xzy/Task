package com.xiaobo.demo.service;
import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.pojo.ExcellentStudent;
import com.xiaobo.demo.pojo.PhoneCode;
import com.xiaobo.demo.pojo.Profession;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.util.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.ArrayList;
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
    private CommonServiceImpl commonService;
    @Autowired
    private DesUtil desUtil;
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private ImageUtil imageUtil;
    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private CaptchaUtil captchaUtil;
    @Autowired
    private PhoneCode phoneCode;
    @Autowired
    private PhoneCodeService phoneCodeService;
    @Autowired
    private EmailCodeService emailCodeService;
    @Autowired
    private ValidateUtil validateUtil;
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
//        CommonService commonService=new CommonServiceImpl();
        Integer result = commonService.test();
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
    @Test
    public void testInsertBatchProfession(){
        long startTime = System.currentTimeMillis();
        List<Profession> professionList = new ArrayList<Profession>();
        for(int i=0;i<1000;i++){
            Profession profession = new Profession();
            profession.setImg(".../img/css8/user-head2.jpg");
            profession.setDevelopmentDirection(1);
            profession.setProfessionName(1);
            profession.setDescription("WEB工程师的必备技能，");
            profession.setLimitCondition("1");
            profession.setDifficulty("1");
            profession.setCycle("2年");
            profession.setPeriodOne("0-1年");
            profession.setPeriodTwo("1-3年");
            profession.setPeriodThree("3-5年");
            profession.setSalaryOne("5-10k");
            profession.setSalaryTwo("10-20k");
            profession.setSalaryThree("20k-50k");
            profession.setCareerProspects("25744");
            profession.setCreateAt(1541583837702L);
            profession.setUpdateAt(1541583837702L);
            professionList.add(profession);
        }
        long midTime = System.currentTimeMillis();
        System.out.println(midTime - startTime);
        professionService.insertBatch(professionList);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    @Test
    public void testEmailUtil(){
        String to ="1015207497@qq.com";
        String content = "HELLO　WORLD";
        try{
            emailUtil.sendMail(to,content);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testImageUtil(){
        String name ="test2.jpg";
        File file = new File("C:\\Users\\xianxiaobo\\Pictures\\musci\\test2.jpg");
        System.out.println(file.exists());
        imageUtil.uploadImage(name,file);
    }
    @Test
    public void testImageUtilDownload(){
        String name = "test2.jpg";
        File file = new File("C:\\Users\\xianxiaobo\\Pictures\\musci\\test3.jpg");
        imageUtil.downloadImage(name);
    }
    @Test
    public void testMessageUtil(){
        String phone = "18381673691";
        String code = "123456";
        messageUtil.sendMessage(phone,code);
    }
    @Test
    public void testCaptchaUtil(){
        String token = "00-4f73da8ffcb642cb85c556ebc4e0ccb30100bfedcjhcgfbsgplronhmkwaxejobbn9v9qhg-53155483b57058a75e4e0a6b3df7857f";
        try{
           Boolean result = captchaUtil.isTokenValid(token);
           System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testPhoneCodeService(){
        PhoneCode phoneCode = new PhoneCode();
        phoneCode.setCode("123456");
        phoneCode.setPhone("18581673692");
        phoneCode.setCreateAt(System.currentTimeMillis());
        phoneCode.setUpdateAt(System.currentTimeMillis());
        phoneCode.setNumber(10);
        Integer result = phoneCodeService.insert(phoneCode);
        System.out.println(result);
        System.out.println(phoneCode.getId());
    }
    @Test
    public void testPhoneCodeServiceSelectByPhone(){
        String phone="18581673692";
        PhoneCode phoneCode = phoneCodeService.selectByPhone(phone);
        if(phoneCode!=null){
            // 判断上一条发送时间,如果已经小于一分钟，不发送短信
            if(System.currentTimeMillis()-phoneCode.getUpdateAt()<60000){
                System.out.println("一分钟之后才能发送");
            }
            // 判断今日发送条数
            if(phoneCode.getNumber()>9){
                System.out.println("此号码发送条数已到达上限");
            }
            // 发送验证码，成功之后修改数据库
            System.out.println("数据库修改数据");
        }else{
            // 发送验证码，成功之后插入数据
            System.out.println("数据库新增数据");
        }
    }
    @Test
    public void testRandom(){
        for(int i=0;i<100;i++){
            Integer random = (int)((Math.random()*9+1)*100000);
            String number = String.valueOf(random);
            System.out.println(number);
        }
    }
    @Test
    public void testCommonServiceIsToday(){
        System.out.println(System.currentTimeMillis());
        Long timestamp = 1543334400000L;
        System.out.println(commonService.isToday(timestamp));
    }
    @Test
    public void testEmailCodeServiceEncrypt(){
        Integer userId = 8;
        String link = emailCodeService.encryptActiveUrl(userId);
        System.out.println(link);

    }
    @Test
    public void testEmailCodeServiceDecrypt(){
        String param = "DQPZIYUQIH1/+RCEYT3NkY6x/PMkURnj";
        Boolean result = emailCodeService.decryptActiveUrl(param);
        System.out.println(result);

    }
    @Test
    public void testValidateUtilCheckLoginParam(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("username","1015207497@qq.com");
        jsonObject.put("password","xianxiaobo");
        String result = validateUtil.checkLoginParam(jsonObject);
        System.out.println(result);
    }
}
