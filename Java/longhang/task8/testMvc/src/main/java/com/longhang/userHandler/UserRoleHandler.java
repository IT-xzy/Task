package com.longhang.userHandler;

import com.longhang.stuService.UserService;
import com.longhang.util.GetBean;
import com.longhang.util.Token;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRoleHandler extends UserHandler {
    UserService userSe=new GetBean().getUserSe();
    private static Logger logger=Logger.getLogger("UserRoleHandler.class");
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            MyAnno myAnno = ((HandlerMethod) handler).getMethodAnnotation(MyAnno.class);
//        }

            logger.info("preHandle...");
            String requestUri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String url = requestUri.substring(contextPath.length());
            logger.info("requestUri:" + requestUri);
            logger.info("contextPath:" + contextPath);
            logger.info("url:" + url);
            String key = null;
            String userName = null;
            Cookie[] cookie = request.getCookies();
            if (cookie != null) {
                for (Cookie c : cookie) {  // 遍历Cookie
                    if ("key".equals(c.getName()))
                        key = c.getValue();

                    if ("userName".equals(c.getName()))
                        userName = c.getValue();
                }
            }
            if (userName != null && key != null) {
                Token tk=new Token();
                logger.info("用户名:::"+userName);
                Long time = userSe.getLoginTimeByName(userName);
                logger.info("登录时间：" + time);
                String stime = tk.makeToken(String.valueOf(userSe.getLoginTimeByName(userName)));
                logger.info("key：" + key);
                Long keytime=Long.valueOf(tk.SolveToken(key));
                logger.info("keytime:"+keytime);
                Long thistime=System.currentTimeMillis();
                Long gettime=thistime-keytime;
                logger.info("gettime:"+gettime);
                logger.info("加密时间stime：" + stime);
                logger.info("cookiekey值：" + key);
                if (key.equals(stime)&&(gettime<30*60*1000)) {//加密规则正确，说明已经登录
                    System.out.println(key);
                    return true;

                } else {
                    request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
                    System.out.println("cookie失效");
                }
            }

            System.out.println("没有cookie");
            return false;
        }

}

