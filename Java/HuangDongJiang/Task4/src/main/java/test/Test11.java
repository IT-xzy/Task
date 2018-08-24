package test;

import dao.StudentStatusMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import pojo.StudentStatus;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Test11 {
	@Resource
	private StudentStatusMapper studentStatusMapper;
	@Test
	public void test() throws UnsupportedEncodingException {
        int num =  studentStatusMapper.queryWorkingStudentCount("工作");
		System.out.println(num);
	}
}
