package com.jnshu.czm.interceptor;

import com.jnshu.czm.util.DesUtil;
import com.jnshu.czm.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UsersService usersService;

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        String url=request.getRequestURI();

        logger.info("\n URL的值为："+url);

        //判断url是不是公开地址（实际使用时将公开地址配置到配置文件中）
        logger.info("这是什么"+url.indexOf("login"));
        //这里公开地址是登录提交的地址
        if(url.indexOf("login")>=0){

            System.out.println("..................................................");
            logger.info("这是什么"+url.indexOf("login"));

            //如果进行登录提交，放行
            return true;
        }

        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies){

            logger.info("\n"+"打印cookie_name={},cookie_value={}",c.getName(),c.getValue());
            System.out.println("拦截器有信息。。。。。。。。。。。。。。。。。。。。。");

            if (c.getName().equals("token")){


                //解密
                String decrypted= DesUtil.decrypt(c.getValue());
                //按逗号隔开
                String[] str=decrypted.split(",");

                //Long.ParseLong(String)方法，将 string 参数解析为有符号十进制 long，字符串中的字符必须都是十进制数字。
                long time=System.currentTimeMillis() - Long.parseLong(str[1]);
                logger.info("\n"+"time-------------{}",time);

                if (usersService.findUserByName(str[0]) !=null && time<100000){

                    return true;
                }
            }
        }

        System.out.println("操作有误");
        //执行到这里表示用户需要认证，跳转登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/logIn.jsp").forward(request,response);
        return false;
    }

    // 在业务处理器处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)

            throws Exception{

    }

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)

            throws Exception{

    }
}
