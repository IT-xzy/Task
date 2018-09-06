package com.iceneet.web;

import com.iceneet.dao.JobMapper;
import com.iceneet.entity.Job;
import com.iceneet.qo.JobQo;
import com.iceneet.service.Jobservice;
import com.iceneet.untils.CookiesUntil;
import com.iceneet.untils.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class T11Controller {
    @Autowired
    private Jobservice jobservice;
    @RequestMapping(value = "/u/t11",method = RequestMethod.GET)
    public String Tll(ModelMap modelMap, HttpServletRequest request){
        List<JobQo> JobList =jobservice.selectJobTypeNum();
        modelMap.addAttribute("JobList",JobList);
        String token = CookiesUntil.getUid(request,"token");
        if(token!=null){
            String detoken = DESUtil.decode(token);
            String username = detoken.split("\\$")[1];
            modelMap.addAttribute("username",username);
            return "t11";
        }else {
            return "t11";
        }
    }
}

