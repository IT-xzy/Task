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

	public List<Student> Show() {
		// TODO 自动生成的方法存根
		List<Student> s2= mapperdao.Show();
		for(Student s:s2) {
			System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
		}
		return s2;
	}

	private mapperDao mapper() {
		// TODO 自动生成的方法存根
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session=sqlSessionFactory.openSession();
			mapperDao mapper=session.getMapper(mapperDao.class);
			return mapper;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}
mapperDao mapperdao=mapper();
	public int Update(Student student) {
		// TODO 自动生成的方法存根
		if(mapperdao!=null) {
			Student s= mapperdao.GetById(student.getId());
			s.setName(student.getName());
			int x=mapperdao.Update(s);
			if(x!=0) {
				System.out.println("更新成功");
				return x;
			}	 
		}
		return 0;
	}

	public int Delete(int id) {
		// TODO 自动生成的方法存根
		if(mapperdao!=null) {
			 int x=mapperdao.Delete(id);
			 if(x!=0) {
					System.out.println("添加成功");
					return x;
				}
		}
		return 1;
	}

	public int Insert(Student student) {
		// TODO 自动生成的方法存根
		Student s=new Student();
		s.setId(student.getId());
		s.setName(student.getName());
		int x=mapperdao.Insert(s);	
		if(x!=0) {
			System.out.println("添加成功");
		}
		return s.getId();
	}

	public Student GetById(int id) {
		// TODO 自动生成的方法存根
		Student s=mapperdao.GetById(id);
		System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
		return s;
	}

}
