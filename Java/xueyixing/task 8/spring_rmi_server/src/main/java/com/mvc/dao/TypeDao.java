package com.mvc.dao;

import com.mvc.model.Type;

import java.util.List;

public interface TypeDao {

	List<Type> queryDirection (String direction);

}
