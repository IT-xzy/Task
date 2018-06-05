package com.longhang.controller;

import com.aliyuncs.exceptions.ClientException;
import com.longhang.model.User;
import com.longhang.stuService.UserService;
import com.longhang.util.AliyunEmail;
import com.longhang.util.SmsDemo;
import com.longhang.util.Token;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LhController {
    @Resource
    private UserService userSe;
    @Resource
    private AliyunEmail aliyunEmail;
    @Resource
    private SmsDemo smsDemo;
    @Resource
    private   JedisPool jedispool;
    org.slf4j.Logger logger = LoggerFactory.getLogger(StuController.class);


    @RequestMapping(value = "/toregist")
    public String go(){
        return "regist";
    }
    @RequestMapping(value = "")
    public String g(){
        return "login";
    }
    /**
     * 登录 生成cookie
     * modelAndView方法是将控制器中的值传给拦截器
     *
     */
//    @RequestMapping(value = "/logins",method = RequestMethod.POST)
//        public ModelAndView get(HttpServletRequest request){
//        String s1=request.getParameter("name");
//        Long thisTime=System.currentTimeMillis();
//        userSe.getUpdataByName(s1,thisTime);//更改登录时间
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("time",thisTime);
//        modelAndView.addObject("name",s1);
//          return modelAndView;
//          }
    @RequestMapping(value = "/logins",method = RequestMethod.POST)
    public String get(HttpServletRequest request, HttpServletResponse response){
        //获取用户名
        String thisName=request.getParameter("name");
        Long thisTime=System.currentTimeMillis();
        userSe.getUpdataByName(thisName,thisTime);//更改登录时间
        Token tk=new Token();
        //加密登录时间，用户名
        String psw=tk.makeToken(String.valueOf(thisTime));
        String name=tk.makeToken(thisName);
        Cookie userCookie=new Cookie("userName",name);//添加用户名
        userCookie.setMaxAge(7*24*60*60);
        userCookie.setPath("/");
        response.addCookie(userCookie);
        //cookie添加登录时间
        Cookie c = new Cookie("key",psw);//添加登录时间
        c.setMaxAge(7*24*60*60);
        response.addCookie(c);
        return "message";
    }


    /**
     * 登录邮箱验证  redis方法  判读验证的次数和验证时效以及验证码时效
     */

    @ResponseBody
    @RequestMapping(value="/verifyEmail",method = RequestMethod.GET)
    public String verifyEmail(HttpServletRequest request) throws ClientException {
        //生成6位数的随机数
        int code= 100000+(int)(Math.random()*((999999-100000)+1));
        //获取缓存jedis
        Jedis jedis = jedispool.getResource();
        //回去form表单中的email
        String email=request.getParameter("emailNum");
        //email的别名用于获取code
        String thisEmail=email+"1";
       //判断缓存是否存在该email
        if(!jedis.exists(email)){
            jedis.setex(email,5*60*60,"1");
            jedis.setex(thisEmail, 5 * 60, String.valueOf(code));
        }
        //判断存在的email的次数
        else if(Integer.valueOf(jedis.get(email))<6){
            jedis.setex(email,5*60*60,String.valueOf(Integer.valueOf(jedis.get(email))+1));
            jedis.setex(thisEmail, 5 * 60, String.valueOf(code));
        }
        logger.info(jedis.get(thisEmail));
        logger.info("count:::"+jedis.get(email));
        //阿里邮箱发送
//        if (jedis.get(thisEmail)!=null) {
//            aliyunEmail.sample("lengsheng_1@163.com", jedis.get(thisEmail));
//        } else {
//            return "验证次数过多";}
        return "redirect:/login";

    }

    /**
     * 注册短信验证  session方法  判读验证的次数和验证时效以及验证码时效
     */
    @ResponseBody
    @RequestMapping(value="/verifyPhone",method = RequestMethod.GET)
    public String verifyPhone(HttpServletRequest request) throws ClientException {
        //生成6位数的随机数
        int code = 100000 + (int)(Math.random() * ((999999 - 100000) + 1));
        System.out.println(String.valueOf(code));
           //获取session
            HttpSession session= request.getSession();
            //获取表单中的phone
            String ph=request.getParameter("phoneNum");
           System.out.println("电话:::"+ph);
            //设置这段验证码的时间
           Long time =System.currentTimeMillis();
          session.setAttribute(ph+"outtime",time);
//           System.out.println("session:::::"+session.getAttribute(ph+"code").toString());
            //判断是否为新电话，是的话session设置次数和电话
           if (session.getAttribute(ph+"phone")==null){
               //设置电话的验证码
               session.setAttribute(ph+"code",code);
               session.setAttribute(ph+"count",5);
               session.setAttribute(ph+"phone",ph);
            System.out.println("新电话:::::"+session.getAttribute(ph+"phone").toString());
            } else if (Integer.parseInt(String.valueOf(session.getAttribute(ph+"count")))>0) {
                //不是新电话取出它的count--
                int s=Integer.parseInt(String.valueOf(session.getAttribute(ph+"count")));
                s--;
                System.out.println("count:::"+s);
                //把新的count设置进去
                session.setAttribute(ph+"count",s);
               //设置电话的验证码
               session.setAttribute(ph+"code",code);
            }
            //session设置时间为5小时,也就是5小时内只能验证5次
            session.setMaxInactiveInterval(5*60*60);
//           //aliyun短信验证,确定验证存在才让阿里发短信
//        if(session.getAttribute(ph+"code")!=null) {
//            smsDemo.sendSms(ph, String.valueOf(code));
//        } else {
//            return "验证次数过多";
//        }
            return "redirect:/toregist";
    }
   // }
    /**
 * 注册
 */
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public String regist(String name,String password){
        Long create_at=System.currentTimeMillis();
        Long logintime=create_at;
        userSe.getInsert(name,password,create_at,logintime);
        return "login";
    }
    /**
     * 登出
     */

    @RequestMapping(value="/u/users")
    public String out(HttpServletRequest request,HttpServletResponse response) {
        Long time = System.currentTimeMillis();
        logger.info("登出时间："+time);
      // String userName = null;
       //遍历cookie
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
               // if("userName".equals(c.getName()))
                    c.setMaxAge(0);
                    c.setPath("/");//设置时效的路径一定要一样
                response.addCookie(c);
                logger.info("用户别名:::"+c.getName()+"   用户名：：："+c.getValue());
//                    userName = c.getValue();
//                userSe.getUpdataByName1(userName, time);
                }
        }

        return "out";
    }
    /**
     * 获取需要修改的注册用户
     */

    @RequestMapping(value="/u/user",method = RequestMethod.GET)
    public String getEditUser(HttpServletRequest request,Model model){
        String userName = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if ("userName".equals(c.getName()))
                    userName = c.getValue();
                }
        }
        String s=userName;
        User u=userSe.getSelects(s);
        u.setName(new Token().SolveToken(u.getName()));
        System.out.println("用户信息::::"+u.toString());
        model.addAttribute("user",u);
        return "editUser";
    }
/**
 * 修改的注册用户
 */
     //@MyAnno
     //@ResponseBody()
    @RequestMapping(value="/u/user",method = RequestMethod.PUT)
         public String editUser(String name,String password,Long id) {
         userSe.getUpdate(name,password,id);
         System.out.println("123321");
         return "redirect:/u/use";
     }
    /**
     * 修改的注册用户,重定向在拦截器中由于cookie更改直接在拦截器中跳转再登录
     */
    //@ResponseBody()
    @RequestMapping(value="/u/use")
    public String wellcom(){
         return "t11";
    }
    @RequestMapping(value="/use")
    public String wellcom1(){
        return "t10";
    }

}
