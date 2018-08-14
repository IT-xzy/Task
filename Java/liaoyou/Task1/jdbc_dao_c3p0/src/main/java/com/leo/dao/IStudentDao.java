package com.leo.dao;

import com.leo.pojo.Student;

import java.sql.ResultSet;

public interface IStudentDao {
	/*
	 * 实现学员数据添加操作，成功返回true，否则返回false
	 */
	public boolean doCreate(Student st) throws Exception;
	/*
	 * 实现学员数据修改操作,成功返回true，否则返回false
	 */
	public boolean doUpdate(Student st) throws Exception;
	/*
	 * 根据id删除学员数据，成功返回true，否则返回false
	 */
	public boolean doRemove(int id) throws Exception;
	/*
	 * 根据id查询学员信息，并将数据以实体类的形式返回
	 */
	public Student findById(long id) throws Exception;
	/*
	 * 查询数据的全部记录，并以集合的形式返回
	 */
	public ResultSet findAll() throws Exception;
}
