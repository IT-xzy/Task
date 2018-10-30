package demo3.student;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.java.Service.service;
import com.java.Student.Student;

public class student {
	static Log log=LogFactory.getLog(student.class);
	 static service service=new service();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
Show();//搜索该数据库表中所有信息
//insert();//添加数据
//update();//修改数据
//delete();//删除数据
//getid();//通过id查询
	}

	private static void getid() {
		// TODO 自动生成的方法存根
		service.GetById(1);
	}

	private static void delete() {
		// TODO 自动生成的方法存根
		log.info(service.Delete(3));
	}

	private static void update() {
		// TODO 自动生成的方法存根
		Student s1=new Student();
		s1.setId(3);
		s1.setName("王五");
		log.info(service.Update(s1));
	}

	private static void insert() {
		// TODO 自动生成的方法存根
		Student s1=new Student();
		s1.setId(3);
		s1.setName("李三");
		log.info(service.Insert(s1));
	}

	private static void Show() {
		// TODO 自动生成的方法存根
		service.Show();
	}

}
