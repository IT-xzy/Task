package com.java.jdbctemplate;


import com.java.pojo.Category;

public interface Dao {
	public void Show();
	public void Update(Category category);
	public void Delete(int id);
	public void Insert(Category category);
	public void GetById(int id);
}
