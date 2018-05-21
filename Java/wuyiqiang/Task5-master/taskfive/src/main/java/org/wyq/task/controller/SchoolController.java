package org.wyq.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wyq.task.md5.MD5;
import org.wyq.task.pojo.Profession;
import org.wyq.task.pojo.Salary;
import org.wyq.task.pojo.Students;
import org.wyq.task.service.BaseService;
import org.wyq.task.token.JwtToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private BaseService schoolService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Students> list = schoolService.selectStudentsByEvaluate();
        Integer graduated = schoolService.countStudentsByStatus(2);
        Integer count = schoolService.countStudentsByStatus(1) + graduated;
        mav.addObject("students", list);
        mav.addObject("count", count);
        mav.addObject("graduated", graduated);
//        mav.addObject("dateTag", System.currentTimeMillis());
//        mav.setViewName("index");
        mav.setViewName("tiles_index");
        return mav;
    }

    @RequestMapping("/u/profession")
    public ModelAndView profession() {
        ModelAndView mav = new ModelAndView();
        List<String> directionCategoryList = schoolService.directionCategoryList();
        List<Profession> professionList = schoolService.selectProfessionAll();
        List<Salary> salaryList = schoolService.selecSalarytAll();
        List<Students> studentsList = schoolService.selectStudentsAll();

        Map countStudents = new HashMap();
        for (Students s : studentsList) {
            countStudents.put(s.getProfession(), schoolService.countStudentsByProfession(s.getProfession()));
        }

//        List<Profession> frontAnd = schoolService.selectProfessionByDirection("前端开发");
//        List<Profession> backAnd = schoolService.selectProfessionByDirection("后端开发");
//        List<Profession> mobile = schoolService.selectProfessionByDirection("移动开发");
//        List<Profession> wholePoint = schoolService.selectProfessionByDirection("整站开发");
//        List<Profession> operationAndMaintenance = schoolService.selectProfessionByDirection("运营维护");
//        professionList.add(frontAnd);
//        professionList.add(backAnd);
//        professionList.add(mobile);
//        professionList.add(wholePoint);
//        professionList.add(operationAndMaintenance);
//        List<Salary> salaryList = schoolService.selecSalarytAll();

        mav.addObject("directionCategoryList", directionCategoryList);
        mav.addObject("professionList", professionList);
        mav.addObject("salaryList", salaryList);
        mav.addObject("countStudents", countStudents);
        mav.addObject("dateTag", System.currentTimeMillis());
//        mav.setViewName("profession");
        mav.setViewName("tiles_profession");
        return mav;
    }

    @RequestMapping("/sign_in")
    public String signIn() {
        return "tiles_index_sign_in";
    }

    @RequestMapping("/sign_out")
    public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                c.setMaxAge(0);
                c.setValue(null);
                response.addCookie(c);
            }
        }
        return new ModelAndView("redirect:/school/index");//带着response跳转
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView Check(@RequestParam("id") Integer id, @RequestParam("password") String password, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        boolean check = false;
        String name = null;
        if (null != id && null != password && "" != id.toString() && "" != password) {
            String md = MD5.getResult(password);
//            System.out.println(md);
            check = schoolService.check(id, md);
        }
        if (check) {
            try {
                name = schoolService.selectStudentNameById(id);
                String Token = JwtToken.createToken(id, name, System.currentTimeMillis());
                Cookie cookie = new Cookie("token", Token);
                cookie.setMaxAge(5 * 60);//秒
                response.addCookie(cookie);
//                System.out.println(Token);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mav.addObject("name", name);
        mav.addObject("check", check);
        mav.setViewName("checking");
        return mav;
    }
}
