package com.mvc.controller;

import com.mvc.model.Person;
import com.mvc.model.User;
import com.mvc.service.PersonService;
import com.mvc.springUtil.ALiYunOssAPI;
import com.mvc.springUtil.QiNiuYunOssAPI;
import com.mvc.springUtil.SendPhoneTemplate;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Controller
public class VerifyController {

	private static Logger logger = LoggerFactory.getLogger(VerifyController.class);

	@Autowired
	private PersonService personService;
	@Autowired
	MemcachedClient memcachedClient;
	@Autowired
	SendPhoneTemplate sendPhoneTemplate;

	@RequestMapping(value="/verify", method = RequestMethod.GET)
	public void verify(HttpServletRequest request)throws Exception{
		String phoneNum = request.getParameter("phoneNum");
		Integer sm = (int)((Math.random()*9+1)*100000);
		HashMap<String, Object> result = sendPhoneTemplate.setPhone(phoneNum,String.valueOf(sm));
		if ("000000".equals(result.get("statusCode"))) {
			memcachedClient.set(phoneNum,3600*2, String.valueOf(sm));
		} else {
			//异常返回输出错误码和错误信息
			logger.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}
	}

	@RequestMapping(value = "/home")
	public String queryWork(Model model)throws Exception{
		Integer student = personService.queryWork(1);
		Integer student1 = personService.queryWork(0);
		List<Person> person2 = personService.queryGood(1);
		logger.info("找到工作的学员有："+student);
		logger.info("在学学员有："+student1);
		logger.info("优秀学员展示："+ person2);
		model.addAttribute("items1",student1);
		model.addAttribute("items",student);
		model.addAttribute("items2", person2);
		return "homepage";
	}

	@RequestMapping("/register/cellphone")
	public String register(HttpServletRequest request, User user,@RequestParam("photo") MultipartFile file)throws Exception{
		String sh = memcachedClient.get(user.getPhone());
		logger.info("缓存中取出的值为："+sh);
		String ww = request.getParameter("verifyCode");
		logger.info("前端传入的验证码为："+ww);
		if (!file.isEmpty()) {
			String PhotoKey = QiNiuYunOssAPI.setPhoto(file);
			user.setPhoto(PhotoKey);
		}else{
			String PhotoKey = "FoFUIh8-0KHwwzpLIAa412VxsxgL";
			user.setPhoto(PhotoKey);
		}
		logger.info("查看即将插入数据："+user);
		if (Integer.parseInt(ww)==Integer.parseInt(sh)){
			personService.addUser(user);
			return "redirect:/home";
		}
		return "redirect:OhNo";
	}

	@RequestMapping("/email/register")
	public String email(HttpServletRequest request, User user)throws Exception{
		return "";
	}

	@RequestMapping("/verify/email")
	public String verifyEmail()throws Exception{
		return "";
	}

	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam("photo") MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				String PhotoKey = ALiYunOssAPI.setPhoto(file);
				logger.info(PhotoKey);
				// 文件保存路径
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/home";
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