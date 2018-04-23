/**   
 * @Title: Mybatis_xmlTest.java 
 * @Package mybatis_xml 
 * @Description: TODO
 * @author detective
 * @date 2018年4月7日 下午11:27:43 
 * @version V1.0   
 */
package mybatis_xml;

import java.io.Reader;
import java.util.List;

import model.Student;
import mybatis_xml.dao.IStudent;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import util.RandomStuUtil;

/**
 * @ClassName: Mybatis_xmlTest
 * @Description: TODO
 * @author detective
 * @date 2018年4月7日 下午11:27:43
 * 
 */
public class Mybatis_xmlTest {

	/**
	 * @throws java.lang.Exception
	 */
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession session;
	private static IStudent studentMapper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reader = Resources
				.getResourceAsReader("mybatis_xml/config/Configure.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		session = sqlSessionFactory.openSession();
		studentMapper = session.getMapper(IStudent.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		session.close();

	}

	@Test
	public void testDel() {
		try {
			studentMapper.deleteStudent(14036L);
			session.commit();
			System.out.println("delete success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		try {
			studentMapper.insertStudent(RandomStuUtil.getRandomStu());
			session.commit();
			System.out.println("insert success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {

		try {
			Student student = studentMapper.getStudent(13036L);
			student.setName("毛泽东");
			studentMapper.updateStudent(student);
			session.commit();
			Assert.assertEquals(studentMapper.getStudent(13036L).getName(),
					"毛泽东");
			System.out.println("update success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQuery() {
		try {
			List<Student> students = studentMapper.getStudentList();
			System.out.println("in this db there is " + students.size()
					+ " records");
			System.out.println("query success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
