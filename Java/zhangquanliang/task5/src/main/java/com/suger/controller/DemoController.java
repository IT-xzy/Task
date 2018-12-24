package com.suger.controller;

import com.suger.pojo.Profession;
import com.suger.pojo.Student;
import com.suger.service.ProfessionService;
import com.suger.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author suger
 * @date 2018/11/16 22:33
 */
@Controller

public class DemoController {
    private static Logger logger = Logger.getLogger(DemoController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessionService professionService;

    @GetMapping(value = "/home")
    public String listStudent(Model model,HttpSession session)throws Exception{
        int m = 0;
        m++;
        System.out.println("验证controller调用次数 " + m);
        logger.info("-----查询优秀学员-------------");
        List<Student> studentList = studentService.findAll();
        // 打乱 studentList中的顺序
        Collections.shuffle(studentList);
        // 引入随机数
        Random random = new Random();
        // 一次展示数据的最大值
        int num =4;
        List<Student> students = new ArrayList<Student>(num);
        for(int i=0;i<num;i++) {
            // 生成随机索引值,范围为0----优秀学员的最大值-1之间
            //int j = random.nextInt(studentList.size());

            // 从优秀学员列表中随机 取4个值，然后组成新的list
            // int j = random.nextInt(studentList.size());
            // students.add(studentList.get(j));

            //  数组打乱后，已经是随机值，可以直接取前几个
            students.add(studentList.get(i));
        }

        model.addAttribute("students",students);
        int workNum = studentService.getStudentByType(true);
        model.addAttribute("workNum",workNum);
        logger.info("找到工作的学员："+workNum);
        int studyNum = studentService.getStudentByType(false);
        int total = workNum+studyNum;
        logger.info("累积在线学习学员："+total);
        model.addAttribute("onlineT",session.getAttribute("onlineT"));
        model.addAttribute("total",total);
        return "home";
    }

    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public String listProfession(Model model,HttpSession session) throws Exception {
        List<Profession> pros = professionService.listProfession();
        logger.info("查询职业列表:"+pros.isEmpty());
        model.addAttribute("pros",pros);
        model.addAttribute("onlineT",session.getAttribute("onlineT"));
        return "profession";
    }

    @RequestMapping("/recommend")
    public String getRecommend(){
        return "recommend";
    }


}
