package com.task8.controller;


import com.task8.pojo.Profession;
import com.task8.pojo.User;
import com.task8.service.ProfessionService;
import com.task8.service.UserService;

import com.task8.util.RmiServerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//@RequestMapping(value="/task8")
public class MyController {

//@Autowired
//    UserService userService;

//@Autowired
//    ProfessionService professionService;





    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String main(Model model) {


          RmiServerUtil rmiServerUtil=new RmiServerUtil();

        UserService userService=rmiServerUtil.getUserService();

        ProfessionService professionService=rmiServerUtil.getProfessionService();


        List<User> list=userService.selectAll();
        model.addAttribute("user", list);
        int number=0;
        int worker=0;
        List<Profession> list2=professionService.selectProfession();
        for (Profession l : list2) {
            number+= l.getNumber();
            worker+=l.getWorker();
        }
        model.addAttribute("number", number);
        model.addAttribute("worker", worker);

        return "main";
    }

    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String pro(Model model) {


        RmiServerUtil rmiServerUtil=new RmiServerUtil();
        ProfessionService professionService=rmiServerUtil.getProfessionService();

        List<Profession> list2 = professionService.selectProfession();
        model.addAttribute("professionList", list2);
        return "profession";
    }


    @RequestMapping(value = "/u/recommend",method = RequestMethod.GET)
    public String rec() {
        return "recommend";
    }


}
