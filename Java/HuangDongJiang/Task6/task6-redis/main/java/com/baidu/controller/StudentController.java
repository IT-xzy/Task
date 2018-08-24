package com.baidu.controller;

import com.baidu.pojo.Student;
import com.baidu.service.StudentService;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@Controller
public class StudentController{
	private static final Log log = LogFactory.getLog(StudentController.class);
	@Autowired
	private StudentService studentService;
	@Resource
	private Student student;
	static Logger logger = Logger.getLogger("StudentController.class");
	//主界面
	@RequestMapping("/index")
	public String indexController(){
		return "curd";
	}
	// 添加学生信息
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	public String addStudent(int id, String name, String school){
		student.setId(id);
		student.setName(name);
		student.setSchool(school);
		studentService.saveStudent(student);
		return "success";
	}
	// 删除学生信息
	@RequestMapping(value = "/student",method =RequestMethod.DELETE)
	public String deleteStudent(@RequestParam("id") int id) throws Exception {
		studentService.deleteStudentById(id);
		return "success";
	}
	// 更新学生信息
	@RequestMapping(value = "/student/infomation",method =RequestMethod.PUT)
	public String addStudent(@RequestParam("id") int id,@RequestParam("name") String name) throws Exception {
		student.setId(id);
		student.setName(name);
		studentService.updateStudent(student);
		return "success";
	}
	// 根据ID查找单个学生信息(测试json)
	@RequestMapping(value = "/student/id",method =RequestMethod.GET)
	public String findStudentToJson( int id,Model model) throws Exception {
		Student student1 = studentService.findStudentById(id);
		model.addAttribute("student",student1);
		model.addAttribute("code",111);
		model.addAttribute("message","正确返回");
		return "studentItem";
	}
	// 根据ID查找单个学生信息(测试jsp)
	@RequestMapping(value = "jsp/student/id",method =RequestMethod.GET)
	public String findStudentToJsp( int id,Model model) throws Exception {
		Student student1 = studentService.findStudentById(id);
		model.addAttribute("student",student1);
		model.addAttribute("code",111);
		model.addAttribute("message","正确返回");
		return "studentItemJsp";
	}
	// 查找所有学生信息
	@RequestMapping(value = "/allStudent",method =RequestMethod.GET)
	public String findAllStudent(Model model) throws InterruptedException, MemcachedException, TimeoutException {
		List<Student> studentList = studentService.findAllStudent();
		model.addAttribute("studentList",studentList);
		return "studentList";
	}
}
