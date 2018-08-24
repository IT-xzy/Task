package com.mvc.service;

import com.mvc.model.Type;

import java.util.List;

public interface TypeService {

	List<Type> queryDirection (String direction) throws Exception;

}