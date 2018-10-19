package jnshu.interceptor;
import jnshu.aspect.DBLogHandler;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.impl.AccountServiceImpl;
import jnshu.util.DES;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountServiceImpl accountService;

    Logger logger = Logger.getLogger(TokenInterceptor.class);

    static boolean flag=false;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            System.out.println("pre");
            Cookie[] cookie1 = request.getCookies();
            System.out.println("cookies length:" + cookie1.length);
            for (Cookie cookie2 : cookie1) {
                System.out.println("preCookie:"+cookie2);
                if (cookie2.getName().equals("token")){
                    String deString = DES.desDecodeCBC("qwerasdf",cookie2.getValue());
                    System.out.println("token解密后:"+deString);
                    long legalTime = 3600*24*3;
                    String[]cookieTimeStamp=deString.split("/",0);
                    long nowTimeStamp = System.currentTimeMillis()/1000;
                    long finalTime=nowTimeStamp-(Long.valueOf(cookieTimeStamp[2]));
                  if(finalTime<legalTime){
                      flag=true;
                  }
                  else
                      flag=false;
                }
                else
                    flag=false;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post");
        System.out.println("原modelView:"+modelAndView.toString());
        if (flag==true) {
            modelAndView.setViewName("listStudent");
        }else {
            modelAndView.setViewName("redirect:/");

        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        RegisterAccount registerAccount =accountService.checkLogin(new LoginAccount(cookie2.getValue(),null));
//                if (registerAccount!=null)
        System.out.println("after");


    }
}
