package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Career;
import pojo.StudentStatus;
import service.CareerService;
import service.StudentStatusService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {
	@Resource(name = "studentStatusServiceImpl")
	private StudentStatusService studentStatusService;
	@Resource(name = "careerServiceImpl")
	private CareerService careerService;
	@RequestMapping(value = "index",method =RequestMethod.GET)
	public String index(Model model) {
		int learningStudentCount = studentStatusService.queryLearningStudentCount();
		int workingStudentCount = studentStatusService.queryWorkingStudentCount("工作");
		List<StudentStatus> listStudentStatus = studentStatusService.queryExcellentStudent();
		model.addAttribute("learningStudentCount",learningStudentCount);
		model.addAttribute("workingStudentCount",workingStudentCount);
		model.addAttribute("listStudentStatus",listStudentStatus);
		model.addAttribute("item","index");
		return "index";
	}
	@RequestMapping(value = "career", method = RequestMethod.GET)
	public String career(Model model) {
		List<Career> listCareer = careerService.queryCareerByName();
		model.addAttribute("listCareer",listCareer);
		model.addAttribute("item","career");
		return "career";
	}
}