package com.mvc.controller;

import com.mvc.model.User;
import com.mvc.service.OssService;
import com.mvc.service.SendService;
import com.mvc.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;

@Controller
public class VerifyController {

	private static Logger logger = LoggerFactory.getLogger(VerifyController.class);

	@Autowired
	MemcachedClient memcachedClient;
	@Autowired
	SendService sendService;
	@Autowired
	OssService ossService;
	@Autowired
	UserService userService;

	//发送手机验证码
	@RequestMapping(value="/verify", method = RequestMethod.GET)
	public void verify(HttpServletRequest request)throws Exception{
		String phoneNum = request.getParameter("phoneNum");
		if (memcachedClient.get(phoneNum)!=null){
		}else {
			Integer sm = (int) ((Math.random() * 9 + 1) * 100000);
			HashMap<String, Object> result = sendService.setPhone(phoneNum, String.valueOf(sm));
			if ("000000".equals(result.get("statusCode"))) {
				memcachedClient.set(phoneNum, 120 * 2, String.valueOf(sm));
			} else {
				//异常返回输出错误码和错误信息
				logger.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
			}
		}
	}

	//注册账号
	@RequestMapping("/register")
	public String register(HttpServletRequest request, User user, @RequestParam("photo") MultipartFile file)throws Exception{
		String ww = request.getParameter("verifyCode");
		logger.info("前端传入的验证码为："+ww);
		if (!file.isEmpty()) {
			byte[] buf = file.getBytes();
			String PhotoKey = ossService.updatePhoto(buf);
			user.setPhoto(PhotoKey);
		}else{
			String PhotoKey = "FoFUIh8-0KHwwzpLIAa412VxsxgL";
			user.setPhoto(PhotoKey);
		}
		logger.info("查看即将插入数据："+user);
		if (!"".equals(ww)) {
			if (Integer.parseInt(ww) == Integer.parseInt(memcachedClient.get(user.getPhone()))) {
				userService.addUser(user);
				return "redirect:/home";
			}
		}
		return "no";
	}

	//发送邮件验证
	@RequestMapping(value="/email", method = RequestMethod.POST)
	public String email(HttpServletRequest request, User user)throws Exception{
		if (memcachedClient.get(user.getEmail())!=null) {
			return "noNo";
		}
		String sh = user.getUserName();
		String sw = user.getEmail();
		memcachedClient.set(user.getEmail(),3600,user.getUserName());
		sendService.sendEmail(sw,"wwww.baidu,com",sh);
		return "toYes";
	}

	//上传图片
	@RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
	public ModelAndView fileUpload(@RequestParam("photo") MultipartFile file) {
		// 判断文件是否为空
		String PhotoKey = null;
		if (!file.isEmpty()) {
			try {
				byte[] buf = file.getBytes();
				PhotoKey = ossService.updatePhoto(buf);
				logger.info(PhotoKey);
				// 文件保存路径
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("toPhoto",PhotoKey);
		modelAndView.setViewName("yes");
		return modelAndView;
	}



	/***
	 * 读取上传文件中得所有文件并返回
	 *
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request) {
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			//打印出文件名
			System.out.println(fileNames[i]);
		}
		return mav;
	}
}
