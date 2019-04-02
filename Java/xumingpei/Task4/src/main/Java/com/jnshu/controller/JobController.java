package com.jnshu.controller;

import com.jnshu.pojo.Job;
import com.jnshu.service.JobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 7:23
 */
@Controller
public class JobController {
    private static Logger logger = Logger.getLogger(JobController.class);

    @Autowired
    JobService jobService;

    @ResponseBody
    @RequestMapping(value = "/job",method = RequestMethod.GET)
    public ModelAndView getAll(){
        System.out.println("11211111111111111111111");
        List<Job> jobs =jobService.getAll();
        logger.info(jobs.toString());
        ModelAndView mav =new ModelAndView("job");
        mav.addObject("jobs",jobs);
        return mav;
    }
}
