package spring.Interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spring.dao.StudentDao;
import utils.CookieUtil;
import utils.Token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("在个人主页方法前执行了！");
        Cookie cookie = CookieUtil.getCookie("login",request);
        String value = cookie.getValue();
        String userName = Token.parseJWT(value).getId();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        Boolean student = studentDao.selectByName(userName);
        if(student){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
    }
}
