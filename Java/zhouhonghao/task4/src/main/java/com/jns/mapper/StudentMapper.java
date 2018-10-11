package com.jns.mapper;

import com.jns.pojo.Student;

import java.util.List;

public interface StudentMapper {
	
 int add(Student student);

 void delete(int id);

 Student get(int id);

 int update(Student student);

 List<Student> list();

}
