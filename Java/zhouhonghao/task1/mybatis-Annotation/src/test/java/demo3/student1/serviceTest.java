package demo3.student1;

import org.junit.Test;

import com.java.Service.service;
import com.java.Student.Student;

public class serviceTest {
service s=new service();
	@Test
	public void testShow() {
		s.Show();
	}

	@Test
	public void testUpdate() {
		Student s1=new Student();
		s1.setId(2);
		s1.setName("王三");
		System.out.println(s.Update(s1));
	}

	@Test
	public void testDelete() {
		System.out.println(s.Delete(3));
	}

	@Test
	public void testInsert() {
		Student s1=new Student();
		s1.setId(4);
		s1.setName("李四");
		System.out.println(s.Insert(s1));
	}

	@Test
	public void testGetById() {
		s.GetById(1);
	}

}
