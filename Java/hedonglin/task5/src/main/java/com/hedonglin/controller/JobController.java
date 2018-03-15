package com.hedonglin.controller;

import com.hedonglin.model.Job;
import com.hedonglin.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JobController {
    private static final Logger log = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/Job",method = RequestMethod.GET)
    public String getJob(Model model){
    List<Job> jobList= jobService.getAll();
    model.addAttribute("jobList",jobList);
    return "job";
    }
}
