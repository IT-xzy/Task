package com.mvc.controller;

import com.mvc.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OtherAPIController {

	private static Logger logger = LoggerFactory.getLogger(OtherAPIController.class);

	@Autowired
	PersonService personService;

}
