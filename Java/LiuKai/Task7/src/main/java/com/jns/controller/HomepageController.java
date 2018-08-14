package com.jns.controller;

import com.jns.pojo.Student;
import com.jns.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomepageController {
    @Autowired
    StudentServiceImpl studentService;

    /**
     * @return
     * @Description 跳转至主页
     * @Param
     **/
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView("homePage");
        int allstu = studentService.countAll();
        int jobNum = studentService.countJob();
        modelAndView.addObject("allstu", allstu);
        modelAndView.addObject("jobNum", jobNum);
//        优秀学员展示
        List<Student> goodlist = null;
        goodlist = studentService.findGood();
//        随机展示一个优秀学员
//        int index1=(int)(Math.random()*goodlist.size());
//        Student student1 = (Student) goodlist.get(index1);
//        modelAndView.addObject("good1",student1);
//        随机展示四个优秀学员
        Random random = new Random();
        List<Integer> tempList = new ArrayList<Integer>();
        List<Student> newList = new ArrayList<Student>();
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp = random.nextInt(goodlist.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(goodlist.get(temp));
            } else {
                i--;
            }
        }
        modelAndView.addObject("newlist", newList);

        return modelAndView;
    }



}
