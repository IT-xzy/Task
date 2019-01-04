package com.mutesaid.rmi_demo_web.interceptor;

import com.mutesaid.rmi_demo_core.model.Usr;
import com.mutesaid.rmi_demo_core.service.UsrService;
import com.mutesaid.rmi_demo_web.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private UsrService usrService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        log.info("拦截器");
        Long uid = CookieUtil.getUid(request);
        log.info("uid = {}", uid);
        if (uid == null) {
            response.sendRedirect("/nologin");
            return false;
        }
        log.info("登录 uid = {}", uid);
        //进行判断，如果该uid对应的用户不为null，return true
        Usr usr = usrService.findById(uid);

        if (usr != null) {
            String requestUrl = this.getInterceptorUrl(request);
            log.info(" 请求 url = {}", requestUrl);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public String getInterceptorUrl(HttpServletRequest request) {
        String interceptorUrl = request.getRequestURI()
                + (null == request.getQueryString() ? "" : "?"
                + request.getQueryString());
        interceptorUrl = interceptorUrl.replace("/app/", "/");
        return interceptorUrl;
    }
}

