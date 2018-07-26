package com.opt.controller;

import com.opt.model.Page;
import com.opt.model.Profession;
import com.opt.model.Student;
import com.opt.service.ProfessionService;
import com.opt.service.StudentService;
import com.opt.service.impl.ProfessionServiceImpl;
import com.opt.util.RandomStudent;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller 核心控制器 页面跳转
 *
 * @Title: 控制器
 * @Description: 接收url 进行主页相关处理
 * @author By.ZhangQiang(张强)
 * @date 2018-5-26
 */
@Controller
public class OptController {

    private static Logger logger = Logger.getLogger(OptController.class);

    RmiService rmiService = new RmiService();
    ProfessionService professionService = (ProfessionService) rmiService.getProfessionService();
    StudentService studentService = (StudentService) rmiService.getStudentService();

    @RequestMapping("/home")
    public String tiles(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Page<Student> pages = studentService.findByPage(2,4);

        String name = (String) session.getAttribute("username");

        if(name!=null){
            model.addAttribute("sessionname",name);
        }

        model.addAttribute("onlineTotal",session.getAttribute("onlineT"));
        model.addAttribute("students",pages.getPages());

        return "home";
    }

    @RequestMapping("/u/profession")
    public String profession(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Profession> pros = professionService.findAll();
        model.addAttribute("onlineT",session.getAttribute("onlineT"));
        model.addAttribute("pros",pros);
        return "profession";
    }


    @RequestMapping(value = "/stringfilter")
    public String tofilter(){
        return "stringfilter";
    }

    @RequestMapping(value = "/a/stringfilter",method = POST)
    public String filter(@RequestParam("note") String str, Model model, HttpServletRequest request, HttpServletResponse response){
        //response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String att = (String) request.getAttribute("note");
        model.addAttribute("fst",att);

        return "stringfilter";
    }

    @RequestMapping("/u/commend")
    public String tocommend(){
        logger.info("\ncommend");
        return "commend";
    }


    @RequestMapping("/s/ajax")
    public String ajax2(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/body/ajax.jsp").forward(request,response);

        return "ajax";
    }

    @ResponseBody
    @RequestMapping("/ajax")
    public Map ajax(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap();
        logger.info(request.getRequestURI());
        logger.info(request.getHeaderNames());

        map.put("ass","good good study");

        return map;
    }





}

