package com.mvc.dao;

import com.mvc.model.TypeClass;
import com.mvc.model.Person;
import com.mvc.model.User;

import java.util.List;

public interface Dao {

	Integer queryWork(Integer isWork);
	List<Person> queryGood(Integer isGood);
	List<TypeClass> queryDirection (String direction);
	int queryType(String type);
	Person findStudentId(Integer ID);
	boolean addUser(User user);
}