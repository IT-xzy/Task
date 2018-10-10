package com.jns.controller;

import com.danga.MemCached.MemCachedClient;
import com.jns.entity.Page;
import com.jns.entity.Student;
import com.jns.service.StudentService;
import com.jns.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/u")
public class StudentController {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	//创建一个memcached客户端，所有对memcached中数据操作的方法都在这个类里面
	MemCachedClient memCachedClient= (MemCachedClient) applicationContext.getBean("memCachedClient");
	RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisUtil");
	Logger logger= LoggerFactory.getLogger(StudentController.class);


	@Autowired
	StudentService studentService;
    boolean update=false;


    //展示所有数据
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public ModelAndView listStudent(@RequestParam(value = "currPage",defaultValue = "1",required = true) int currPage) {
		//memcache方法
		//Page<Student> page= (Page<Student>) memCachedClient.get("studentList"+currPage);
		//if(page!=null && update==false){
		//	logger.info("使用memcache缓存");
		//}else{
		//	page=studentService.showByPage(currPage);
		//	memCachedClient.set("studentList"+currPage,page);
		//}
		//redis方法
		//Page<Student> page= (Page<Student>) redisUtil.get("studentList"+currPage);
		//if(page!=null && update==false){
		//}else{
		//	page=studentService.showByPage(currPage);
		//	redisUtil.set("studentList"+currPage,page);
		//}

		//分页不用插件，根据页码，来搜索数据。
		//nocache方法
		Page<Student> page=studentService.showByPage(currPage);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("ss", page);
		modelAndView.setViewName("listStudent");
		return modelAndView;
	}


	//登记页面
	@RequestMapping(value = "/student",method=RequestMethod.GET)
	public  String toAddStudent(){
		return "addStudent";
	}


	//添加
	@RequestMapping(value="/student",method=RequestMethod.PUT)
	public ModelAndView addStudent(Student student) {
			studentService.add(student);
		//update=true;
		//int total=studentService.total();
		//logger.info("total:{}",total);
		//int divide=total / 10;
		//int mod=total % 10;
		//if(divide >= 1) {
		//	if (mod == 0) {
		//		logger.info("页码：{}",(mod + 1 + divide * 10));
		//		//memCachedClient.set("studentList" + (mod + 1 + divide * 10), studentService.showByPage(mod + 1 + divide * 10));
		//		redisUtil.set("studentList" + (mod + 1 + divide * 10), studentService.showByPage(mod  + divide * 10));
		//	} else {
		//		//memCachedClient.set("studentList" + (mod + divide * 10), studentService.showByPage(mod + divide * 10));
		//		redisUtil.set("studentList" + (mod +  divide * 10), studentService.showByPage(mod + divide *10));
		//	}
		//}else{
		//	if (mod == 0) {
		//		//memCachedClient.set("studentList" + (mod + 1 ), studentService.showByPage(mod + 1 ));
		//		redisUtil.set("studentList" + (mod + 1 ), studentService.showByPage(mod ));
		//	} else {
		//		//memCachedClient.set("studentList" + (mod), studentService.showByPage(mod ));
		//		redisUtil.set("studentList" + (mod ), studentService.showByPage(mod ));
		//	}
		//}
		//logger.info("添加操作：{}",student);
		return new ModelAndView("redirect:/u/students");
	}


	//删除
	@RequestMapping(value="/students/{currPage}/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteStudent(@PathVariable(value = "currPage")int currPage, Student student) {
		logger.info("删除操作:{}",student.getId());
		studentService.delete(student.getId());
		//redisUtil.set("studentList"+currPage,studentService.showByPage(currPage));
		//memCachedClient.set("studentList"+currPage,studentService.showByPage(currPage));
		update=true;
		return new ModelAndView("redirect:/u/students");
	}


	//编辑页面
	@RequestMapping(value="/students/{currPage}/{id}",method=RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable(value = "currPage")int currPage, Student student) {
		logger.info("编辑操作:");
		Student student2= studentService.get(student.getId());
		ModelAndView modelAndView=new ModelAndView("editStudent");
		modelAndView.addObject("c", student2);
		modelAndView.addObject("nowPage",currPage);
		return modelAndView;
	}


	//更新
	@RequestMapping(value="/students/{currPage}/{id}",method=RequestMethod.POST)
	public ModelAndView updateStudent(@PathVariable(value = "currPage")int currPage,Student student) {
		studentService.update(student);
		//redisUtil.set("studentList"+currPage,studentService.showByPage(currPage));
		//memCachedClient.set("studentList"+currPage,studentService.showByPage(currPage));
		update=true;
		return new ModelAndView("redirect:/u/students");
	}
}
