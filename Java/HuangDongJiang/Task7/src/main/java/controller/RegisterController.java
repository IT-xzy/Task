package controller;

import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.RegisterService;
import util.ALiMassageUtil;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class RegisterController {
	private static final Log logger = LogFactory.getLog(RegisterController.class);

	@Resource(name = "registerServiceImpl")
	private RegisterService registerService;

	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String register(User user, String inputCode, HttpServletRequest request){

        logger.info("register方法运行。。。");
		HttpSession session = request.getSession();
        if (inputCode.equals(session.getAttribute("code"))){
        	//验证码错误
			logger.info("inputCode" + inputCode);
			logger.info("code" + session.getAttribute("code"))	;
        	return  "redirect:/register/failure.jsp";
		}
        registerService.addUser(user);
		return "redirect:/register/success.jsp";
	}

	@RequestMapping(value = "/registration/code",method = RequestMethod.GET)
	public void getCode(String phone, HttpServletRequest request,
						 HttpServletResponse response){
		//发送验证码
		ALiMassageUtil aLiMassageUtil = new ALiMassageUtil();
		try {
			logger.info(phone);
			String code = aLiMassageUtil.sendMessage(phone);

			HttpSession session = request.getSession();
			//将验证码和电话保存到session中
			session.setAttribute("code",code);
			session.setAttribute("phone",phone);
            session.setAttribute("sendTime",new Date().getTime());
		} catch (ClientException e) {
			logger.info("获取发送验证码对象失败！");
		}
	}
}
