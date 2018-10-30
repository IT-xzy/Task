package com.java.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.java.Student.Student;
import com.java.mapper.mapperDao;

public class service implements mapperDao{
String resource="mybatis-config.xml";

	public void Show() {
		// TODO 自动生成的方法存根
		SqlSession session=sqlsession();
		List<Student> s2=session.selectList("listStudent");
		for(Student s:s2) {
		System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
		}
		session.commit();
		session.close();
	}

	private SqlSession sqlsession() {
		// TODO 自动生成的方法存根
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session=sqlSessionFactory.openSession();
			return session;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean Update(Student student) {
		// TODO 自动生成的方法存根
		SqlSession session=sqlsession();
		if(session!=null) {
			Student s= session.selectOne("getStudent",student.getId());
			s.setName(student.getName());
			int x=session.update("updateStudent", s);
			session.commit();
			session.close();
			if(x!=0) {
				System.out.println("更新成功");
			}
			return true;
		}
		return false;
	}

	public boolean Delete(int id) {
		// TODO 自动生成的方法存根
		SqlSession session=sqlsession();
		if(session!=null) {
			Student s= session.selectOne("getStudent",id);
			int x=session.delete("deleteStudent", s);
			session.commit();
			session.close();
			if(x!=0) {
				System.out.println("删除成功");
			}
			return true;
		}
		return false;
	}

	public int Insert(Student student) {
		// TODO 自动生成的方法存根
		SqlSession session=sqlsession();
		Student s=new Student();
		s.setId(student.getId());
		s.setName(student.getName());
		int x=session.insert("addStudent", s);
		session.commit();
		session.close();
		if(x!=0) {
			System.out.println("添加成功");
		}
		return s.getId();
	}

	public void GetById(int id) {
		// TODO 自动生成的方法存根
		SqlSession session=sqlsession();
		Student s=session.selectOne("getStudent",id);
		System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
		session.commit();
		session.close();
	}

}
