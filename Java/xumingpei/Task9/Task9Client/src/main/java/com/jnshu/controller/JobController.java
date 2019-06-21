package com.jnshu.controller;

import com.jnshu.pojo.Job;
import com.jnshu.tool.DesUtil;
import com.jnshu.tool.RMI.RMIClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 7:23
 */
@Controller
public class JobController {
    private static Logger logger = Logger.getLogger(JobController.class);

    @ResponseBody
    @RequestMapping(value = "/u/job",method = RequestMethod.GET)
    public ModelAndView getAll(HttpServletRequest request){
        RMIClient rmiClient = RMIClient.server ();
        List<Job> jobs =rmiClient.getJobService().getAll();
        Cookie[] cookies= request.getCookies ();
        logger.info(jobs.toString());
        String token = "";
        for (Cookie cookie : cookies){
            switch (cookie.getName()){
                case "token":
                    token = cookie.getValue();
                    token = DesUtil.decrypt(token);
            }
        }
        String[] mw = token.split("\\|");
        String name = mw[1];
        logger.info("name1:"+mw[1]);
        logger.info("token1:"+token);
        ModelAndView mav =new ModelAndView("job");
        mav.addObject("jobs",jobs);
        mav.addObject("name",name);
        return mav;
    }
}
