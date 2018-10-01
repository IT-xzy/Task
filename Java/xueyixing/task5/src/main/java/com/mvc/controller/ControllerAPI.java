package com.mvc.controller;

import com.mvc.model.TypeClass;
import com.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/u")
public class ControllerAPI {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/pro")
	public String profession(Model model)throws Exception{
		List<TypeClass> typeClass = personService.queryDirection("前端");
		List<TypeClass> typeClass1 = personService.queryDirection("后端");
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