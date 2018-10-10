package com.java.mapper;

import com.java.Student.Student;

public interface mapperDao {
	public void Show();
	public boolean Update(Student student);
	public boolean Delete(int id);
	public int Insert(Student student);
	public void GetById(int id);
}
