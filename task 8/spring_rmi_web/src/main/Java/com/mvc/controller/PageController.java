package com.mvc.controller;

import com.mvc.model.Person;
import com.mvc.model.Type;
import com.mvc.service.PersonService;
import com.mvc.service.TypeService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	PersonService personService;
	@Autowired
	MemcachedClient memcachedClient;
	@Autowired
	TypeService typeService;

	//主页
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

	//职业
	@RequestMapping(value = "/pro")
	public String profession(Model model)throws Exception{
		List<Type> typeClass = typeService.queryDirection("前端");
		List<Type> typeClass1 = typeService.queryDirection("后端");
		int student = personService.queryType("WEB");
		int student1 = personService.queryType("JAVA");
		System.out.println(typeClass+"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		model.addAttribute("items2",typeClass);
		model.addAttribute("items1",typeClass1);
		model.addAttribute("item",student);
		model.addAttribute("item1",student1);
		return "profession";
	}
}
