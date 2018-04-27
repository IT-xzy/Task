/**   
 * @Title: JdbcTest.java 
 * @Package jdbc 
 * @Description: TODO
 * @author detective
 * @date 2018年4月6日 下午9:58:43 
 * @version V1.0   
 */
package jdbc;

import java.util.List;

import jdbc.dao.StudentDao;
import jdbc.dao.impl.StudentDaoImple;
import model.Student;
import util.RandomStuUtil;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * @ClassName: JdbcTest
 * @Description: TODO
 * @author detective
 * @date 2018年4月6日 下午9:58:43
 * 
 */
public class JdbcTest {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdd() {
		StudentDao studentDao = new StudentDaoImple();
		try {
			studentDao.addStudent(RandomStuUtil.getRandomStu());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		StudentDao studentDao = new StudentDaoImple();
		try {
			Student s = RandomStuUtil.getRandomStu();
			s.setId(13027L);
			studentDao.updateStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDel() {
		StudentDao studentDao = new StudentDaoImple();
		try {
			studentDao.delStudent(13027L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQuery() {
		StudentDao studentDao = new StudentDaoImple();
		try {
			List<Student> students = studentDao.query();
			System.out.println("in this db there is " + students.size()
					+ " records");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
