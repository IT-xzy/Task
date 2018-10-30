package com.java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void testAdd() {
		Category category = new Category();
		category.setId(5);
		category.setName("Category 5");
		int x=categoryMapper.add(category);
		if(x!=0) {
			System.out.println("添加成功");
		}
	}
	@Test
	public void testUpdate() {
		Category category = new Category();
		category.setId(3);
		category.setName("Category 4");
		int x=categoryMapper.update(category);
		if(x!=0) {
			System.out.println("更新成功");
		}
	}
	@Test
	public void testDelete() {
	int x=categoryMapper.delete(3);
	if(x!=0) {
		System.out.println("删除成功");
	}
	}
	@Test
	public void testGet() {
	categoryMapper.get(1);
	}
	@Test
	public void testList() {
		System.out.println(categoryMapper);
		List<Category> cs=categoryMapper.list();
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}

}
