package com.leo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.model.Student4;
import com.leo.model.Student5DO;
import com.leo.service.Student4Service;
import com.leo.service.Student5Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("")
public class Student4Controller {

	private static final Logger logger = LogManager.getLogger("mylog");
	
	@Autowired
	Student4Service student4Service;
	
	// 使用Model传输数据
	@RequestMapping("home")
	public String selectExcellentStudent(Model model){
		
		List<Student4> student4s = student4Service.selectExcellentStudent();
		int total = student4Service.total();
		int isWork = student4Service.isWork();
		logger.debug("优秀学生:"+student4s+"  总记录数:"+total+"  工作人数:"+isWork);
		model.addAttribute("student4s",student4s);
		model.addAttribute("total",total);
		model.addAttribute("isWork",isWork);
		model.addAttribute("body","home");
		// 与上面效果一样，接收参数方式也相同
		// mav.getModel().put("isWork",isWork);
		// mav.setViewName("home");
		// mav.getModel().put("total",total);
		return "myView";
	}
	
	// 使用ModelAndView传输数据
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
		logger.debug("jobCount查询成功"+jobCount);
		mav.addAllObjects(jobCount);
		mav.addObject("body","job");
		mav.setViewName("myView");
		return mav;
	}
	

}
