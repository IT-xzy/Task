package com.jns.service.impl;

import com.jns.entity.Page;
import com.jns.mapper.StudentMapper;
import com.jns.entity.Student;
import com.jns.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
	/**
	 *
	 */
	//调用dao层的方法，来实现service层接口的方法。

	//@autowired相当于默认的getter()和setter();
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public void add(Student student) {
		// TODO 自动生成的方法存根
		studentMapper.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		studentMapper.delete(id);
	}

	@Override
	public Student get(int id) {
		// TODO 自动生成的方法存根
		return studentMapper.get(id);
	}

	@Override
	public void update(Student student) {
		// TODO 自动生成的方法存根
		studentMapper.update(student);
	}

	@Override
	public List<Student> list() {
		// TODO 自动生成的方法存根
		return studentMapper.list();
	}

	@Override
	public int total() {
		return studentMapper.total();
	}

	@Override
	public Page<Student> showByPage(int currPage) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		//page类中的page<T>。
		Page<Student> page=new Page<Student>();
		page.setCurrPage(currPage);
		//取出总的记录数，赋值给page的属性
		int total=studentMapper.total();
		page.setTotalCount(total);
		int totalPage;
		if(total % page.getPageSize()==0){
			totalPage=total/page.getPageSize();
		}else{
			totalPage=total/page.getPageSize()+1;
		}
		//page总页数赋值
		page.setTotalPage(totalPage);
		map.put("start",(currPage-1)*page.getPageSize());//对应sql语句中的start
		map.put("size",page.getPageSize()); //对应sql语句中的size
		//每页数据
		List<Student> list=studentMapper.findByPage(map);
		page.setList(list);
		return page;
	}

}
