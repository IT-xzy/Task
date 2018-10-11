package com.java.jdbctemplate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.java.pojo.Category;

public class APP {
	
	static Log log=LogFactory.getLog(APP.class);
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");  
    static JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");  
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
long time=System.currentTimeMillis();
//sert();//插入数据
show();//搜索所有数据
//getById();//id搜索
//delete();//删除数据
//update();//更新数据
time=System.currentTimeMillis()-time;
log.info("total time:"+time);
	}

	private static void update() {
		// TODO 自动生成的方法存根
		String sql="update Category set name=? where id=?";
		 Object args[] = {"updatecategory",2}; 
        int x=jdbcTemplate.update(sql, args); 
        if(x!=0) {
        	System.out.println("更新成功");
        }
	}

	private static void delete() {
		// TODO 自动生成的方法存根
		 int x=jdbcTemplate.update("delete from Category where id=?", new Object[]{2});
		  if(x!=0) {
	        	System.out.println("删除成功");
	        }
	}

	private static void getById() {
		// TODO 自动生成的方法存根
		String sql = "select name from Category where id = ?";  
        Object args[] = new Object[]{2};  
        String  category = jdbcTemplate.queryForObject(sql,args,String.class);
        System.out.println(category);    
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void show() {
		// TODO 自动生成的方法存根
		String sql="select * from Category";
		List category=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Category.class));
		System.out.println(category);
	}

	private static void sert() {
		// TODO 自动生成的方法存根
		String sql = "insert into Category values(?,?)";  
		Object args1[] = {2,"category2"};  
		int x=jdbcTemplate.update(sql, args1);
		  if(x!=0) {
	        	System.out.println("添加成功");
	        }
	}

}
