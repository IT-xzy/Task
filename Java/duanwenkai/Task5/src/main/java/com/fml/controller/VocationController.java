package com.fml.controller;

import com.fml.pojo.Vocation;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VocationController {
    @Autowired
    VocationService vocationService;
    @Autowired
    StudentService studentService;

    @RequestMapping("u/vocation")
    public String vocationView(Model model){
        /*各个课程的学习人数*/
        List<Integer> integerList = studentService.getStudyCountByLesson();
        model.addAttribute("integerList",integerList);

        /*职业的相关信息，工作年限和薪水没做，按写死的来*/
        List<Vocation> list = new ArrayList<>(12);
        for (int i = 1; i <= vocationService.getTotalCount(); i++){
            list.add(vocationService.getByVocationId(i));
        }
        model.addAttribute("list",list);

        return "vocation";
        /*List<Vocation> list1 = vocationService.getByVocationType("前端开发");
        List<Vocation> list2 = vocationService.getByVocationType("后端开发");
        List<Vocation> list3 = vocationService.getByVocationType("移动开发");
        List<Vocation> list4 = vocationService.getByVocationType("整站开发");

        List<List<Vocation>> list = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        model.addAttribute("list",list);*/
    }
}
