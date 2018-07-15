package com.mvc.controller;

import com.mvc.model.Person;
import com.mvc.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {

	private static Logger logger = LoggerFactory.getLogger(JSONController.class);

	@Autowired
	PersonService personService;

	@ResponseBody
	@RequestMapping(value = "/json/{ID}",method = RequestMethod.GET)
	public Person findStudentId (@PathVariable Integer ID)throws Exception{
		return personService.findStudentId(ID);
	}
}
