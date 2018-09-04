package com.iceneet.web;

import com.iceneet.entity.Signup;
import com.iceneet.service.Signupservice;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Controller
public class SignupController {
    @Autowired
    Signupservice signupservice;
    private Logger logger = Logger.getLogger(SignupController.class);

    @RequestMapping(value = "/a/u/signupmember",method = RequestMethod.POST)
    public String AddSignupMember(@RequestBody Signup signup, ModelMap modelMap){
        if (signup.getName()!=null){
            try {
                signupservice.InsertSign(signup);
            }catch (Exception e){
                logger.error(e);
                modelMap.put("Result","添加操作失败");
                return "Result";
            }
            logger.info("插入成功");
            modelMap.put("Result","添加操作成功");
            return "Result";
        }else {
            modelMap.put("Result","添加操作失败");
            return "Result";
        }
    }

    @RequestMapping(value = "/a/u/getsignup/{id}",method = RequestMethod.GET)
    public String GetSignupMember(@PathVariable long id,ModelMap modelMap){
        try {
            Signup s = signupservice.GetSignupById(id);
            modelMap.put("member",s);
            return "Test";
        }catch (Exception e){
            logger.error(e);
            modelMap.put("Result","查找操作失败");
            return "Result";
        }
    }

    @RequestMapping(value = "/a/u/updatesignup",method = RequestMethod.PUT)
    public String UpdateSignup(@RequestParam("Uid") long id,ModelMap modelMap){
        System.out.println("test"+id);
        modelMap.addAttribute("Result",id);
        return "Result";
    }

    @RequestMapping(value = "/SelectSignup",method = RequestMethod.GET)
    public String GetSelectById(ModelMap modelMap){
        try {
            List<Signup> List= signupservice.getSignupByPage(0,10);
            modelMap.put("List",List);
            return "ShowSelectResult";
        }catch (Exception e){
            logger.error(e);
            modelMap.put("Result","查找操作失败");
            return "Result";
        }
    }
    @RequestMapping(value = "/AddStudent",method = RequestMethod.GET)
    public String AddShow(){
        return "AddStudent";
    }

    @RequestMapping(value = "/Delete/{id}",method = RequestMethod.DELETE)
    public String DeleteById(@PathVariable long id,ModelMap modelMap){
        try {
            signupservice.DeleteById(id);
        }catch (Exception e){
            logger.error(e);
        }
        return "redirect:/SelectSignup";
    }

    @RequestMapping(value = "/AddSignup",method = RequestMethod.POST,produces ="text/html;charset=UTF-8")
    public String AddSignup(HttpServletRequest Request,ModelMap map) throws UnsupportedEncodingException {
        Request.setCharacterEncoding("UTF-8");
        //获取form表单参数
        if(Request.getParameter("name")!=null){
            Signup s = new Signup();
            s.setId(Long.parseLong(Request.getParameter("Uid")));
            s.setName(Request.getParameter("name"));
            s.setQq(Integer.parseInt(Request.getParameter("qq")));
            s.setLearnType(Request.getParameter("LearnType"));
            s.setTimeToLearn(Request.getParameter("LearnTime"));
            s.setGraduatedSchool(Request.getParameter("School"));
            s.setOnlineNum(Request.getParameter("onlineNum"));
            s.setDariyList(Request.getParameter("dariyList"));
            s.setWish(Request.getParameter("wish"));
            s.setHelperShixiong(Request.getParameter("helper"));
            s.setWayToKnow(Request.getParameter("waytokonw"));
            try {
                signupservice.InsertSign(s);
                logger.info("添加成功 ");
            }catch (Exception e){
                logger.error("插入方法失败："+e);
            }
        }else {
            logger.error("插入失败");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/EditStudent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String EditStudent(HttpServletRequest Request,ModelMap modelMap) throws UnsupportedEncodingException {
        Request.setCharacterEncoding("UTF-8");
        if(Request.getParameter("name")!=null){
            Signup s = new Signup();
            s.setId(Long.parseLong(Request.getParameter("Uid")));
            s.setName(Request.getParameter("name"));
            s.setQq(Integer.parseInt(Request.getParameter("qq")));
            s.setLearnType(Request.getParameter("LearnType"));
            s.setTimeToLearn(Request.getParameter("LearnTime"));
            s.setGraduatedSchool(Request.getParameter("School"));
            s.setOnlineNum(Request.getParameter("onlineNum"));
            s.setDariyList(Request.getParameter("dariyList"));
            s.setWish(Request.getParameter("wish"));
            s.setHelperShixiong(Request.getParameter("helper"));
            s.setWayToKnow(Request.getParameter("waytokonw"));
            modelMap.put("member",s);
            return "EditStudent";
        }else {
            logger.error("插入失败");
            return "";
        }
    }

    @RequestMapping(value ="/UpdateStudent",method = RequestMethod.PUT,produces = "text/html;charset=UTF-8")
    public String UpdateStudent(HttpServletRequest Request,ModelMap modelMap) throws UnsupportedEncodingException, InterruptedException, MemcachedException, TimeoutException {
        Request.setCharacterEncoding("UTF-8");
        if(Request.getParameter("name")!=null){
            Signup s = new Signup();
            s.setId(Long.parseLong(Request.getParameter("Uid")));
            s.setName(Request.getParameter("name"));
            s.setQq(Integer.parseInt(Request.getParameter("qq")));
            s.setLearnType(Request.getParameter("LearnType"));
            s.setTimeToLearn(Request.getParameter("LearnTime"));
            s.setGraduatedSchool(Request.getParameter("School"));
            s.setOnlineNum(Request.getParameter("onlineNum"));
            s.setDariyList(Request.getParameter("dariyList"));
            s.setWish(Request.getParameter("wish"));
            s.setHelperShixiong(Request.getParameter("helper"));
            s.setWayToKnow(Request.getParameter("waytokonw"));
            signupservice.updateByPrimaryKey(s);
            logger.info("更新成功");
            return "redirect:/SelectSignup";
        }else {
            logger.error("插入失败");
            return "redirect:/SelectSignup";
        }
    }

    @RequestMapping(value = "show/{id}",method = RequestMethod.GET)
    public String student(@PathVariable long id,ModelMap modelMap){
        try {
            Signup s = signupservice.GetSignupById(id);
            modelMap.put("member",s);
            return "student";
        }catch (Exception e){
            logger.error(e);
            modelMap.put("Result","查找操作失败");
            return "Result";
        }
    }

}
