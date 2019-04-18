package com.jnshu.controller;

import com.jnshu.pojo.Student;
import com.jnshu.pojo.tool.DesUtil;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 7:25
 */
@Controller
public class StudentController {
    private static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        List<Student> students =studentService.getAll();
        logger.info(students.toString());
        Cookie[] cookies= request.getCookies ();
        String token = null;
        ModelAndView mav =new ModelAndView("home");
        for (Cookie cookie : cookies){
            switch (cookie.getName()){
                case "token":
                    token = cookie.getValue();
                    token = DesUtil.decrypt(token);
            }
        }
        if(token != null) {
            String[] mw = token.split("\\|");
            String name = mw[1];
            logger.info("name1:" + mw[1]);
            mav.addObject("students",students);
            mav.addObject("name",name);
        }
        return mav;
    }
}
