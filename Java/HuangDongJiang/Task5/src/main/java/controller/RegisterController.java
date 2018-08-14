package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.RegisterService;

import javax.annotation.Resource;

@Controller
public class RegisterController {
	private static final Log logger = LogFactory.getLog(RegisterController.class);
	@Resource(name = "registerServiceImpl")
	private RegisterService registerService;
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String register(User user){
        logger.info("register方法运行。。。");
        registerService.addUser(user);
		return "redirect:/register/success.jsp";
	}
}
