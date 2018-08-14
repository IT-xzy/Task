package interceptor;

import com.jns.dao.StudentDao;
import com.jns.pojo.Student;
import com.jns.service.StudentService;
import com.jns.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.CookieUtil;
import util.JWTUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       获取含有token的cookie
        Cookie cookie = CookieUtil.getCookie("token", request);

        if (cookie == null) {
           response.sendRedirect(request.getContextPath()+"/");
           return false;
        }else {
            Integer tokenStuID = JWTUtil.getStuID(cookie.getValue());
            Long tokenLoginTime = JWTUtil.getLogintime(cookie.getValue());
            ApplicationContext ap = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
            StudentDao studentDao = ap.getBean(StudentDao.class);
            Student student = studentDao.selectStuID(tokenStuID);
            Long logintime = student.getLoginTime();
            if (tokenLoginTime.equals(logintime)) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath()+"/");
                return false;
            }
        }
    }

        @Override
        public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
        modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
        ex) throws Exception {

        }
    }
