package Intercreptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.Jwt;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookie=httpServletRequest.getCookies();
        for (Cookie ck : cookie)
            if(ck.getName().equals("token")){
            String token = ck.getValue();
            if(Jwt.parseJWT(token).equals("恭喜你猜对啦")) {
                System.out.println("完成token检验");
                return true;
            }
            }
            //未登录就跳转
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/task5/error.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }
    /**
     *
     *
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
