package com.mvc.dao;

import com.mvc.model.Person;

import java.util.List;

public interface PersonDao {

	Integer queryWork(Integer isWork);
	List<Person> queryGood(Integer isGood);
	int queryType(String type);
	Person findStudentId(Integer ID);

}
