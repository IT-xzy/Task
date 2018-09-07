package com.baidu.task8.controller;

import com.baidu.task8.pojo.Student;
import com.baidu.task8.service.RandomService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
	private static final Log log = LogFactory.getLog(StudentController.class);
	//主界面
	@RequestMapping("/index")
	public String indexController(){
		log.info("进入增删该查页面...");
		return "curd";
	}
	// 添加学生信息
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	public String addStudent(int id, String name, String school){
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setSchool(school);
		RandomService.getRandomService().saveStudent(student);
		return "success";
	}
	// 删除学生信息
	@RequestMapping(value = "/student",method =RequestMethod.DELETE)
	public String deleteStudent(@RequestParam("id") int id){
		RandomService.getRandomService().deleteStudentById(id);
		return "success";
	}
	// 更新学生信息
	@RequestMapping(value = "/student/infomation",method =RequestMethod.PUT)
	public String addStudent(@RequestParam("id") int id,@RequestParam("name") String name){
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		RandomService.getRandomService().updateStudent(student);
		return "success";
	}
	// 根据ID查找单个学生信息
	@RequestMapping(value = "/student/id",method =RequestMethod.GET)
	public String findStudent(@RequestParam("id") int id,Model model){
		Student student1 =  RandomService.getRandomService().findStudentById(id);
		model.addAttribute("student",student1);
		model.addAttribute("code",111);
		model.addAttribute("message","正确返回");
		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		model.addAttribute("studentList",studentList);
		return "studentItem";
	}
	// 查找所有学生信息
	@RequestMapping(value = "/allStudent",method =RequestMethod.GET)
	public String findAllStudent(Model model){
		List<Student> studentList = RandomService.getRandomService().findAllStudent();
		model.addAttribute("studentList",studentList);
		return "studentList";
	}
}
