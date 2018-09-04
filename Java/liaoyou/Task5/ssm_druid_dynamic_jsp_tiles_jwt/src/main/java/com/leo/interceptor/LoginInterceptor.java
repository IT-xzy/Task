package com.leo.interceptor;

import com.leo.service.Login5Service;
import com.leo.utils.JavaWebToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LogManager.getLogger("mylog");
	
	@Autowired
	Login5Service login5Service;
	
	// 此拦截器主要针对job路径的访问：未登录用户无法访问job页
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = getCookie(cookies,"token");
		if (cookie == null){
			logger.debug("客户端没有返回cookie");
			response.sendRedirect("login");
		} else {
			if (cookie.getValue() == null){
				logger.info("客户端返回cookie的value为空");
				response.sendRedirect("login");
			} else {
				String token = cookie.getValue();
				Map<String,Object> map = JavaWebToken.parseJWT(token);
				if (map != null){
						logger.info("用户已通过token认证，id："+map.get("id")+" username："+map.get("username"));
						logger.debug(cookie.getMaxAge()+"  "+cookie.getValue()+"  "+cookie.getName());
						cookie.setMaxAge(60*60*24*15);
						// 每次都要设置过期时间，不然默认是-1，不知为什么
						logger.debug(cookie.getMaxAge()+"  "+cookie.getValue()+"  "+cookie.getName());
						cookie.setPath("/");
						response.addCookie(cookie);
				} else {
					logger.info("token认证未通过");
					response.sendRedirect("login");
				}
			}
		}
		
		return true;
	}
		
	// 返回指定cookie对象
	public Cookie getCookie(Cookie[] cookies, String key){
		if (cookies != null){
			for (int i=0; i<=cookies.length-1;i++){
				if (cookies[i].getName().equals(key)){
					return cookies[i];
				}
			}
		}
		return null;
	}
}
