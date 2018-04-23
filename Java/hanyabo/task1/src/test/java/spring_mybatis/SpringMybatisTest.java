package spring_mybatis;

import model.Student;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spring_mybatis.service.StudentService;
import util.RandomStuUtil;

import java.util.List;


@RunWith(value = SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "transactionManager")
@Rollback(value = true)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SpringMybatisTest {

	@Autowired
	private StudentService studentService;

	private static Logger logger;

	@BeforeClass
	public static void setUpBeforeClass() {
		logger = Logger.getLogger(SpringMybatisTest.class.getName());
	}

	@Test
	public void findStudentByIdDaoTest() {
		Student student = studentService.findStudentById(13036L);
		logger.info(student);
		logger.info("findStudentByIdDaoTest success");
	}

	@Test
	public void findStudentByNameDaoTest() {
		List<Student> students = studentService.findStudentByName("毛泽东");
		for (Student student : students) {
			logger.info(student);
		}
		logger.info("findStudentByNameDaoTest success");
	}

	@Test
	public void findStudentByOnlineIdDaoTest() {
		List<Student> students = studentService.findStudentByOnlineId("散修弟子");
		for (Student student : students) {
			logger.info(student);
		}
		logger.info("findStudentByOnlineIdDaoTest success");
	}

	@Test
	public void getStudentListDaoTest() {
		List<Student> students = studentService.getStudentList();
		for (Student student : students) {
			logger.info(student);
		}
		logger.info("getStudentListDaoTest success");
	}

	@Test
	public void insertStudentDaoTest() {
		Student student = RandomStuUtil.getRandomStu();
		studentService.addStudent(student);
		logger.info("insertStudentDaoTest 插入id：" + student.getId() + "的数据成功");
	}

	@Test
	public void updateStudentDaoTest() {
		Student student = studentService.findStudentById(13039L);
		student.setName("赵云");
		logger.info("update功能测试结果：" + studentService.updateStudent(student));
	}

	@Test
	public void deleteStudentDaoTest() {

		logger.info("delete功能测试结果：" + studentService.deleteStudentById(14037L));
	}

}
