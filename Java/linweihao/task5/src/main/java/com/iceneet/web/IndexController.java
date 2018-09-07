package com.iceneet.web;

import com.iceneet.dao.MemberMapper;
import com.iceneet.entity.Member;
import com.iceneet.service.Memberservice;
import com.iceneet.untils.CookiesUntil;
import com.iceneet.untils.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private Memberservice memberservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String Index(ModelMap modelMap, HttpServletRequest request){
        int workNum = memberservice.countWorkingMember();
        int learnNum = memberservice.countMember();
        modelMap.addAttribute("worknum",workNum);
        modelMap.addAttribute("learnNum",learnNum);
        List<Member> L= memberservice.selectByExcellent();
        modelMap.addAttribute("ListMember",L);
        String token = CookiesUntil.getUid(request,"token");
        if(token!=null){
            String detoken = DESUtil.decode(token);
            String username = detoken.split("\\$")[1];
            modelMap.addAttribute("username",username);
            return "index";
        }else {
            return "index";
        }

    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }


}
