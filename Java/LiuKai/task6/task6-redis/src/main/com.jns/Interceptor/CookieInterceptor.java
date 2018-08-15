package Interceptor;

import dao.LoginsDao;
import dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pojo.Logins;
import pojo.Student;
import util.TokenUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class CookieInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                long id1=TokenUtil.getID(cookie.getValue());
                long t1=TokenUtil.getLogntime(cookie.getValue());
//                System.out.println("t1="+t1);
                ApplicationContext ap=new ClassPathXmlApplicationContext("applicationContext.xml");
                StudentDao studentDao=ap.getBean(StudentDao.class);
                Student student=studentDao.findById(id1);
                long t2=student.getLoginTime();
//                System.out.println("t2="+t2);
//                LoginsDao loginsDao=ap.getBean(LoginsDao.class);
//                Logins logins=loginsDao.findById(id1);
//                long t2=logins.getLogntime();
                if (t1 == t2){
                    return true;
                }
            }else{
            }
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
