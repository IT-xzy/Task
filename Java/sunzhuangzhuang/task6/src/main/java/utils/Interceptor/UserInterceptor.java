package utils.Interceptor;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spring.dao.UserDao;
import utils.jiami.CookieUtil;
import utils.jiami.Token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {



    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = CookieUtil.getCookie("login",request);
        if (cookie==null){
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }else {
            String value = cookie.getValue();
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserDao userDao = applicationContext.getBean(UserDao.class);
            String name = Token.parseJWT(value).getId();
            String tokenDate = Token.parseJWT(value).getSubject();
            String date = userDao.getName(name).toString();
            if(date.equals(tokenDate)){
                return true;
            }else {
                return false;
            }
        }
    }
}
