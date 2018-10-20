package com.jns.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jns.pojo.Student;
import com.jns.service.StudentService;
import com.jns.utils.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
	Log log=LogFactory.getLog(StudentController.class);
	@Autowired
     StudentService studentService;

	@RequestMapping(value="/student",method=RequestMethod.GET)
	public ModelAndView listStudent(Page page) {
		log.info("查询所有:");
		ModelAndView modelAndView=new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 5);
		List<Student> students=studentService.list();
		int total=(int) new PageInfo<>(students).getTotal();
		page.caculateLast(total);
		modelAndView.addObject("ss", students);
		modelAndView.setViewName("student/listStudent");
		return modelAndView;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.PUT)
	public ModelAndView addStudent(Student student) {
		studentService.add(student);
		log.info("添加操作："+student);
		ModelAndView modelAndView=new ModelAndView("redirect:/student");
		return modelAndView;
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteStudent(Student student) {
		log.info("删除操作:"+student.getId());
		studentService.delete(student.getId());
		ModelAndView modelAndView=new ModelAndView("redirect:/student");
		return modelAndView;	
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.GET)
	public ModelAndView editStudent(Student student) {
		log.info("编辑操作:");
		Student student2= studentService.get(student.getId());
		ModelAndView modelAndView=new ModelAndView("student/editStudent");
		modelAndView.addObject("c", student2);
		return modelAndView;
	}
	
	@RequestMapping(value="/student/{id}",method=RequestMethod.POST)
	public ModelAndView updateStudent(Student student) {
		log.info("更新操作:"+student);
		studentService.update(student);
		log.debug("更新后的学生信息："+student);
		ModelAndView modelAndView=new ModelAndView("redirect:/student");
		return modelAndView;
	}

}
