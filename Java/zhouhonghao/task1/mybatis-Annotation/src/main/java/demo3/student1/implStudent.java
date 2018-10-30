package demo3.student1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.java.Student.Student;
import com.java.mapper.mapperDao;

public class implStudent {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String resource="mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session=sqlSessionFactory.openSession();
			mapperDao mapper=session.getMapper(mapperDao.class);
			Show(mapper);//搜索该数据库表中所有信息
			//System.out.println(insert(mapper));//添加数据
			//System.out.println(update(mapper));//修改数剧
			//System.out.println(delete(mapper));//删除数据
			//getid(mapper);//通过id查询
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	private static boolean delete(mapperDao mapper) {
		// TODO 自动生成的方法存根
		if(mapper!=null) {
			 mapper.Delete(4);
			return true;
		}
		return false;
	}

	private static void getid(mapperDao mapper) {
		// TODO 自动生成的方法存根
		Student s=mapper.GetById(1);
		System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
	}

	private static boolean update(mapperDao mapper) {
		// TODO 自动生成的方法存根
		if(mapper!=null) {
		Student student=mapper.GetById(2);
		student.setName("玩笑");
		mapper.Update(student);
		return true;
		}
		return false;
	}

	private static int insert(mapperDao mapper) {
		// TODO 自动生成的方法存根
		Student s=new Student();
		s.setId(4);
		s.setName("李四");
		mapper.Insert(s);	
		return s.getId();
	}

	private static void Show(mapperDao mapper) {
		// TODO 自动生成的方法存根
		List<Student> s2= mapper.Show();
		for(Student s:s2) {
			System.out.println("学号:"+s.getId()+"\t姓名:"+s.getName());
		}
	}

}
