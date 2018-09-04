package com.leo.controller;

import com.leo.model.Student4;
import com.leo.service.Student4Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("")
public class Student4Controller {

	private static final Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Autowired
	Student4Service student4Service;
	
	@RequestMapping("home")
	public ModelAndView selectExcellentStudent(){
		ModelAndView mav = new ModelAndView();
		List<Student4> student4s = student4Service.selectExcellentStudent();
		int total = student4Service.total();
		int isWork = student4Service.isWork();
		logger.info("优秀学生:"+student4s+"  总记录数:"+total+"  工作人数:"+isWork);
		mav.addObject("student4s",student4s);
		mav.addObject("total",total);
		mav.addObject("isWork",isWork);
		mav.getModel().put("total",total);
		// 与上面效果一样，接收参数方式也相同
		// mav.getModel().put("isWork",isWork);
		// mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping("job")
	public ModelAndView jobCount(){
		ModelAndView mav = new ModelAndView();
		// 使用HashMap存储数据
		HashMap<String,Integer> jobCount = new HashMap<>();
		jobCount.put("java",student4Service.jobCount("java"));
		jobCount.put("python",student4Service.jobCount("python"));
		jobCount.put("ios",student4Service.jobCount("ios"));
		jobCount.put("android",student4Service.jobCount("android"));
		jobCount.put("js",student4Service.jobCount("js"));
		jobCount.put("html",student4Service.jobCount("html"));
		logger.info("jobCount查询成功"+jobCount);
		mav.addAllObjects(jobCount);
		mav.setViewName("job");
		return mav;
	}
}
