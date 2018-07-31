package wyq.webapp.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        String localtoken = (String) session.getAttribute("token");
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("token")) {
                String token = cookie.getValue();
                System.out.println(token);
                System.out.println(token);
                if (token != null&&token.equals(localtoken)) {
                    return true;
                }
                else {
                    System.out.println("token不匹配");
                    request.getRequestDispatcher("/user").forward(request,response);
                    return false;
                }
            }
        }
        System.out.println("登录失败");
        request.getRequestDispatcher("/user").forward(request,response);
        System.out.println("拦截登录");
        return false;
    }
}
