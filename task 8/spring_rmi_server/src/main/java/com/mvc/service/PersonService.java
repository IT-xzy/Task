package com.mvc.service;

import com.mvc.model.Person;

import java.util.List;

public interface PersonService {

	Integer queryWork(Integer isWork)throws Exception;
	List<Person> queryGood(Integer isGood)throws Exception;
	int queryType(String type)throws Exception;
	Person findStudentId(Integer ID)throws Exception;

}