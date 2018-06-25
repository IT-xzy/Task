package com.longhang.userHandler;

import com.longhang.stuService.UserService;
import com.longhang.util.GetBean;
import com.longhang.util.Md5Utils;
import com.longhang.util.Token;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserLonginHandler extends UserHandler {
    UserService userSe=new GetBean().getUserSe();
    @Resource
    private JedisPool jedispool;
    private static Logger logger=Logger.getLogger("UserLonginHandler.class");
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        Jedis jedis = jedispool.getResource();
        //获取form表单中name，password，code，email
        String s =  request.getParameter("name");
        String password=request.getParameter("password");
        String code=request.getParameter("verification1");
        String email=request.getParameter("email");
        //email的别名用于获取code
        String thisEmail=email+"1";
        System.out.println(s);
        System.out.println(password);
        //Token 和 md5
        Token t=new Token();
        Md5Utils md=new Md5Utils();
        String name1=t.makeToken(s);
        String password1=md.MD5(t.makeToken(password));
        logger.info("登录密码:::"+password1);
        //没有该用户
        if(!userSe.getGetAllName().contains(name1))
        {request.getRequestDispatcher("/WEB-INF/pages/noUser.jsp").forward(request, response);
            return false;}
        //密码错误
        if(!(userSe.getSelectByName(name1).equals(password1)))
        { request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
            return false;}
            //判断form表单中的code是否与验证接口中的code相等
        logger.info("code:::"+jedis.get(thisEmail));
        logger.info("code::::"+code);
        if (code != null && code.equals(jedis.get(thisEmail))) {
            //移除每次获取的code使其失效
            jedis.setex(thisEmail,1,code);
            logger.info(jedis.get(thisEmail));
            logger.info("code:::::::::"+jedis.get(thisEmail));
            return true;
        } else {
            logger.info("code:::"+jedis.get(thisEmail));
            return false;
        }
        }

}
