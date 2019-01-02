package com.suger.controller;

import com.suger.pojo.Profession;
import com.suger.pojo.Student;
import com.suger.service.ProfessionService;
import com.suger.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 22:33
 *
 * 导航栏的controller，包括首页，职业，推荐
 */

@Controller
public class ViewController {
    private static Logger logger = Logger.getLogger(ViewController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String listStudent(Model model)throws Exception{

        List<Student> studentList = studentService.getStudentByType(true);

        // 记录工作以及在学学员数目
        int workNum = studentList.size();
        model.addAttribute("workNum",workNum);
        logger.info("找到工作的学员："+workNum);

        int studyNum = studentService.getStudentByType(false).size();
        logger.info("在学学员："+studyNum);
        int total = workNum+studyNum;
        logger.info("累积在线学习学员："+total);
        model.addAttribute("total",total);

        // 打乱 studentList中的顺序
        Collections.shuffle(studentList);

        logger.info("-----查询优秀学员-------------");

        List<Student> students = new ArrayList<Student>(workNum);
        // 目前是从找到工作的学员来展示，如果大于4个，则 随机抽取4个来展示
        int n = workNum;
        boolean temp = 4 < workNum;
        if(temp){
            n = 4;
        }

        logger.info("展示优秀学员的人数："+n);
        for(int i=0;i<n;i++) {
            // 生成随机索引值,范围为0----优秀学员的最大值-1之间
            //int j = random.nextInt(studentList.size());

            // 从优秀学员列表中随机 取4个值，然后组成新的list
            // int j = random.nextInt(studentList.size());
            // students.add(studentList.get(j));

            //  数组打乱后，已经是随机值，可以直接取前几个
            students.add(studentList.get(i));
        }

        model.addAttribute("students",students);
        return "home";
    }

    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public String listProfession(Model model) throws Exception {
        List<Profession> pros = professionService.listProfession();
        logger.info("职业列表的长度:"+pros.size());
        model.addAttribute("pros",pros);
        return "profession";
    }

    @RequestMapping("/recommend")
    public String getRecommend(){
        return "recommend";
    }


}
