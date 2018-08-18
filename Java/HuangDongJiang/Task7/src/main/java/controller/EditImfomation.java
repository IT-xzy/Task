package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;
import service.LoginService;
import service.UserService;
import strategy.Context;
import util.ALiMailUtil;
import util.SendCloundMailUtil;
import util.Xsmtpapi;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Controller
public class EditImfomation {
	private static final Log log = LogFactory.getLog(EditImfomation.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SendCloundMailUtil sendCloundMailUtil;

	@RequestMapping(value = "/imformation", method = RequestMethod.POST)
	public String editImfomation(HttpServletRequest request, MultipartFile picture, String name) {
		//将照片保存到阿里云
		String pictureName = picture.getOriginalFilename();
			//获得图片的输入流
		try {
			InputStream inputStream = picture.getInputStream();
			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"classpath:/spring/applicationContext.xml");
			Context context = (Context) applicationContext.getBean("context");
			context.executeStrategy(pictureName, inputStream);

			//保存照片的key到数据库中
			userService.updateUserPictureByName(name,pictureName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:" + request.getContextPath() + "/index";
	}

	//发送邮箱，这里是单纯测试邮箱发送
	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String senEmail(HttpServletRequest request, String mail) throws IOException, MessagingException {
		ALiMailUtil.sendMail(mail);
		return "redirect:" + request.getContextPath() + "/index";
	}
}
