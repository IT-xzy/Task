package com.jnshu.controller;

import com.jnshu.entity.Student4;
import com.jnshu.myutils.DigitalAlphaUtil;
import com.jnshu.myutils.WordUtil;
import com.jnshu.service.Student4Service;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller

public class Student4Controller {
    Logger logger = Logger.getLogger(Student4Controller.class);
    @Autowired
    @Qualifier("NoCache")
    Student4Service student4Service2;
    @RequestMapping(value = "/batch/student4",method = RequestMethod.POST)
    public ModelAndView saveBatch(ModelAndView modelAndView){

        List<Student4> student4List = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            Student4 student4 = new Student4();
            student4.setName(WordUtil.creatWord(6));
            student4.setImg(RandomStringUtils.randomAlphanumeric(10));
            student4.setProfessionId(Math.abs(new Random().nextLong()));
            student4.setState(new Random().nextBoolean());//学习方向1：前端开发方向2:后端反向2：0运维方向
            student4.setPosition(WordUtil.creatWord(4));
            student4.setSalary(DigitalAlphaUtil.getCode(2, 0));//薪水
            student4.setGraduateAt(System.currentTimeMillis()-30000000);//0：1星,1:二星
            student4.setResume(WordUtil.creatWord(256));
            student4.setCreateBy(WordUtil.creatWord(12));
            student4.setCreateAt(System.currentTimeMillis());
            student4.setUpdateAt(System.currentTimeMillis());
            student4.setUpdateBy(WordUtil.creatWord(12));
            student4List.add(student4);
        }
        if(student4Service2.batchSave(student4List)){
            modelAndView.addObject("code", 100);
        }else{
            modelAndView.addObject("code", -100);
        }
        modelAndView.setViewName("student4Json");
        return modelAndView;
    }
}
