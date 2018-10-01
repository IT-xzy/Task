package com.leo.controller;

import com.leo.pojo.Student;
import com.leo.service.StudentService;
import com.leo.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
	
	Logger logger = (Logger) LogManager.getLogger("mylog");
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/student",method= RequestMethod.GET)
	public ModelAndView listStudent(Page page){
		ModelAndView mav = new ModelAndView();
		// 调用service层方法获取数据
		List<Student> students = studentService.list(page);
		// 给Page类的实例变量last赋值
		int total = studentService.total();
		page.caculateLast(total);
		
		// 通过ModelAndView对象共享数据
		mav.addObject("students",students);
        // 设置视图
		mav.setViewName("listStudent");
		return mav;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public ModelAndView addStudent(Student student){
		ModelAndView mav = new ModelAndView("redirect:/student");
		studentService.add(student);
		logger.info("添加成功");
		return mav;
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteStudent(Student student){
		ModelAndView mav = new ModelAndView("redirect:/student");
		studentService.delete(student.getId());
		logger.info("删除成功");
		return mav;
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ModelAndView editStudent(Student s){
		ModelAndView mav = new ModelAndView("editStudent");
		Student student = studentService.get(s.getId());
		mav.addObject("student",student);
		return mav;
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.PUT)
	public ModelAndView updateStudent(Student student){
		ModelAndView mav = new ModelAndView("redirect:/student");
		studentService.update(student);
		logger.info("更新成功");
		return mav;
	}
}
