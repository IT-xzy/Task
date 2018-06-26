package com.task.interceptor;

import com.task.models.Student;
import com.task.rmi.RmiDispatcher;
import com.task.service.StudentService;
import com.task.utils.CookieUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是否加入内门的拦截器，判断依据就是student表中能否找到其数据
 */
public class StudentInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    RmiDispatcher rmiDispatcher;
//    private StudentService studentService=rmiDispatcher.getStudentService();
    private Logger logger = Logger.getLogger(StudentInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        StudentService studentService=rmiDispatcher.getStudentService();
       logger.info("进入student拦截器");
        String username= CookieUtil.getCookieValue(request,"username");
        Student student=studentService.justListByUsername(username);
        //如果不存在数据，就拦截下来,存在就通过
        if (student==null){
            response.sendRedirect("/u/gojoin");
            logger.info("验证失败，拦截");
            return false;
        }else {
            logger.info("验证成功，允许通行");
            return true;
        }
    }
}
