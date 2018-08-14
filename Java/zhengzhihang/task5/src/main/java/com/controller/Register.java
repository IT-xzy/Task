package com.controller;
import com.pojo.Trainees;
import com.service.ServiceIF;
import com.tools.MD5Util;
import com.tools.Tocken;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
public class Register {
    //该控制器日志
    private static Logger logger=Logger.getLogger(Register.class);
    //业务层接口
    @Resource
    private ServiceIF serviceIF;


    //登录页面
    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String fhome(){
        return  "fhome";}

    //登录跳转控制器
    @RequestMapping(value = "/pass" , method = RequestMethod.POST)
    public String pass
            (@RequestParam (value="name" ,required = false) String account ,
             @RequestParam (value = "password", required = false) String password,
             Model model,HttpServletRequest request,HttpServletResponse response)

    {
        //查询是否有改账号，有的话，获得它的pojo
        Trainees traineesFine=serviceIF.checkPwd(account);
        if(traineesFine==null){
            model.addAttribute("a","没有这个账号，请重新登录");
            return "fError";
        }else {
//            Trainees trainees=new Trainees();
            traineesFine.setPassword(MD5Util.MD5(password+traineesFine.getSalt()));
            traineesFine.setAccount(account);
            int i=serviceIF.enterPage(traineesFine);
            String cookieName = "name";
            switch (i){
                case 0:
                    Cookie cookie=new Cookie("name",Tocken.tocken(traineesFine.getId()));

                    cookie.setMaxAge(308);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return "fpass";
                case 1:
                    model.addAttribute("a","密码错误，请重新登录");
                    return "fError";

                default:
                    model.addAttribute("a","出现异常情况，请联系管理员");
                    return "fError";
            }
        }

    }



    //注册控制器主页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "fregister";
    }

    //注册提交页面
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addUser(Model model,
                          @RequestParam(value = "account") String account,
                          @RequestParam(value = "password", required = false) String password
                          )
    {
        Trainees trainees=new Trainees();
//        String salt= UUID.randomUUID().toString();
//        String salt= UUID.randomUUID()+"";   //选一种就行
        String salt= String.valueOf(UUID.randomUUID());
        trainees.setSalt(salt);
        trainees.setAccount(account);
        trainees.setPassword(MD5Util.MD5(password+salt));
        System.out.println(trainees);
        int i = serviceIF.loginTrainees(trainees);
        //调用注册接口，得到返回值； 0 ——注册成功，返回登录主页面； 1 ——注册失败，返回错误页面； 其它返回错误页面
        switch (i){
            case 0:
                return "fhome";
            case 1:
                model.addAttribute("a","该账户名已被注册");
                return "fError";
            default:
                model.addAttribute("a","注册异常，请联系管理员");
                return "fError";
        }
    }
}
