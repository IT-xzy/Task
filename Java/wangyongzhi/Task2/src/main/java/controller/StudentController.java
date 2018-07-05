package controller;

import model.Network1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import page.Page;
import service.NetworkService;
import sun.nio.ch.Net;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.interfaces.DSAKeyPairGenerator;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    NetworkService networkService;

    //列出查询到的全部学生数据，并且分页显示。
    @RequestMapping(value="/student",method=RequestMethod.GET)
    public ModelAndView listStudent(Page page){
        ModelAndView mav = new ModelAndView();
        List<Network1> studentList = networkService.selectAll(page);
        int total = networkService.total();

        page.caculateLast(total);
        // 使用mav将查找到的数据传到list.jsp里，再在jsp中动态获取数据
        mav.addObject("studentList", studentList);
        //第一个studentList是属性名，与jsp中的对应；第二个是属性值。
        // 放入jsp路径，设置返回的视图页面为listStudent.jsp。
        mav.setViewName("listStudent");
        return mav;
    }

    //增加一个学生信息的方法，一般都得提交表单数据。
    @RequestMapping(value="/student",method=RequestMethod.POST)
    //此处通过提交表单方式，用一个Network1对象接收所有传入数据，然后这个对象作为参数传入方法。
    public ModelAndView addStudent(Network1 student) {
        System.out.println(student.getLineId());
        System.out.println(student.getName());
        System.out.println(student.getQQ());
        System.out.println(student.getType());
        System.out.println(student.getEnrolmentTime());
        System.out.println(student.getGraduate());
        System.out.println(student.getReportLink());
        System.out.println(student.getWish());
        System.out.println(student.getSenior());
        System.out.println(student.getHowKnow());
        System.out.println(student.getCreateAt());
        System.out.println(student.getUpdateAt());

        networkService.insert(student);
        //跳转回student页面
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }
    //实现对应更新按钮，由@PathVariable获取提交链接中的数据，传递给方法中的参数,然后跳转至更新页。
    @RequestMapping(value="/student/{lineId}/profile", method=RequestMethod.GET)
    public ModelAndView editstudent(@PathVariable("lineId") long id) {
        Network1 student = new Network1();
        student.setLineId(id);
        student = networkService.selectByIdName(student);
        ModelAndView mav = new ModelAndView("editstudent");
        mav.addObject("student",student);
        return mav;
    }

    //完成更新的逻辑
    @RequestMapping(value="/student/{lineId}/student/{lineId}", method=RequestMethod.POST)
    public ModelAndView updatestudent(Network1 student) {
        networkService.update(student);
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }



    //实现对应删除按钮，由@PathVariable获取提交链接中的数据，传递给方法中的参数
    @RequestMapping(value="/student/{lineId}", method=RequestMethod.GET)
    public ModelAndView deletestudent(@PathVariable("lineId") long id) {
        networkService.deleteById(id);
        ModelAndView mav = new ModelAndView("redirect:/student");
        return mav;
    }



    @RequestMapping(value="student/select",method = RequestMethod.POST)
    public ModelAndView select(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        Network1 student = new Network1();
        student.setLineId(id);
        student = networkService.selectByIdName(student);
        ModelAndView mav = new ModelAndView("editstudent");
        mav.addObject("student",student);
        return mav;

    }


    /*
    //此处似乎无法直接把表单提交数据作为参数传递进入方法里。必须利用HttpServletRequest？
    @RequestMapping(value="student/select",method = RequestMethod.POST)
    public ModelAndView select(Long lineId) {
        Network1 student = new Network1();
        student.setLineId(lineId);
        System.out.println(student.getLineId());
        student = networkService.selectByIdName(student);
        ModelAndView mav = new ModelAndView("editstudent");
        mav.addObject("student",student);
        return mav;

    }
    */

    @RequestMapping(value="/login", method = RequestMethod.POST)
        public ModelAndView login(HttpServletRequest request){
        String username = request.getParameter("userid");
        String userpass = request.getParameter("userpass");
        if(username.equals("wyz1991") && userpass.equals("userpass"))
        {
            ModelAndView mav = new ModelAndView("redirect:/student");
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
