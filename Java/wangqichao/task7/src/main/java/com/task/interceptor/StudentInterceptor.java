package com.task.interceptor;

import com.task.models.Student;
import com.task.service.StudentService;
import com.task.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是否加入内门的拦截器，判断依据就是student表中能否找到其数据
 */
public class StudentInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private StudentService studentService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        String username= CookieUtil.getCookieValue(request,"username");
        Student student=studentService.justListByUsername(username);
        //如果不存在数据，就拦截下来,存在就通过
        if (student==null){
            response.sendRedirect("/u/gojoin");
            return false;
        }else {
            return true;
        }
    }
}
