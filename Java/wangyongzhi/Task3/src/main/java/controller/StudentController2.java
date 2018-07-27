package controller;

import model.Network1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import page.Page;
import service.NetworkService;

import java.util.List;


@Controller
@RequestMapping("")
public class StudentController2 {

    @Autowired
    NetworkService networkService;

    @RequestMapping("listStudent2")
    public ModelAndView listStudent(Page page){
        ModelAndView mav = new ModelAndView();
        List<Network1> studentList = networkService.selectAll(page);
        int total = networkService.total();
        page.caculateLast(total);
        mav.addObject("studentList", studentList);
        mav.setViewName("listStudent2");
        return mav;
    }

    @RequestMapping("addStudent")
    public ModelAndView addStudent(Network1 student){

        networkService.insert(student);
        ModelAndView mav = new ModelAndView("redirect:/listStudent2");
        return mav;
    }

    @RequestMapping("deleteStudent")

    //注意，此处居然可以用student接受传递过来的参数，注意jsp页面和此处对应的地方
    public ModelAndView deleteStudent(Network1 student){

        networkService.deleteById(student.getLineId());
        ModelAndView mav = new ModelAndView("redirect:/listStudent2");
        return mav;

    }

    @RequestMapping("editStudent2")

    //注意，此处居然可以用student接受传递过来的参数，注意jsp页面和此处对应的地方
    public ModelAndView editStudent(Network1 student){
        student = networkService.selectByIdName(student);

        System.out.println(student.getName());
        ModelAndView mav = new ModelAndView("editStudent2");
        mav.addObject("student", student);
        return mav;

    }

    //为什么无法更改lineId
    @RequestMapping("updateStudent")
    public ModelAndView updateStudent(Network1 student){
        System.out.println(student.getName());
        networkService.update(student);
        System.out.println(student.getName());
        ModelAndView mav = new ModelAndView("redirect:/listStudent2");
        return mav;
    }

}
