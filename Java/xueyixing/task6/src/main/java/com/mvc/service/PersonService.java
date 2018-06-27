package com.mvc.service;

import com.mvc.model.TypeClass;
import com.mvc.model.Student;
import com.mvc.model.User;

import java.util.List;

public interface PersonService {

	Integer queryWork(Integer isWork)throws Exception;
	List<Student> queryGood(Integer isGood)throws Exception;
	/*Student queryGood(int isGood)throws Exception;*/
	/*TypeClass queryDirection(String direction)throws Exception;*/
	List<TypeClass> queryDirection (String direction) throws Exception;
	int queryType(String type)throws Exception;
	User queryUser(String userName)throws Exception;
	boolean addUser(User user)throws Exception;
	User queryID(String a)throws Exception;
}
