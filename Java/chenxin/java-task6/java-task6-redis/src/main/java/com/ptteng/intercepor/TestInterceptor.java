package com.ptteng.intercepor;

import com.ptteng.dao.UserDao;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import com.ptteng.util.DESAlgorithm;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean result = false;
        //从请求中获取全部cookie得到一个数组
        Cookie[] cookies = request.getCookies();
        String message = "";
        RequestDispatcher requestDispatcher;
        //对于下面的if-else重构
        for (int i=0;i <= (cookies.length -1);i++){
            if(cookies != null && "test".equals(cookies[i].getName()) && 0 ==(cookies[i].getValue().getBytes().length%8) ){
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
        }

        //判断是否为空
//        if(cookies == null){
//            result = false;
//        }else {
//            //非空则遍历数组
//            for (Cookie cookie1 : cookies){
//
//                //通过cookie的名字和cookie值的长度来判断。因为解密时需要传入的值为8的倍数。
//                if(cookie1.getName().equals("test") && cookie1.getValue().getBytes().length%8 ==0) {
//                    //注册时加密的密钥
//                    String key = "chenxin@#*";
//                    DESAlgorithm des = new DESAlgorithm();
//
//                    //解密cookie中的值，以便获取id.
//                    String cookieValue = des.decrypt(cookie1.getValue(), key);
//                    //通过org.apache.commone.lang.StringUtiles提供的方法截取字符串id和时间戳。
//                    String idFromCookie = StringUtils.substringBefore(cookieValue,".");
//                    String createdAtFromCookie = StringUtils.substringAfter(cookieValue, ".");
//                    System.out.println("cookie中的id："+ idFromCookie +"\n" + "cookie中的时间戳："+createdAtFromCookie);
//                    User user = userService.getUserById(Long.valueOf(idFromCookie));
//                    if (user.getCreatedAt() == Long.parseLong(createdAtFromCookie)){
//                        result = true;
//                    }else {
//                        result = false;
//                    }
//
//                }
//            }
//        }

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
