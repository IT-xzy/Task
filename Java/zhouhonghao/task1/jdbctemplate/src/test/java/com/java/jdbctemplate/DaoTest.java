package com.java.jdbctemplate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.java.dao.JdbcTemplateDao;
import com.java.pojo.Category;

public class DaoTest {
JdbcTemplateDao jdbctemplate=new JdbcTemplateDao();
Log log=LogFactory.getLog(this.getClass());
	@Test
	public void testShow() {
		long time=System.currentTimeMillis();
		jdbctemplate.Show();
		time =System.currentTimeMillis()-time;
		log.info("total time:"+time);
	}

	@Test
	public void testUpdate() {
		Category c=new Category();
	c.setId(2);
	c.setName("category 6");
		jdbctemplate.Update(c);
	}

	@Test
	public void testDelete() {
		jdbctemplate.Delete(1);
	}

	
	@Test
	public void testInsert() {
		Category c=new Category();
		long time=System.currentTimeMillis();
	c.setId(5);
	c.setName("category "+5);
		jdbctemplate.Insert(c);
time=System.currentTimeMillis()-time;
jdbctemplate.Show();
log.info("total time:"+time);
		
		
	}

	@Test
	public void testGetById() {
		jdbctemplate.GetById(5);
	}

}
