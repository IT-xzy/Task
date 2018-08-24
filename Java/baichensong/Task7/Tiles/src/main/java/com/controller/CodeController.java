package com.controller;

import com.AOP.Test;
import com.DES.CookieUtil;
import com.DES.TokenUtil;
import com.model.Login;
import com.model.Student;
import com.request.SDKTestSendTemplateSMS;
import com.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Random;

@Controller
public class CodeController {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-rmiBean.xml");
    private SDKTestSendTemplateSMS sendCode = (SDKTestSendTemplateSMS) applicationContext.getBean("sendCode");

    @Autowired
    public StudentService service;

    private static Log logger = LogFactory.getLog(TestController.class);


    // 报名系统页面
    @RequestMapping("/u/dojoin")
    public String dojoin(){
        return "register";
    }



    // 验证 短信验证码 并写入数据库。
    @RequestMapping(value = "/u/dojoins",method = RequestMethod.POST)

    public String addStudent(HttpServletRequest request, Student student, Model model){
        int id = Integer.parseInt(request.getParameter("studentID"));
        logger.info("图片的连接获取"+ request.getParameter("img"));

        logger.info("学员号" + id);
        Login login = service.findstudentID(id);

        student.setImg(request.getParameter("img"));
        try{
            student.setUsername(login.getUsername());
        }catch (Exception e){
            logger.info("用户名设置失败"+ e);
        }
        student.setPhone(Long.valueOf(request.getParameter("phone")));
        student.setOutstanding(0);
        student.setZhiye(request.getParameter("profession"));
        Long a = new Date().getTime()/1000;
        student.setStartTime(a);
        String zhiye = "qaui";
        if(zhiye.contains(request.getParameter("profession"))){
            student.setEndTime(Test.elseDate());

        }else {
            student.setEndTime(Test.Date());
        }

        //开始验证 验证码
        Cookie cookie = CookieUtil.getCookieByName(request, "phone");
        if(cookie != null){
            //获取cookie的 value
            String token = cookie.getValue();
            logger.info("短信的 token是 + " + token);
            // jwt token 解密
            String[] st = TokenUtil.codetool(token);
            //前端输入的 手机号 和短信验证码
            String code = request.getParameter("code");
            String phone = request.getParameter("phone");
            //token里的时间 转为Long 类型 方便比较
            Long codeTime = Long.valueOf(st[2]);
            Long nowTime = new Date().getTime();
            // 判断 前端输入的 验证码 ，手机号 ，验证时间 是否过期
            if(st[1].equals(code) && st[0].equals(phone) && codeTime>=nowTime){
                service.addStudent(student);
                model.addAttribute("student",student);
                logger.info("验证成功");
                return "Test1";
            }else{
                logger.info("验证失败");
                return "register";
            }

        }else {
            logger.info("短信cookie 为空");
            return "register";
        }
    }


    // 发送验证码
    @RequestMapping(value = "send",method = RequestMethod.POST)
    @ResponseBody
    public String sendSMS(HttpServletRequest request, HttpServletResponse response){
        //随机生成 6位验证码
        String codeNum = "";
        int [] numbers = {0,1,2,3,4,5,6,7,8,9};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int next = random.nextInt(10000);//目的是产生足够随机的数，避免产生的数字重复率高的问题
//              System.out.println(next);
            codeNum += numbers[next % 10];
        }
        logger.info("生成的验证码是"+codeNum);

        // 手机号 模板  和 验证码 失效时间 传入接口 ，成功发送就写入cookie ，失败则处理异常
        try {
            String[] strings = new String[]{codeNum, "10"};
            logger.info("前台传来的手机号码是"+request.getParameter("phoneNumber"));

            sendCode.SDKTemplate(request.getParameter("phoneNumber"), "1", strings);

            //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 时间类型Long 加上 10分钟     为短信验证码的最大过期时间
            String time = String.valueOf(new Date().getTime()+600000);
            String token = TokenUtil.codeToken(request.getParameter("phoneNumber"),String.valueOf(codeNum),time);
            CookieUtil.addCookie(response,"phone",token,10*60);
            logger.info("手机验证码的cookie生成成功");
        }catch (Exception e){
            System.out.println("发送失败"+ e);
        }

        return "短信发送成功";
    }
}
