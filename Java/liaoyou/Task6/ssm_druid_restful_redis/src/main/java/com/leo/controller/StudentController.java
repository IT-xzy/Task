package com.leo.controller;

import com.leo.pojo.Student;
import com.leo.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
	
	Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Autowired
	StudentService studentService;
	
	// @ResponseBody:此注解完成返回对象到json数据的转换
	@ResponseBody
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public List<Student> listStudent(){
		// 因为没有jsp页面，所以没有使用分页展示
		List<Student> students = studentService.list();
		logger.info("OK");
		return students;
	}
	
	// @RequestBody:此注解用来接收前台传来的json数据（在此例中），此注解需要http使用post方法
	@ResponseBody
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String addStudent(@RequestBody Student student){
		studentService.add(student);
		logger.info("添加成功");
		return "add OK";
	}
	
	// @PathVariable:此注解可以将url路径中传过来的值绑定到方法的参数上
	// 可以写成 @PathVariable long id ；也可以 @PathVariable("id") long id   （当有多个值时使用后者）
	@ResponseBody
	@RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable long id){
		studentService.delete(id);
		logger.info("删除id为 "+id+" 记录成功");
		return "delete OK";
	}
	
	@ResponseBody
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable long id){
		Student student = studentService.get(id);
		logger.info("已查询id为 "+id+" 的记录");
		return student;
	}
	
/*
	使用 @RequestParam 获取请求参数区数据
	本例中是使用此注解从 http://127.0.0.1:8080/student?id=15  中获取id的值 15
	使用此注解时不能与上面 getStudent()与listStudent() 这两个方法同在
	
	@ResponseBody
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public Student getStudent(@RequestParam long id){
		Student student = studentService.get(id);
		logger.info("已查询id为 "+id+" 的记录");
		return student;
	}
	
*/
	
	// 方法中接收了两个参数，URL路径中的和body中
	@ResponseBody
	@RequestMapping(value="/student/{id}", method=RequestMethod.PUT)
	public String updateStudent(@PathVariable long id, @RequestBody Student student){
		// 进行更新操作时一定要对数据模型设置id，因为在使用SQL语句更新时有一个id参数
		student.setId(id);
		studentService.update(student);
		logger.info(student);
		logger.info("已更新id为 "+id+" 的记录");
		return "update OK";
	}
}
