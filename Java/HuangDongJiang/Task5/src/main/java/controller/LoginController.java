package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LoginService;
import util.DesUtil;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	private static final Log logger = LogFactory.getLog(LoginController.class);
	@Resource(name = "loginServiceImpl")
	private LoginService loginService;
    @RequestMapping(value = "/account",method = RequestMethod.POST)
	public String login(String name, String password, HttpServletRequest request,
						HttpServletResponse response) throws Exception {
		logger.info("调用了login方法");
		boolean isUserExistence = loginService.judgeUser(name,password);
		//验证用户名和密码，匹配登录成功
		String login = null;
        if (isUserExistence){
        	//得到token
			String loginToken = loginService.saveToken(name);
			//保存到cookie
			Cookie tokenCookie = new Cookie("loginToken",loginToken);
			tokenCookie.setMaxAge(30 * 60);//有效时间为30分钟
			response.addCookie(tokenCookie);
			//保存到session中
			HttpSession loginSession = request.getSession();//默认有效期30分钟
			DesUtil desUtil = new DesUtil("FuckYou");
			loginSession.setAttribute("loginSession",desUtil.decrypt(loginToken));
			login = "success";
		}else {
        	login = "fail";
		}
    	return login;
	}
}
