package com.fml.controller;

import com.fml.pojo.Student;
import com.fml.pojo.Vocation;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;
    @Autowired
    VocationService vocationService;

    /**
     * 访问主页
     * @param model
     * @return
     */
    @RequestMapping(value = "home")
    public String homeView(Model model){
        int workCount = studentService.getWorkCount();
        int totalCount = studentService.getTotalCount();
        model.addAttribute("workCount",workCount);
        model.addAttribute("totalCount",totalCount);

        /*优秀学员*/
        List<Student> studentList = studentService.getByStatus();
        List<Student> list = new ArrayList<>(4);
        for (int i = 0; i < 4; i++){
            list.add(studentList.get(i));
        }
        model.addAttribute("list",list);
        return "home";
    }

    /**
     * 职业信息页
     * @param model
     * @return
     */
    @RequestMapping("vocation")
    public String vocationView(Model model){
        /*各个课程的学习人数*/
        List<Integer> lessonList = studentService.getStudentByLesson();
        model.addAttribute("integerList",lessonList);

        /*职业的相关信息，工作年限和薪水没做，按写死的来*/
        List<Vocation> list = vocationService.getAllVocation();
        model.addAttribute("list",list);

        return "vocation";
    }

    /**
     * 合作网站页
     * @return
     */
    @RequestMapping(value = "cooperation",method = RequestMethod.GET)
    public String cooperationView(){
        return "cooperation";
    }
}
