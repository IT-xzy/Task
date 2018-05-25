package controller;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.UserRmiService;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@Controller
public class JnshuController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(JnshuController.class);
    private static UserRmiService userRmiService;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private static int flagA=0 ;
    private static int flagB=0 ;

    @Scheduled(cron = "0 0/3 * * * ?")
    private static void print(){
        flagA=0;
        flagB=0;
        System.out.print("将A、B清0\n");
    }

//   private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//   private static UserRmiService userRmiService = (UserRmiService) context.getBean("loadBalancedService");


   private static UserRmiService load(){
       if (Math.random()<0.5 && flagA==0) {
           try {
               System.out.print("准备调用:");
               userRmiService = (UserRmiService) context.getBean("userRmiServiceA");
               System.out.print("调用成功8080端口"+userRmiService+"\n");
           }
           catch (Exception e ){
               flagA = 1;
               userRmiService = (UserRmiService) context.getBean("userRmiServiceB");
               System.out.print("调用失败尝试调用:"+userRmiService+"\n");
           }
       }
       else  if (flagB==0){
           try {
               System.out.print("准备调用:");
               userRmiService = (UserRmiService) context.getBean("userRmiServiceB");
               System.out.print("调用成功8082端口"+userRmiService+"\n");
           }
           catch (Exception e){
               flagB = 1;
               userRmiService = (UserRmiService) context.getBean("userRmiServiceA");
               System.out.print("调用失败尝试调用:"+userRmiService+"\n");
           }
       }
       else if(flagA==1 && flagB ==1) {
           System.out.print("两个端口都挂了,你在搞毛线\n");
       }
       return userRmiService;
   }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Long id, HttpServletRequest httpServletRequest){
       userRmiService = load();
        User user = userRmiService.selectbyid(id);
        if (user ==null){
            return  "home";
        }
        else {
            httpServletRequest.setAttribute("user",user);
            return "home";
        }
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/phonelogin",method = RequestMethod.GET)
    public String phonelogin() {return "phonelogin";}

    @RequestMapping(value = "/emaillogin",method = RequestMethod.GET)
    public String emaillogin() {return "emaillogin";}

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {return "login";}

    @RequestMapping(value="/phoneregister",method = RequestMethod.GET)
    public String phoneregister() {return "phoneregister";}

    @RequestMapping(value = "/emailregister",method = RequestMethod.GET)
    public String emailregister() {return "emailregister";}

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {return "register";}

    @RequestMapping(value = "/registerselect",method = RequestMethod.GET)
    public String registerselect(){return "registerselect";}

    @RequestMapping(value = "/loginselect",method = RequestMethod.GET)
    public String loginselect(){return "loginselect";}
}
