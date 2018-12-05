package com.tiles.controller;

import com.tiles.pojo.Profession;
import com.tiles.pojo.Student;
import com.tiles.service.ProfessionService;
import com.tiles.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String listStudent(Model model)throws Exception{
        logger.info("-----查询优秀学员-------------");
        List<Student> studentList = studentService.listStudent();
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
        // 方法2：直接以工资排序 优秀学员，取出前4条-----待实现


        model.addAttribute("students",students);
        logger.info("----查询学员状态------");
        int workNum = studentService.getStudentType(true);
        model.addAttribute("workNum",workNum);
        logger.info("找到工作的学员："+workNum);
        int studyNum = studentService.getStudentType(false);
        int total = workNum+studyNum;
        logger.info("累积在线学习学员："+total);
        model.addAttribute("total",total);
        return "home";
    }

    @RequestMapping(value = "/profession",method = RequestMethod.GET)
    public String listProfession(Model model) throws Exception {
        List<Profession> pros = professionService.listProfession();
        logger.info(pros);
        model.addAttribute("pros",pros);
        return "profession";
    }

    @RequestMapping("/recommend")
    public String getRecommend(){
        return "recommend";
    }


}
