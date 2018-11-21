package com.jnshu.controller;

import com.jnshu.entity.Student4;
import com.jnshu.service.Student4Service;
import com.jnshu.serviceimpl.Student4MemcacheServiceImpl;
import com.jnshu.serviceimpl.Student4RedisServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

;


@Controller
public class UserJsonController {
    Logger logger = Logger.getLogger(UserJsonController.class);

    @Qualifier("RedisImpl")
    @Autowired
    Student4RedisServiceImpl student4ServiceRedis;
    @Qualifier("NoCache")
    @Autowired
    Student4Service student4ServiceNoCache;
    @Qualifier("MemcacheImpl")
    @Autowired
    Student4MemcacheServiceImpl student4SeriviceMemcache;

    @RequestMapping(value = "/nocache/json/student/one",method = RequestMethod.GET)
    public ModelAndView firstPage(long id,ModelAndView modelAndView)
    {
        List<Student4> student4List = new ArrayList<>();
        student4List.add(student4ServiceNoCache.findStudent4ById(id));
        modelAndView.addObject("code", 200);
        modelAndView.addObject("student4List",student4List);
        modelAndView.setViewName("student4Json");
        return modelAndView;
    }
    @RequestMapping(value = "/memcache/student/jsp/task-91",method = RequestMethod.GET)
    public ModelAndView firstJspPage(long id,ModelAndView modelAndView)
    {
        logger.info("进入了controller中的方法firstPageFromCache========"+ id );
        if(id>0){
            Student4 student4 = student4SeriviceMemcache.findStudent4ById(id);
            List<Student4> student4List = new ArrayList<>();
            //判断是否存在
            if(student4 != null){
                logger.info("找到了===" + id);
                student4List.add(student4);
                modelAndView.addObject("student4List",student4List);
                modelAndView.addObject("bodyname","task-91");
            }else{
                logger.info("没找到==="+id);
            }
        }else{
            //用户非法输入
            modelAndView.addObject("code", -100);
        }
        modelAndView.setViewName("myView1");
        return modelAndView;
        }
    @RequestMapping(value = "/memcache/json/student/one",method = RequestMethod.GET)
    public ModelAndView firstPageFrom(long id,ModelAndView modelAndView)
    {
        logger.info("进入了controller中的方法firstPageFromCache========"+ id );
        if(id>0){
            Student4 student4 = student4SeriviceMemcache.findStudent4ById(id);
            List<Student4> student4List = new ArrayList<>();
            if(student4!= null){
                //找到了
                student4List.add(student4);
                modelAndView.addObject("student4List",student4List);
                modelAndView.addObject("code", 200);
            }else{
                //没找到
                modelAndView.addObject("code", -101);
        }
        }else{
            //输入非法
            modelAndView.addObject("code", -100);
        }
        modelAndView.setViewName("student4Json");
        return modelAndView;
    }
    @RequestMapping(value = "/memcache/json/student/one",method=RequestMethod.POST)
    public String addStudent4(Student4 student4, Model model){
        logger.info("进入了controller中的方法firstPageFromCache========"+ student4);
        if(student4!=null){
            long  row = student4ServiceRedis.addStudent4(student4);
            List<Student4> student4List = new ArrayList<>();
            if(row!=0){
                student4.setId(row);
                student4List.add(student4);
                model.addAttribute("student4List",student4List);
                model.addAttribute("code", 200);
            }else{
                //失败
                model.addAttribute("code", -101);
            }
        }else{
            //参数非法
            model.addAttribute("code", -100);
        }
        return "student4Json";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/redis/json/student/one")
    public String findStudent4RedisById(long id, Model model){
        logger.info("从缓存中取出findStudent4RedisById==="+id);
         if(id>0){
             Student4 student4 = student4ServiceRedis.findStudent4ById(id);
             List<Student4> student4List = new ArrayList<>();
             if(student4!=null){
                 student4List.add(student4);
                 model.addAttribute("student4List",student4List);
                 model.addAttribute("code", 200);
             }else{
                 //没找到
                 model.addAttribute("code", -101);
             }
         }else{
             //参数非法
             model.addAttribute("code", -100);
         }
        return "student4Json";
    }
    //考虑到代码的复用性，决定不用@responseBody，这时jsontaglib的优势就发挥出来了。首先在原来方法的基础上加一个判断
    @RequestMapping(value = "/redis/student/list",method = RequestMethod.GET)
    // @ResponseBody
    public Object getHome(Model model, HttpServletRequest request) {
        //System.out.println(request.getParameter("toJson"));
        List<Student4> list = new ArrayList<Student4>();
        for (int i = 0; i < 5; i++) {
            long randomId = (long) (random() * 10 + 1);
            Student4 student4 = student4ServiceNoCache.findStudent4ById(randomId);
            list.add(student4);
        }
        model.addAttribute("student4List", list);
        model.addAttribute("code", 200);
        if ("true".equals(request.getParameter("toJson"))) {
            return "student4Json";
        }
            return "body/task-91";
    }
}
