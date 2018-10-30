package com.java.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.java.pojo.Category;

public class JdbcTemplateDao implements Dao{
	 private ApplicationContext ctx= null;  
	    private JdbcTemplate jdbcTemplate = null;  
	    {  
	        ctx = new ClassPathXmlApplicationContext("bean.xml");  
	        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");  
	    }  
	public void Update(Category category) {
		// TODO 自动生成的方法存根
		String sql="update Category set name=? where id=?";
		 Object args[] = {category.getName(),category.getId()};  
         int x=jdbcTemplate.update(sql, args); 
         if(x!=0) {
        	 System.out.println("更新成功");
         }
	}

	public void Delete(int id) {
		// TODO 自动生成的方法存根
		 int x=jdbcTemplate.update("delete from Category where id=?", new Object[]{id});
		 if(x!=0) {
        	 System.out.println("删除成功");
         }
	}

	public void Insert(Category category) {
		// TODO 自动生成的方法存根
		String sql = "insert into Category values(?,?)";  
        Object args[] = {category.getId(),category.getName()};  
         int x=jdbcTemplate.update(sql, args);  
         if(x!=0) {
        	 System.out.println("添加成功");
         }
	}

	public void GetById(int id) {
		// TODO 自动生成的方法存根
		String sql = "select name from Category where id = ?";  
        Object args[] = new Object[]{id};  
        String  category = jdbcTemplate.queryForObject(sql,args,String.class);
        System.out.println(category);    
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Show() {
		// TODO 自动生成的方法存根
		String sql="select * from Category";
		List category=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Category.class));
		System.out.println(category);
	}

}
