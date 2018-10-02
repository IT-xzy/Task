package jnshu.interceptor;
import jnshu.aspect.DBLogHandler;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.impl.AccountServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountServiceImpl accountService;

    Logger logger = Logger.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            System.out.println("pre");
            Cookie[] cookie1 = request.getCookies();
            System.out.println("cookies length:" + cookie1.length);
            for (Cookie cookie2 : cookie1) {
                System.out.println("preCookie循环:"+cookie2);
                if (cookie2.getName().equals("token")){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post");
        System.out.println("原modelView:"+modelAndView.toString());
        modelAndView.setViewName("listStudent");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        RegisterAccount registerAccount =accountService.checkLogin(new LoginAccount(cookie2.getValue(),null));
//                if (registerAccount!=null)
        System.out.println("after");
    }
}
