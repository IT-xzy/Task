package com.ptteng.manager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptteng.dao.UserDao;
import com.ptteng.pojo.exception.XSSException;
import com.ptteng.utils.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Objects;

public class LoginManager extends HandlerInterceptorAdapter {
    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (!check(request,response)) {
            /*对于request.getRequestDispatcher("@path").forward(request, response)，该方法不清空响应头的信息
            如果直接Forwrad，就会对REST风格的PUT和DELETE方法报错（因为/a/login写的只有post和get两种）
            * 如果用sendRedirect()的话就会出warn信息提示信息丢失，很头疼
            * setHeader我尝试了下，也不是很好用...
            * 我不知道有什么更好的办法，只能先这样子弄吧*/
            /*——————————————————分割符 2018.2.3—————————————————————*/
            /*经过讨论，发现拦截器可以用更灵活的自定义AOP环绕通知代替，而且在打印日志和返回json对象时更方便
            * 目前还没有前端和我配合，还是得用jsp，所以这部分重构搁着，以后再做吧
            * 返回json，然后由前端配置路由规则，真是解放了后端好多工作啊！*/
            String method = request.getMethod();
            if (!Objects.equals(method, "GET"))
                throw new XSSException("未登录的情况下尝试修改数据");
            request.getRequestDispatcher("/a/login").forward(request, response);
            return false;
        }
        return true;
    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }


    private boolean check(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Boolean result = false;
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0)
            return false;
        for (Cookie cookie : cookies) {
            //筛选排除无关cookie
            if (!Objects.equals(cookie.getName(), "Token")) {
                continue;
            }
            //绑定session，token内容不一致的时候不会通过拦截
            if (!Objects.equals(request.getSession().getAttribute("user"), cookie.getValue())) {
                continue;
            }
            /*防止第三方脚本挟持Session进行XSS攻击，需要进行时间戳验证
            这里有一个坏处就是不能支持多开操作了，另一个号上线会把之前那个挤下去*/
            DesUtil desUtil = new DesUtil("java");
            String[] token = desUtil.decrypt(cookie.getValue()).split(",");
            if (token.length != 2) {
                return false;
            }
            String userName = token[0];
            Long tokenTime = Long.valueOf(token[1]);
            Long lastLoginTime = userDao.findByName(userName).getLoginAt();
            if (!Objects.equals(lastLoginTime, tokenTime)) {
                //删除之前登录会话中的cookie
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                throw new XSSException("该Session的信息可能存在异常");
            }
            result = true;
        }
        return result;
    }
}

