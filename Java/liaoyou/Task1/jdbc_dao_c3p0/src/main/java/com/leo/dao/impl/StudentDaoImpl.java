package com.leo.dao.impl;

import com.leo.dao.IStudentDao;
import com.leo.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDaoImpl implements IStudentDao{
	Logger logger = (Logger) LogManager.getLogger("mylog");
	private Connection conn;
	PreparedStatement pstmt;
	
	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Student st) throws Exception {
		
		String sql = "INSERT INTO student(name,qq,profession,school,create_time,update_time) VALUES(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,st.getName());
		pstmt.setInt(2,st.getQq());
		pstmt.setString(3,st.getProfession());
		pstmt.setString(4,st.getSchool());
		pstmt.setLong(5,st.getCreate_time());
		pstmt.setLong(6,st.getUpdate_time());
		
		return pstmt.executeUpdate() > 0;
	}
	
	@Override
	public boolean doUpdate(Student st) throws Exception {
		String sql = "UPDATE student SET name=?,qq=?,profession=?,school=?,create_time=?,update_time=? WHERE id=?";
		pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1,st.getName());
		pstmt.setInt(2,st.getQq());
		pstmt.setString(3,st.getProfession());
		pstmt.setString(4,st.getSchool());
		pstmt.setLong(5,st.getCreate_time());
		pstmt.setLong(6,st.getUpdate_time());
		pstmt.setLong(7,st.getId());
		return pstmt.executeUpdate() > 0;
	}
	
	@Override
	public boolean doRemove(int id) throws Exception {
		String sql = "delete from student where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		return pstmt.executeUpdate()  > 0;
	}
	
	@Override
	public Student findById(long id) throws Exception {
		String sql = "select * from student where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1,id);
		Student stu = new Student();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setQq(rs.getInt("qq"));
			stu.setProfession(rs.getString("profession"));
			stu.setSchool(rs.getString("school"));
			stu.setCreate_time(rs.getLong("create_time"));
			stu.setUpdate_time(rs.getLong("update_time"));
		}
		return stu;
	}
	
	@Override
	public ResultSet findAll() throws Exception {
		String sql = "select * from student";
		pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
}
