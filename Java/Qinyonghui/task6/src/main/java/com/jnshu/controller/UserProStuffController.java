package com.jnshu.controller;

import com.jnshu.entity.Student4;
import com.jnshu.service.Student4Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProStuffController {
    Logger logger = Logger.getLogger(UserProStuffController.class);
    @Autowired
    @Qualifier("Redis")
    Student4Service student4ServiceRedis;
    @Autowired
    @Qualifier("NoCache")
    Student4Service student4ServiceNoCache;
    @Autowired
    @Qualifier("Memcache")
    Student4Service student4ServiceMemcache;
    @RequestMapping(value = "/redis/student/one")
    public String findStudent4RedisById(long id, Model model){
     logger.info("findStudent4RedisById"+student4ServiceRedis.findStudent4ById(id));
     Student4 student4 = student4ServiceRedis.findStudent4ById(id);
     List<Student4> student4List = new ArrayList<>();
     if(student4!=null){
         student4List.add(student4);
         model.addAttribute("student4List",student4List);
         model.addAttribute("code", 100);
     }else{
         model.addAttribute("code",-100);
     }
        return "student4Json";
        }

    @RequestMapping(value = "/memcache/student/one",method = RequestMethod.GET)
    public String findStudent4MemcacheById(long id,Model model)
    {
        logger.info("findStudent4MemcacheById:"+id);
        Student4 student4 = student4ServiceMemcache.findStudent4ById(id);
        List<Student4> student4List = new ArrayList<>();

        if(student4 != null){
            System.out.println("找到了");
            student4List.add(student4);
            model.addAttribute("student4List",student4List);
            model.addAttribute("code", 100);
        }else{
            model.addAttribute("code",-100);
        }
        return "student4Json";
    }
}



