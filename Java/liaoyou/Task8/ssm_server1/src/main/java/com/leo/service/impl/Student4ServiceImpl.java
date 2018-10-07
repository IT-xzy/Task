package com.leo.service.impl;

import com.leo.dao.Student4Mapper;
import com.leo.model.Student4;
import com.leo.service.Student4Service;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student4ServiceImpl implements Student4Service{
	
	@Autowired
	Student4Mapper student4Mapper;
	
	@Override
	public void deleteById(Long id) {
		student4Mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void insert(Student4 student4) {
		student4.setCreateAt(System.currentTimeMillis());
		student4.setUpdateAt(System.currentTimeMillis());
		student4Mapper.insert(student4);
	}
	
	@Override
	public Student4 selectById(Long id) {
		Student4 student4 = student4Mapper.selectByPrimaryKey(id);
		return student4;
	}
	
	@Override
	public List<Student4> selectAll() {
		return student4Mapper.selectAll();
	}
	
	@Override
	public void updateById(Student4 student4) {
		student4.setUpdateAt(System.currentTimeMillis());
		student4Mapper.updateByPrimaryKey(student4);
	}
	
	@Override
	public List<Student4> selectExcellentStudent(){
		return student4Mapper.selectExcellentStudent();
	}
	
	@Override
	public int total(){
		return student4Mapper.total();
	}
	
	@Override
	public int isWork(){
		return student4Mapper.isWork();
	}
	
	@Override
	public int jobCount(String job){
		return student4Mapper.jobCount(job);
	}
}
