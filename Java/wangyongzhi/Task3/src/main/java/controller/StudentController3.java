package controller;

import model.Network1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import page.Page;
import service.NetworkService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller

@RequestMapping("")
public class StudentController3 {

    public static Logger logger = LogManager.getLogger("StudentController3.class");

    @Autowired
    NetworkService networkService;

    @RequestMapping(value="/listStudent3", method=RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        ModelAndView mav = new ModelAndView();
        List<Network1> studentList = networkService.selectAll(page);
        int total = networkService.total();
        page.caculateLast(total);
        mav.addObject("studentList", studentList);
        mav.setViewName("listStudent3");
        return mav;
    }


    @RequestMapping(value="/listStudent3", method=RequestMethod.PUT)
    public ModelAndView addStudent(Network1 student){
        System.out.println(student.getName());

        networkService.insert(student);
        ModelAndView mav = new ModelAndView("redirect:/listStudent3");
        return mav;
    }


    @RequestMapping(value="/listStudent3/{lineId}", method=RequestMethod.DELETE)

    //注意，此处居然可以用student接受传递过来的参数，注意jsp页面和此处对应的地方
    public ModelAndView deleteStudent(Network1 student){

        networkService.deleteById(student.getLineId());
        ModelAndView mav = new ModelAndView("redirect:/listStudent3");
        return mav;

    }

    //再次严重注意传参
    @RequestMapping(value="/listStudent3/{lineId}", method=RequestMethod.GET)

    //注意，此处居然可以用student接受传递过来的参数，注意jsp页面和此处对应的地方
    public ModelAndView editStudent(Network1 student){
        student = networkService.selectByIdName(student);

        System.out.println(student.getName());
        ModelAndView mav = new ModelAndView("editStudent3");
        mav.addObject("student", student);
        return mav;

    }

    //根据单个id查询学生信息
    @RequestMapping(value="/editStudent3", method=RequestMethod.POST)

    //注意，此处居然可以用student接受传递过来的参数，注意jsp页面和此处对应的地方
    public ModelAndView selectStudent(Network1 student){
        student = networkService.selectByIdName(student);

        System.out.println(student.getName());
        ModelAndView mav = new ModelAndView("editStudent3");
        mav.addObject("student", student);
        return mav;

    }

    //为什么无法更改lineId
    @RequestMapping(value="/listStudent3/{lineId}", method=RequestMethod.POST)
    public ModelAndView updateStudent(Network1 student){
        System.out.println(student.getName());
        networkService.update(student);
        System.out.println(student.getName());
        ModelAndView mav = new ModelAndView("redirect:/listStudent3");
        return mav;
    }

    @RequestMapping(value = "/jsontest", method = RequestMethod.GET)
    public String json(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        list.add("李恪非");
        list.add("王庸之");
        list.add("郭超");
        modelMap.addAttribute("list", list);
        return "jsontest";
    }


    //登录界面
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        String username = request.getParameter("userid");
        String userpass = request.getParameter("userpass");
        if(username.equals("wyz1991") && userpass.equals("userpass"))
        {
            ModelAndView mav = new ModelAndView("redirect:/listStudent3");
            return mav;

        }
        else {
            ModelAndView mav = new ModelAndView("redirect:/main");
            return mav;
        }
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

}