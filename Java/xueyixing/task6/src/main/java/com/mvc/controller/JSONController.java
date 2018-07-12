package com.mvc.controller;

import com.mvc.model.User;
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
	@RequestMapping(value = "/json/api/{userName}",method = RequestMethod.GET)
	public User queryUser (@PathVariable String userName)throws Exception{
		return personService.queryUser(userName);
	}

	@ResponseBody
	@RequestMapping(value = "/rest/api/{userName}",method = RequestMethod.GET)
	public User findUser(@PathVariable String userName)throws Exception{
		return personService.queryUser(userName);
	}
}
