package com.jns.controller;

import com.jns.pojo.Student;
import com.jns.service.CourseService;
import com.jns.service.RmiService;
import com.jns.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import util.JWTUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  主页 登陆 退出登陆
 */
@Controller
public class StudentLoginController {

//    @Autowired
//    @Qualifier("studentRMIClientOne")
//    StudentService studentService;

    @Autowired
    RmiService rmiService;



    /**
     * @return
     * @Description 跳转至主页
     * @Param
     **/
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView("homePage");
        int allstu =rmiService.getStudentService().countAll();
        int jobNum = rmiService.getStudentService().countJob();
        modelAndView.addObject("allstu", allstu);
        modelAndView.addObject("jobNum", jobNum);
//        优秀学员展示
        List<Student> goodlist = null;
        goodlist = rmiService.getStudentService().findGood();
//        随机展示一个优秀学员
//        int index1=(int)(Math.random()*goodlist.size());
//        Student student1 = (Student) goodlist.get(index1);
//        modelAndView.addObject("good1",student1);
//        随机展示四个优秀学员
        Random random = new Random();
        List<Integer> tempList = new ArrayList<Integer>();
        List<Student> newList = new ArrayList<Student>();
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp = random.nextInt(goodlist.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(goodlist.get(temp));
            } else {
                i--;
            }
        }
        modelAndView.addObject("newlist", newList);

        return modelAndView;
    }
    /**
     * @return 登陆页面
     * @Description 首页转入登陆页面
     * @Param
     **/
    @RequestMapping("/loginBegin")
    public ModelAndView loginBegin() {
        ModelAndView mv = new ModelAndView("loginpage");
        return mv;

    }

    /**
     * @return 成功页面 或 原页面
     * @Description 用户登陆判断
     * @Param 学生姓名 密码
     **/
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public ModelAndView loginStudent(String stuName, String passWord, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        Student student =rmiService.getStudentService().selectStuName(stuName);
        // 判断用户名或账号密码是否为空 为空返回原页面
        if (stuName == null | passWord == null) {
            mv.setViewName("error");
            mv.addObject("exception", "账号密码不可为空");
            return mv;

            //判断用户名是否存在，不存在提示注册
        }
        if (student == null) {
            mv.setViewName("error");
            mv.addObject("exception", "账号不存在，请注册");
            return mv;

            // 判断账号密码是否正确，提示密码错误
        }
        if (!passWord.equals(student.getPassWord())) {
            mv.setViewName("error");
            mv.addObject("exception", "密码错误");
            return mv;
        }

        // 登陆成功
        Long logintime = System.currentTimeMillis();
        student.setLoginTime(logintime);
        rmiService.getStudentService().updateLoginTime(student);
        // 将用户ID和当前时间生成token存储入cookie
        String token = JWTUtil.createToken(student.getStuID(),logintime);
        Cookie ck = new Cookie("token", token);
        ck.setMaxAge(60 * 60);
        ck.setPath("/");
        response.addCookie(ck);
        //重新定向至主页
        mv.setViewName("redirect:/homepage");
        return mv;
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response){
        Cookie cookies[] = request.getCookies();
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                if (cookies[i].getName().equals("token"))
                {
                    Cookie cookie = new Cookie("token","ww");//这边得用"",不能用null
                    cookie.setPath("/");//设置成跟写入cookies一样的
                    // cookie.setDomain(".wangwz.com");//设置成跟写入cookies一样的
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return "redirect:/homepage";
    }


}
