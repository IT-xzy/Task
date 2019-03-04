package com.jnshu.task5.controller;

import com.jnshu.task5.beans.Profession;
import com.jnshu.task5.service.impl.ProfessionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfessionController {

    Logger logger = LoggerFactory.getLogger(ProfessionController.class);
    @Autowired
    private ProfessionServiceImpl professionService;



    /**
     *  测试json字符串方法,其中去重DevelopmentDirectior中重复的字段
     * @param model 存在model域中
     * @return 返回json页面;
     */
    @RequestMapping(value = "/u/professionJson",method = RequestMethod.GET)
    public String  showProfessionJson(Model model){
//        List<Profession> professionList = professionService.showProfession();
//        model.addAttribute("professionList",professionList);
//        Set set = new HashSet();
//        for (int i =0 ; i < professionList.size();i++){
//            set.add(professionList.get(i).getDevelopmentDirectior());
//        }
//        model.addAttribute("set",set);
//        logger.info("set" + set);
        return "json";
    }

    /**
     *  查询数据,同时跳转到职业页面;同时去重;
     * @param model 放在model域中
     * @return 返回到profession页面中;
     */
    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String showAllProfession(Model model, HttpSession session){
        //将查询的数据放入到缓存中
//        Jedis jedis = new Jedis();

//        List<Profession> list = new ArrayList<>();
        List<Profession> professionList = professionService.showProfession();
        List<Profession> departmentList = professionService.selectProfessionByName();

        //使用hash结构来存储对象;
//        for (int i = 0; i < professionList.size(); i++) {
//            professionList.get(i);
//
//            jedis.hset("professionList","profession",professionList.get(i).toString());
//
//        }






//       HashSet<Profession> set = new HashSet<>();
//        for (Profession profession : professionList) {
//            boolean flag = set.add(profession);
//            if(flag) {
//                list.add(profession);
//            }
//        }
        model.addAttribute("professionList",professionList);
        model.addAttribute("list",departmentList);
        Object loginName = session.getAttribute("loginName");
//        logger.info("list = " + departmentList);
//        logger.info("professionlist = " + professionList);
        if (loginName != null){
            return "profession";
        } else {
            logger.info("未登录");
            return "redirect:/home";
        }
    }

   /* @RequestMapping(value = "/u/uprofession",method = RequestMethod.POST)
    public String toProfessionPage(HttpSession session, Login login){
        System.out.println(session.getId());
        System.out.println(session.getAttribute("isLogin"));
        DataBaseConnect db = new DataBaseConnect();
        System.out.println(db.getConnection());
        if (session.getAttribute("loginName") != null){
        return "u/profession";
        } else {
        return "redirect:/home";
        }
    }*/

}
