package com.leo.controller;

import com.leo.model.Student5VO;
import com.leo.service.Login5Service;
import com.leo.service.Student5Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Login5Controller {
	
	@Autowired
	Student5Service student5Service;
	@Autowired
	Login5Service login5Service;
	
	private static final Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@RequestMapping("register")
	public ModelAndView addStudent5(Student5VO student5VO){
		ModelAndView mav = new ModelAndView("login");
		student5Service.insert(student5VO);
		logger.debug("注册成功 用户名："+student5VO.getName()+" 用户密码"+student5VO.getPassword());
		return mav;
	}
	
	@RequestMapping("/u/login")
	public String login(){
		return "login";
	}
	
	// 用户退出时清除用户数据库token
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		Cookie cookie = getCookie(cookies,"token");
		if (cookie == null){
			try {
				response.sendRedirect("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String token = cookie.getValue();
		// 从cookie中取得用户id
		String uid = token.substring(0,token.indexOf("|"));
		logger.debug("用户退出成功 uid："+uid);
		// 设置为0删除cookie
		cookie.setMaxAge(0);
		cookie.setValue(null);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:home";
	}
	
	// 当用户登录认证成功后，生成token
	@RequestMapping("validate")
	public ModelAndView login(Student5VO student5VO, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		try {
			Long id = login5Service.validate(student5VO);
			if (id != null){
					// 生成token
					String token = id.toString()+"|"+login5Service.generatorToken(student5VO);
					// 实例一个cookie对象
					Cookie cookie = new Cookie("token",token);
					// 设置客户端cookie存活时间，路径
					cookie.setMaxAge(60*60*24*15);
					cookie.setPath("/");
					response.addCookie(cookie);
					mav.setViewName("redirect:/home");
					logger.debug("用户token创建完毕");
					logger.debug(cookie.getMaxAge()+"  "+cookie.getValue()+"  "+cookie.getName());
			} else{
				mav.setViewName("failed");
			}
		} catch (Exception e) {
			mav.setViewName("failed");
		}
		
		return mav;
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

/*
 *  使用session进行认证需要将session里的用户信息保存一段时间，淘宝是将session存储到
 *  分布式缓存中，当需要时从缓存中取出放入内存。
 *
 */
