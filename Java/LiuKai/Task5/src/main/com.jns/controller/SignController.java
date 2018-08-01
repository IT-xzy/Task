package controller;

import dao.LoginsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Logins;
import pojo.Student;
import service.StudentServiceImpl;
import util.PasswordUtil;
import util.TokenUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignController {
    @Autowired
    StudentServiceImpl studentService;
@Autowired
    LoginsDao loginsDao;

@RequestMapping("/login")
public ModelAndView modelAndView(){
    ModelAndView modelAndView=new ModelAndView("loginpage");
    return modelAndView;
}


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@RequestParam String stuName, @RequestParam String password, ModelAndView mv, HttpServletResponse response) throws Exception {
        Student student=studentService.findByName(stuName);
       String b=student.getPassword();

        System.out.println(student);
        System.out.println(studentService.signIn(student));
        if (PasswordUtil.verify(password,b)) {
            long time=System.currentTimeMillis();
            Logins lg=new Logins();
            System.out.println(student.getId());
            long a=studentService.signIn(student).getId();

            lg.setId(a);
            lg.setLogntime(time);
            loginsDao.addLogin(lg);
            String tk=TokenUtil.createToken(a,time);
            Cookie ck=new Cookie("token",tk);
            ck.setMaxAge(60*60);
            ck.setPath("/");
            response.addCookie(ck);
            mv.setViewName("stupage1");
        } else {
            throw new Exception("cuowu");
//            mv.addObject("result","失败");
//            mv.setViewName("redirect:index");
        }
        return mv;
    }
//
//    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
//    public ModelAndView signIn(@RequestParam String stuName, @RequestParam String password, ModelAndView mv, HttpServletResponse response) throws Exception {
//        Student student=new Student();
//        student.setStuName(stuName);
//        student.setPassword(password);
//
//        System.out.println(student);
//        System.out.println(studentService.signIn(student));
//        if (studentService.signIn(student) != null) {
//            long time=System.currentTimeMillis();
//            Logins lg=new Logins();
//            System.out.println(student.getId());
//            long a=studentService.signIn(student).getId();
//
//            lg.setId(a);
//            lg.setLogntime(time);
//            loginsDao.addLogin(lg);
//            String tk=TokenUtil.createToken(a,time);
//            Cookie ck=new Cookie("token",tk);
//            ck.setMaxAge(60*60);
//            ck.setPath("/");
//            response.addCookie(ck);
//            mv.setViewName("stupage1");
//        } else {
//            throw new Exception("cuowu");
////            mv.addObject("result","失败");
////            mv.setViewName("redirect:index");
//        }
//        return mv;
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView insertStudent(String stuName,String password) throws Exception {
      ModelAndView modelAndView=new ModelAndView();
        if (studentService.findByName(stuName) != null) {
                throw new Exception("用户名已经存在");
        }else{
            Student student=new Student();
            long t=System.currentTimeMillis();
            student.setStuName(stuName);
            student.setPassword(PasswordUtil.generate(password));
            student.setCreateTime(t);
            student.setUpdateTime(t);
            studentService.regStudent(student);
            modelAndView.setViewName("regsuccess");
             return modelAndView;
        }
    }

     @RequestMapping("/exit")
    public String exit( HttpServletRequest request, HttpServletResponse response){
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
