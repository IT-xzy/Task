package com.leo.controller;

import com.leo.model.Student5VO;
import com.leo.service.Login5Service;
import com.leo.service.Student5Service;
import com.leo.utils.AliEmailUtil;
import com.leo.utils.RonglianSMS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.cache.Cache;
import javax.cache.CacheManager;
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
	@Autowired
	CacheManager cacheManager;
	
	private static final Logger logger = (Logger) LogManager.getLogger("mylog");
	
	/**
	 * @Desciption: 最简单注册页面的表单提交处理
	 * @Param: 用户名，密码
	 * @Return: 若用户名存在，服务端跳转到失败页面；注册成功，重定向至登录页面
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:45
	 */
	@RequestMapping("/u/registerSubmit")
	public ModelAndView addStudent5(Student5VO student5VO){
		ModelAndView mav = new ModelAndView();
		Student5VO student5VO1 = student5Service.selectByName(student5VO.getName());
		if (student5VO1 != null){
			mav.setViewName("failed");
			return mav;
		} else {
			mav.setViewName("redirect:login");
		}
		student5Service.insert(student5VO);
		logger.debug("注册成功 用户名："+student5VO.getName()+" 用户密码"+student5VO.getPassword());
		return mav;
	}
	
	/**
	 * @Desciption: 手机注册页面提交处理
	 * @Param: 表单数据
	 * @Return: 验证失败，服务端跳转到失败页面；注册成功，重定向至登录页面
	 * @Author: jk-leo
	 * @Date: 2018/9/16 20:21
	 */
	@RequestMapping("/u/registerByPhoneSubmit")
	public String addStudent5ByPhone(Student5VO student5VO){
		logger.debug("准备验证表单中的验证码");
		logger.debug(student5VO);
		Boolean flag = login5Service.validateCode(student5VO.getPhone(),student5VO.getCode());
		if (flag){
			logger.debug("手机验证码通过");
			student5Service.insert(student5VO);
			return "redirect:login";
		} else {
			logger.debug("手机验证码未通过");
			return "failed";
		}
	}
	
	/**
	 * @Desciption: 邮箱注册页面提交处理
	 * @Param: 表单数据
	 * @Return: 验证失败，服务端跳转到失败页面；注册成功，重定向至登录页面
	 * @Author: jk-leo
	 * @Date: 2018/9/19 21:52
	 */
	@RequestMapping("/u/registerByEmailSubmit")
	public String addStudent5ByEmail(Student5VO student5VO){
		logger.debug("准备验证表单中的验证码");
		logger.debug(student5VO);
		Boolean flag = login5Service.validateCode(student5VO.getEmail(),student5VO.getCode());
		if (flag){
			logger.debug("邮箱验证码通过");
			student5Service.insert(student5VO);
			return "redirect:login";
		} else {
			logger.debug("邮箱验证码未通过");
			return "failed";
		}
	}
	
	/**
	 * @Desciption: 最简单注册页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:47
	 */
	@RequestMapping("/u/register")
	public String registerPage(){
		return "register";
	}
	
	/**
	 * @Desciption: 手机注册页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:51
	 */
	@RequestMapping("/u/registerPhone")
	public String registerPagePhone(){
		return "registerByPhone";
	}
	
	/**
	 * @Desciption: 邮箱注册页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:52
	 */
	@RequestMapping("/u/registerEmail")
	public String registerPageEmail(){
		return "registerByEmail";
	}
	
	/**
	 * @Desciption: 用户注册时检查用户名是否存在，若存在返回true，否则返回false
	 * @Param: username
	 * @Return: true false
	 * @Author: jk-leo
	 * @Date: 2018/9/12 16:43
	 */
	@RequestMapping("/u/checkName")
	public void checkName(@RequestParam String username , HttpServletResponse response){
		Student5VO student5VO = student5Service.selectByName(username);
		if (student5VO != null){
			try {
				// 使用getWrite()方法返回ajax请求数据
				response.getWriter().print(true);
				logger.debug("checkName 返回true");
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("checkName 返回数据到客户端出错");
			}
		} else {
			try {
				response.getWriter().print(false);
				logger.debug("checkName 返回false");
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("checkName 返回数据到客户端出错");
			}
		}
	}
	
	/**
	 * @Desciption: 生成验证码并发送至用户手机
	 * @Param: phone
	 * @Return: true , false
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:53
	 */
	@RequestMapping("/u/sendPhoneCode")
	public void sendPhoneCode(@RequestParam String phone, HttpServletResponse response){

		Student5VO student5VO = student5Service.selectByPhone(phone);
		logger.debug("手机验证码");
		if (student5VO != null){
			try {
				response.getWriter().print(true);
				logger.debug("手机号已存在");
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("sendPhoneCode 返回数据到客户端出错");
			}
		} else {
			// 调用SMS工具类发送短信，将手机号与验证码缓存
			String phoneCode = RonglianSMS.setSMS(phone);
			Cache<String,String> myCache = cacheManager.getCache("myCache");
			logger.debug("phone:"+phone+" code:"+phoneCode);
			myCache.put(phone,phoneCode);
			logger.debug("已缓存验证码："+myCache.get(phone));
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.debug("已经发送短信");
		}
	}
	
	/**
	 * @Desciption: 生成验证码并发送至用户邮箱
	 * @Param: email
	 * @Return: true , false
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:53
	 */
	@RequestMapping("/u/sendEmailCode")
	public void sendEmailCode(@RequestParam String email, HttpServletResponse response){
		
		Student5VO student5VO = student5Service.selectByEmail(email);
		logger.debug("邮箱验证码");
		if (student5VO != null){
			try {
				response.getWriter().print(true);
				logger.debug("邮箱已存在");
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("sendEmailCode 返回数据到客户端出错");
			}
		} else {
			// 调用阿里云邮件工具类发送邮件，将邮箱号与验证码缓存
			String emailCode = AliEmailUtil.setEmail(email);
			logger.debug("emailCode:"+emailCode);
			Cache<String,String> myCache = cacheManager.getCache("myCache");
			logger.debug("email:"+email+" code:"+emailCode);
			myCache.put(email,emailCode);
			logger.debug("已缓存验证码："+myCache.get(email));
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.debug("已经发送邮件");
		}
	}
	
	/*-----------------------------------------以上为注册操作------------------------------------------------------------*/
	
	/**
	 * @Desciption: 登录页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 18:54
	 */
	@RequestMapping("/u/login")
	public String login(){
		return "login";
	}
	
	/**
	 * @Desciption: 手机登录页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 21:23
	 */
	@RequestMapping("/u/loginByPhone")
	public String loginByPhone(){
		return "loginByPhone";
	}
	
	/**
	 * @Desciption: 邮箱登录页面路径
	 * @Param: null
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 21:27
	 */
	@RequestMapping("/u/loginByEmail")
	public String loginByEmail(){
		return "loginByEmail";
	}
	
	/**
	 * @Desciption: 退出登录页面
	 * @Param: request,response
	 * @Return: null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 19:50
	 */
	@RequestMapping("/u/loginout")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		Cookie cookie = getCookie(cookies,"token");
		if (cookie == null){
			try {
				response.sendRedirect("/home");
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
		return "redirect:/home";
	}
	
	/**
	 * @Desciption: 获取指定cookie
	 * @Param: cookie , key
	 * @Return: cookie , null
	 * @Author: jk-leo
	 * @Date: 2018/9/16 19:51
	 */
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
	
	/**
	 * @Desciption: 用户名登录，当用户登录认证成功后，生成token
	 * @Param: Student5VO student5VO, HttpServletResponse response
	 * @Return: ?
	 * @Author: jk-leo
	 * @Date: 2018/9/16 19:54
	 */
	@RequestMapping("/u/loginByUsernameSubmit")
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
			logger.debug("验证失败");
			mav.setViewName("failed");
		}
		
		return mav;
	}
	
	/**
	 * @Desciption: 手机号登录
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/16 22:08
	 */
	@RequestMapping("/u/loginByPhoneSubmit")
	public ModelAndView loginByPhoneSubmit(Student5VO student5VO, HttpServletResponse response){
		
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
			logger.debug("验证失败");
			mav.setViewName("failed");
		}
		
		return mav;
	}
	
	/**
	 * @Desciption: 邮箱登录
	 * @Param:
	 * @Return:
	 * @Author: jk-leo
	 * @Date: 2018/9/16 22:12
	 */
	@RequestMapping("/u/loginByEmailSubmit")
	public ModelAndView loginByEmailSubmit(Student5VO student5VO, HttpServletResponse response){
		
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
			logger.debug("验证失败");
			mav.setViewName("failed");
		}
		
		return mav;
	}
}

/*
 *  使用session进行认证需要将session里的用户信息保存一段时间，淘宝是将session存储到
 *  分布式缓存中，当需要时从缓存中取出放入内存。
 *
 */
