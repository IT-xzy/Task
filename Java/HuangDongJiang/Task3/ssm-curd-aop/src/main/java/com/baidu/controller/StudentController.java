package com.baidu.controller;

import com.baidu.pojo.Student;
import com.baidu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class StudentController{
	@Autowired
	private StudentService studentService;
	@Resource
	private Student student;
	static Logger logger = Logger.getLogger("StudentController.class");
	//主界面
	@RequestMapping("/")
	public String indexController(){
		return "curd";
	}
	// 添加学生信息
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	public String addStudent(@RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("school") String school){
		student.setId(id);
		student.setName(name);
		student.setSchool(school);
		studentService.saveStudent(student);
		return "curd";
	}
	// 删除学生信息
	@RequestMapping(value = "/student",method =RequestMethod.DELETE)
	public String deleteStudent(@RequestParam("id") int id){
		studentService.deleteStudentById(id);
		return "curd";
	}
	// 更新学生信息
	@RequestMapping(value = "/student/infomation",method =RequestMethod.PUT)
	public String addStudent(@RequestParam("id") int id,@RequestParam("name") String name){
		student.setId(id);
		student.setName(name);
		studentService.updateStudent(student);
		return "curd";
	}
	// 根据ID查找单个学生信息
	@RequestMapping(value = "/student/id",method =RequestMethod.GET)
	public String findStudent(@RequestParam("id") int id,Model model){
		Student student1 = studentService.findStudentById(id);
		model.addAttribute("student",student1);
		model.addAttribute("code",111);
		model.addAttribute("message","正确返回");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		model.addAttribute("studentList",studentList);
		return "studentItem";
	}
	// 查找所有学生信息
	@RequestMapping(value = "/allStudent",method =RequestMethod.GET)
	public String findAllStudent(Model model){
		List<Student> studentList = studentService.findAllStudent();
		model.addAttribute("studentList",studentList);
		return "studentList";
	}
}
