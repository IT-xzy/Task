package com.interceptor;


import com.service.ProduceToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    //不拦截的页面
    private static final String[] IGNORE_URI = {"/login"};
    Logger logger = (Logger) LoggerFactory.getLogger(AuthorizationInterceptor.class);
    /**
     * preHandle拦截使用，在controller执行之前
     * 返回值为true才会向下执行，false的话请求就结束
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.info("进入拦截器");
        boolean flag = false;  //用于存储判断登陆的结果
        //对请求路径判断
        String servletPath = httpServletRequest.getServletPath();
        //判断请求路径是否需要拦截
        for(String s:IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;      //如果是不拦截的网站，flag为true，跳出循环，转向下一个方法
                break;
            }
        }
        //被拦截的请求
        if(!flag){
            boolean isCookie=false;
            //获取cookie
            Cookie[] cookies = httpServletRequest.getCookies();
            String id =null;
            String logtime = null;
            String token = null;

            //获取需要字段的值
            for(Cookie c:cookies) {
                //得到id字段的值
                if(c.getName().equals("id"))
                    id = c.getValue();
                //得到logtime字段的值
                if(c.getName().equals("logtime"))
                    logtime = c.getValue();
                //得到token字段的值
                if(c.getName().equals("token")){
                    token = c.getValue();
                }
            }
            //使用DES加密id和logtime字段，然后和token字段对比。
            //生成token
            String newtoken = ProduceToken.getToken(id,logtime);
            //如果相同，说明cookie有效
            if(newtoken.equals(token)){
                logger.info("token验证通过");
                isCookie =true;
            }
            //Cookie信息确认错误
            if(!isCookie){
                //用户没有登陆过
                httpServletRequest.setAttribute("message","请先登陆后再访问网站");
                httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
            }else{
                //用户登陆过，验证通过
                httpServletRequest.setAttribute("message","已登陆");
                flag=true;
            }
        }
        return flag;
    }
    /**
     * Controller调用之后执行，可对ModelAndView操作
     * 当Interceptor的preHandle返回为true时执行
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //请求之后执行，用于清理资源
    //在Interceptor的preHandle返回为true时执行
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("拦截器end");
    }
}
