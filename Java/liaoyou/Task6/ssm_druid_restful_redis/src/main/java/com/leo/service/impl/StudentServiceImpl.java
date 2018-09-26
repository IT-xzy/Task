package com.leo.service.impl;

import com.leo.mapper.StudentMapper;
import com.leo.pojo.Student;
import com.leo.service.StudentService;
import com.leo.utils.Page;
import com.leo.utils.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LogManager.getLogger("mylog");
	
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	RedisUtil redisUtil;
	
	@Override
	public void add(Student student) {
		student.setCreate_time(System.currentTimeMillis());
		student.setUpdate_time(System.currentTimeMillis());
		int flag = studentMapper.add(student);
		if (flag == 1){
			// 更新所有缓存数据
			redisUtil.deleteListValue("studentAll");
			redisUtil.deleteListValue("studentPage");
			redisUtil.deleteStringValue("total");
		} else {
			logger.error("添加数据失败");
		}
	}

	@Override
	public void delete(long id) {
		redisUtil.deleteHashValue("student",String.valueOf(id));
		int flag = studentMapper.delete(id);
		if (flag == 1){
			// 更新所有缓存数据
			redisUtil.deleteListValue("studentAll");
			redisUtil.deleteListValue("studentPage");
			redisUtil.deleteStringValue("total");
		} else {
			logger.error("删除记录失败");
		}
	}

	@Override
	public Student get(long id) {
		// 首先查询缓存
		Object object = redisUtil.getHashValue("student",String.valueOf(id));
		if (object != null){
			logger.info("从缓存中取出,ID="+id);
			return (Student)object;
		}
		// 若缓存中没有则到数据库中查询
		Student student = studentMapper.get(id);
		// 添加数据到缓存中，为避免脏读，缓存只在读取时添加
		redisUtil.setHashValue("student",String.valueOf(id),student);
		return student;
	}

	@Override
	public void update(Student student) {
		student.setUpdate_time(System.currentTimeMillis());
		int flag = studentMapper.update(student);
		
		// 更新时只删除原缓存，不设置新缓存
		if (flag==1){
			// 删除单条缓存记录
			redisUtil.deleteHashValue("student",student.getId());
			// 删除List集合缓存
			redisUtil.deleteListValue("studentAll");
			redisUtil.deleteListValue("studentPage");
			logger.info("已删除原有缓存记录");
		}
	}
	
	@Override
	public List<Student> list() {
		// 首先查询缓存
		Object object = redisUtil.getListValue("studentAll");
		
		if (object != null){
			logger.info("studentAll缓存输出");
			return (List<Student>) object;
		}
		
		List<Student> students = studentMapper.list();
		redisUtil.setListValue("studentAll",students);
		
		return students;
	}
	
	@Override
	public List<Student> list(Page page) {
		Object object = redisUtil.getListValue("studentPage");
		if (object != null){
			logger.info("studentPage缓存输出");
			return (List<Student>) object;
		}
		
		List<Student> studentPage = studentMapper.list(page);
		redisUtil.setListValue("studentPage",studentPage);
		return studentPage;
	}
	
	@Override
	public int total() {
		Object object = redisUtil.getStringValue("total");
		if (object != null){
			logger.info("total从缓存中取出");
			return (int) object;
		}
		int total = studentMapper.total();
		redisUtil.setStringValue("total",String.valueOf(total));
		return total;
	}
}
