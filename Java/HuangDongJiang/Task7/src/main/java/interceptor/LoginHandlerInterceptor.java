package interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.DesUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
	private static final Log log = LogFactory.getLog(LoginHandlerInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object handler) throws Exception {
		log.info("login拦截器preHandler方法执行。。。");
		DesUtil desUtil = new DesUtil("FuckYou");
		//从cookie中取出token
		Cookie[] cookies = request.getCookies();
		//遍历cookie
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginToken")) {
				String encryptloginToken = cookie.getValue();
				log.info("加密的cookieToken：" + encryptloginToken);
				//验证token的有效性
				String decryptLoginToken = desUtil.decrypt(encryptloginToken);
				String[] split = decryptLoginToken.split("\\.");
				long loginTime = Long.parseLong(split[1]);
				Long currentTime = System.currentTimeMillis();
				if (currentTime - loginTime > 30 * 60 * 1000 ){
					//token超时
					response.sendRedirect(request.getContextPath() + "/login/pleaseLogin.jsp");
					return false;
				}
				log.info("decryptLoginToken:  "+decryptLoginToken);
				log.info("getSession   "+request.getSession().getAttribute("loginSession"));
				if (decryptLoginToken.equals(request.getSession().getAttribute("loginSession"))) {
					//验证通过，放行
					log.info("验证通过。。。");
					return true;
				}
			}
		}
		//没有登录,重定向到登录页面
		response.sendRedirect(request.getContextPath() + "/login/pleaseLogin.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						   Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception ex) throws Exception {
	}
}
