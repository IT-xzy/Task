package lujing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lujing.pojo.StudentCustom;
import lujing.service.StudentService;

@Controller
@RequestMapping("/student")


public class StudentController {

	@Autowired
	private StudentService studentService;

	//跳转到新增页面
	@RequestMapping(value = "/newpage", method = RequestMethod.GET)
	public String addstudent(Model model,StudentCustom studentCustom) {
		studentCustom = studentService.findStudentById(218547);
		model.addAttribute("studentCustom", studentCustom);
		return "student/addstudent";
	}
	
	
	// 提交新增学生信息，value是url地址，设置request的方法
	@RequestMapping(value = "/studentOne", method = RequestMethod.POST)
	public String addStudentSubmit(StudentCustom studentCustom) {
		
		studentService.addStudent(studentCustom);
		return "redirect:studentslist";
	}

	// 显示所有学生列表
	@RequestMapping(value = "/studentslist", method = RequestMethod.GET)
	public ModelAndView queryStudent() {
		ModelAndView modelAndView = new ModelAndView();
		List<StudentCustom> studentlist = studentService.findStudentList(null);

		modelAndView.addObject("studentlist", studentlist);
		// 将模型数据填充到视图，逻辑视图名
		modelAndView.setViewName("student/studentlist");
		return modelAndView;
	}

	// 点击修改按钮，跳转到修改页面，并查询id对应的学生信息填充到表单中
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public String editstudent(Model model, @PathVariable("id") Integer id) {
		StudentCustom studentCustom = studentService.findStudentById(id);
		model.addAttribute("student", studentCustom);
		// 返回字符串类型，字符串为jsp页面的逻辑视图名
		return "student/editstudent";
	}
	
	//修改提交
	@RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
	public String editStudentSubmit(@PathVariable("id") Integer id,StudentCustom studentCustom){
		
		studentService.updateStudent(id, studentCustom);
		return "redirect:studentslist";
		
	}

//	删除按钮，执行删除学生方法
	
	/**
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return "redirect:studentslist";
	}

	
}
