package spring.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spring.service.IstudentService;
import spring.service.RmiService;
import utils.CookieUtil;
import utils.Token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RmiService rmiService;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IstudentService studentService = rmiService.getStudentService();
        System.out.println("在个人主页方法前执行了！");
        Cookie cookie = CookieUtil.getCookie("login",request);
        String value = cookie.getValue();
        String userName = Token.parseJWT(value).getId();
        Boolean student = studentService.selectByName(userName);
        if(student){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
    }
}
