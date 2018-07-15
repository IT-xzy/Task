package controller;

import model.StuInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProfService;
import service.StuInfoService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class StuInfoController {

    public static Logger logger = LogManager.getLogger("StudentController3.class");

    @Autowired
    StuInfoService stuInfoService;
    @Autowired
    ProfService profService;

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView listStudent() {
        ModelAndView mav = new ModelAndView();
        StuInfo stu = new StuInfo();
        stu.setStatus("在学");
        int countstudy = stuInfoService.selectStudyWork(stu);
        stu.setStatus("工作");
        int countwork = stuInfoService.selectStudyWork(stu);
        mav.addObject("countwork", countwork);
        mav.addObject("countstudy", countstudy);

        StuInfo one = new StuInfo();
        StuInfo two = new StuInfo();
        StuInfo three = new StuInfo();
        StuInfo four = new StuInfo();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        four.setId(4);
        one = stuInfoService.getById(one);
        two = stuInfoService.getById(two);
        three = stuInfoService.getById(three);
        four = stuInfoService.getById(four);
        mav.addObject("one", one);
        mav.addObject("two", two);
        mav.addObject("three", three);
        mav.addObject("four", four);
        mav.setViewName("homepage");
        return mav;
    }

    @RequestMapping(value="/profession", method = RequestMethod.GET)
    public ModelAndView listProf() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("prof", profService.getByProf("java后端工程师"));
        mav.setViewName("profession");
        return mav;
    }

    @RequestMapping(value="/test")
    public String testView() {
        return "layout";//这里的myView为layout.xml中配置的视图名称，根据返回值，去匹配对应的jsp页
    }

    //登录界面
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        String username = request.getParameter("userid");
        String userpass = request.getParameter("userpass");
        if(username.equals("wyz1991") && userpass.equals("userpass"))
        {
            ModelAndView mav = new ModelAndView("redirect:/homepage");
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
