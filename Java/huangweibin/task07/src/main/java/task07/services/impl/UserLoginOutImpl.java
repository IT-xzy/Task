package task07.services.impl;

import org.springframework.stereotype.Service;
import task07.services.UserLoginOut;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ${file_name} Create on ${date}
 * Copyright (c) ${date} by taotaosoft
 *
 * @author <a href="1070800859@qq.com">* @Author: Mr.huang </a>
 * @version 1.0
 */
@Service
public class UserLoginOutImpl implements UserLoginOut {
	@Override
	public void userLoginout(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null)  {
			System.out.println(cookies.length);
			for (Cookie cookie : cookies) {
				if ("userName".equals(cookie.getName())) {
					// 获取用户登录所使用的账户名
					cookie.setMaxAge(0);
					// System.out.println("userLoginName：" + userLoginName);
				}
				if ("name".equals(cookie.getName())) {
					cookie.setMaxAge(0);
				}

			}
			Cookie c = new Cookie("userName", "null");
			Cookie d = new Cookie("name", "null");
			c.setMaxAge(0); //另有效时间为0则系统会自动删除过期的cookie
			d.setMaxAge(0); //另有效时间为0则系统会自动删除过期的cookie
			response.addCookie(c);
			response.addCookie(d);

			HttpSession session = request.getSession();
			// 删除session
			session.removeAttribute("isSessionLogin");


		}
	}
}
