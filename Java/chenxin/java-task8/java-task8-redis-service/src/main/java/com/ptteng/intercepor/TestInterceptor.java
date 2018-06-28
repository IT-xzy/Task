package com.ptteng.intercepor;

import com.ptteng.model.User;
import com.ptteng.service.UserService;
import com.ptteng.util.DESAlgorithm;
import com.ptteng.util.GetCookieFromRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Autowired
    GetCookieFromRequest getCookieFromRequest;  //用于从request中获得cookie
    @Autowired
    DESAlgorithm des;   //用于解密的工具类。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean result = false;
        /**
         * 通过GetCookieFromRequest，拿到符合本网站的cookie
         */
        Cookie cookie = getCookieFromRequest.getCookie(request);    //通过传递request，获得cookie。可能是空值。
        if (cookie != null){        //如果返回值cookie非空，会进行下一步操作。
            //解析cookie中的value，获得用户的id和时间戳。
            String key = "chenxin@#*";  //注册时加密的密钥，此时用来解密。
//            DESAlgorithm des = new DESAlgorithm();

            //具体的解密过程
            String cookieValue = des.decrypt(cookie.getValue(), key);
                //因为value中的id和时间戳是用点符号来连接在一起的，所以需要截取。
            String idFromCookie = StringUtils.substringBefore(cookieValue, ".");    //截取所用的工具类是，org.apache.commone.lang.StringUtiles提供的方法。
            String createdAtFromCookie = StringUtils.substringAfter(cookieValue, ".");
            System.out.println("cookie中的id："+ idFromCookie +"\n" + "cookie中的时间戳："+createdAtFromCookie);
            //判断下解密得到的时间戳，是否正确。
            User user = userService.getUserById(Long.valueOf(idFromCookie));
            if (user.getCreatedAt() == Long.parseLong(createdAtFromCookie)) result = true;

        }
        String message = "";
        RequestDispatcher requestDispatcher;
        /**
         *
        //从请求中获取全部cookie得到一个数组
        Cookie[] cookies = request.getCookies();
        String message = "";
        RequestDispatcher requestDispatcher;
        //对于下面的if-else重构
        for (int i=0;i <= (cookies.length -1);i++){
            if(cookies != null && "test".equals(cookies[i].getName()) && 0 ==(cookies[i].getValue().getBytes().length%8) ){
//            if(cookies != null && "test".equals(cookies[i].getName()) && 0 ==(cookies[i].getValue().getBytes().length%8) ){
                //注册时加密的密钥
                String key = "chenxin@#*";
                DESAlgorithm des = new DESAlgorithm();

                //解密cookie中的值，以便获取id.
                String cookieValue = des.decrypt(cookies[i].getValue(), key);
                //通过org.apache.commone.lang.StringUtiles提供的方法截取字符串id和时间戳。
                String idFromCookie = StringUtils.substringBefore(cookieValue,".");
                String createdAtFromCookie = StringUtils.substringAfter(cookieValue, ".");
                System.out.println("cookie中的id："+ idFromCookie +"\n" + "cookie中的时间戳："+createdAtFromCookie);
                User user = userService.getUserById(Long.valueOf(idFromCookie));
                if (user.getCreatedAt() == Long.parseLong(createdAtFromCookie)) result = true;
            }
        }*/
        //如果运行结果为false，需要用户登录。
        if(!result){
            requestDispatcher = request.getRequestDispatcher("/login/login");
            message = "访问当前页面需要用户登录。";
            request.setAttribute("message", message);
            requestDispatcher.forward(request,response );
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
