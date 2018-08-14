package com.controller;

import com.tools.MD5Tool;
import com.model.Login;
import com.sendcloud.sdk.demo.mail.SendMail;
import org.ApplicationAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Asong
 */
@Controller
public class EmailController {
    /**
     * ----------历史版本
//    @Autowired
//    com.service.StudentService StudentService;

//    ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-client.xml");
//    StudentService service = (StudentService) application.getBean("client");
     */
ApplicationAll applicationAll = new ApplicationAll();

    private SendMail sendMail = (SendMail) applicationAll.application().getBean("sendEmail");
    private Logger log = LoggerFactory.getLogger(EmailController.class);



    @RequestMapping(value = "z/start")
    public String sendemail(){
        return "sendemail";
    }



    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public String load(HttpServletRequest request, Login login) throws Throwable {
            /*
                 注册
                 StudentID(888)---------------------------------简单学号 非自增----------
             */
            String email = request.getParameter("email");
            login.setStudentID(888);
            login.setUsername(request.getParameter("username"));
            String pass = MD5Tool.generate(request.getParameter("pwd"));
            login.setUserpass(pass);
            login.setEmail(email);
            login.setState(0);
            Long lg = System.currentTimeMillis() / 1000;
            login.setLandtime(lg);
            login.setActiCode(MD5Tool.generate(email + lg));
            applicationAll.service().insertdata(login);
            log.info("写入数据库成功");

            StringBuffer sb = new StringBuffer("点击下面链接激活账号，30分钟生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://123.206.41.126:8080/user/action?email=");
            sb.append(email);
            sb.append("&actiCode=");
            sb.append(login.getActiCode());
            sb.append("\">http://123.206.41.126:8080/user/action?email=");
            sb.append(email);
            sb.append("&actiCode=");
            sb.append(login.getActiCode());
            sb.append("</a>");
            log.info(sb.toString());
            sendMail.send_common(email, sb.toString());
            log.info("邮件发送成功");
           return "success";
    }

    @RequestMapping(value = "/user/action")
    public ModelAndView lianjie(@RequestParam("email") String email,@RequestParam("actiCode") String actiCode){
        ModelAndView mv = new ModelAndView();
        Login login = applicationAll.service().findemail(email);
        log.info("查询数据结果"+login);
        if(login != null){
            if(login.getState()==0){
                Long time = System.currentTimeMillis()/1000;
                /*
                    times--------过期时间为 30分钟
                 */
                Long times = login.getLandtime()+1000*60*30;
                if(times>time && login.getActiCode().equals(actiCode) ){
                    log.info("验证成功");
                    login.setState(1);
                    login.setEmail(email);
                    applicationAll.service().updateState(login);
                    log.info("成功激活邮箱------去登陆");
                    mv.setViewName("login");
                    return mv;
                }else {
                    log.info("激活码不正确-----激活失败----清除注册数据----重新注册");
                    applicationAll.service().deleteEmail(email);
                    mv.setViewName("sendemail");
                    return mv;
                }
            }else {log.info("此邮箱已激活---去登陆"); mv.setViewName("login");return mv;}
        }else {log.info("该邮箱未申请注册--------重新注册");mv.setViewName("sendemail");return mv;}

    }

}
