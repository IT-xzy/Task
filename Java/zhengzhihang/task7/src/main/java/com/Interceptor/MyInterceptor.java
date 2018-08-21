package com.Interceptor;

import com.pojo.Trainees;
import com.service.ServiceIF;
import com.tools.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    ServiceIF serviceIF;
    @Override
    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        Cookie[] cookies = httpServletRequest.getCookies();

        if(cookies!=null){
         //比对cookie
         for (int i=0;i<cookies.length; i++){
             Cookie cookie=cookies[i];
             if ("name".equals(cookie.getName())){
//                 System.out.println("得到cookie名字"+cookie.getName());
//                 System.out.println("得到cookie有效时间"+cookie.getMaxAge());
                 //得到cookie的值
                 String cookieValue= cookie.getValue();
                 //对cookie的值进行解密
                 String idAndTime= DESUtil.decryptBasedDes(cookieValue);
                 //通过分割字符串获得id和时间
                 String[] strings=idAndTime.split("-");
                 //通过id查询是否有这个账号，有账号登录，检查cookie。
                 int id =Integer.valueOf(strings[1]);
//                 System.out.println("该账号的ID是："+id);
                 //通过时间戳判断时间是否失效，失效返回登录页面
                 long lastTime=Long.valueOf(strings[0]);
//                 System.out.println("该账号上次登录的时间是："+lastTime);
                 //查询是否有这个id的账号
                 String account=serviceIF.findAccountById(id);
                 if (account==null){
                     //没有这个账号，返回主界面
                     httpServletResponse.sendRedirect("/h1");
                     return false;
                 }else {
                     //有这个账号，查看cookie有效期
                     Long currentTime=System.currentTimeMillis();
//                     long expireTime= currentTime+lastTime;
                     long expireTime=currentTime+100;
                     if(currentTime>expireTime){
                         //cookie过期，重新登录
                         httpServletResponse.sendRedirect("/h1");
                         return false;
                     }else {
                         //cookie未过期，放行，同时设置session
                         HttpSession session= httpServletRequest.getSession();
                         session.setAttribute("traineesId",id);
//                         System.out.println(session.getAttribute("traineesId"));
//                         System.out.println("拦截器： 已拦截，放行，登录成功");


                         return true;
                     }
                 }
             }
         }

     }else {
            System.out.println("没有cookies");
         httpServletResponse.setHeader("Location", "/h1");
         httpServletResponse.setStatus(302);
         return  false;
     }
        httpServletResponse.sendRedirect("/h1");
        return false;
    }

    @Override
    // 在业务处理器处理请求完成之后，生成视图之前执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override

    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
