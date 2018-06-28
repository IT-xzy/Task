package com.mvc.intercept;

import com.mvc.model.User;
import com.mvc.service.PersonService;
import com.mvc.util.DESUlit;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//测试拦截器1
public class LoginInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	private static final String PASSWORD_CRYPT_KEY = "779654316";// 示例密钥
	@Autowired
	private PersonService personService;

	//进入Handler方法之前执行
	//可以用于身份认证、身份授权。如果认证没有通过表示用户没有登陆，需要此方法拦截不再往下执行，否则就放行
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否公开地址（实际使用时将公开地址配置到配置文件中）
		//这里假设公开地址是否登陆提交的地址

		String[] noFilters = new String[] {"lock","new","register","home","json"};
		for (String s : noFilters) {
			if (url.indexOf(s) > 0) {
				//如果进行登陆提交，放行
				return true;
			}
		}

		//判断session
		/*HttpSession session = request.getSession();*/

		//判断cookie
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies)
				if ("token".equals(cookie.getName())){
				byte[] fff = Base64.decodeBase64(cookie.getValue());
				String ddd = DESUlit.decrypt(new String(fff),PASSWORD_CRYPT_KEY);
				String[] str=ddd.split("\\|");
				User user = personService.queryID(str[0]);
				if (user !=null){
					return true;
				}
			}
		}


		//从session中取出用户身份信息
		/*String username = (String) session.getAttribute("username");
		if (username != null) {
			logger.debug("验证：username != null");
			return true;
		}*/

		//执行到这里表示用户身份需要验证，跳转到登陆页面
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		logger.debug("验证：false");
		return false;
	}

	//节省空间，省略另外两个方法不写了，也不用处理
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						   Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1....postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception ex) throws Exception {
		System.out.println("HandlerInterceptor1....afterCompletion");
	}
}
