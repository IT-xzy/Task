package com.longhang.userHandler;

import com.longhang.server.UserService;
import com.longhang.util.Token;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UserRoleHandler extends UserHandler{
    @Resource
    private UserService userSe;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            MyAnno myAnno = ((HandlerMethod) handler).getMethodAnnotation(MyAnno.class);
//        }

            System.out.println("preHandle...");
            String requestUri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String url = requestUri.substring(contextPath.length());
            System.out.println("requestUri:" + requestUri);
            System.out.println("contextPath:" + contextPath);
            System.out.println("url:" + url);
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
                System.out.println(userName);
                Long time = userSe.getLoginTimeByName(userName);
                System.out.println("登录时间：" + time);
                String stime = tk.makeToken(String.valueOf(userSe.getLoginTimeByName(userName)));
                System.out.println("key：" + key);
                Long keytime=Long.valueOf(tk.SolveToken(key));
                System.out.println("keytime:"+keytime);
                Long thistime=System.currentTimeMillis();
                Long gettime=thistime-keytime;
                System.out.println("gettime:"+gettime);
                System.out.println("加密时间stime：" + stime);
                System.out.println("cookiekey值：" + key);
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

