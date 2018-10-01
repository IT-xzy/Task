package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Career;
import pojo.StudentStatus;
import service.CareerService;
import service.StudentStatusService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TilesController {
	@Resource(name = "studentStatusServiceImpl")
	private StudentStatusService studentStatusService;
	@Resource(name = "careerServiceImpl")
	private CareerService careerService;
	@RequestMapping("index")
	public String index(Model model) {
		int learningStudentCount = studentStatusService.queryLearningStudentCount();
		int workingStudentCount = studentStatusService.queryWorkingStudentCount();
		List<StudentStatus> listStudentStatus = studentStatusService.queryExcellentStudent();
		model.addAttribute("learningStudentCount",learningStudentCount);
		model.addAttribute("workingStudentCount",workingStudentCount);
		model.addAttribute("listStudentStatus",listStudentStatus);
		model.addAttribute("item","index");
		return "index";
	}
	@RequestMapping("/u/career")
	public String career(Model model) {
		List<Career> listCareer = careerService.queryCareerByName();
		model.addAttribute("listCareer",listCareer);
		model.addAttribute("item","career");
		return "career";
	}
}