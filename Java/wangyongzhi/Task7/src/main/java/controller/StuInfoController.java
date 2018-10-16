package controller;

import domain.entity.StuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StuInfoService;
import service.UsersService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class StuInfoController {

    private static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    StuInfoService stuInfoService;

    @Autowired
    UsersService usersService;

    /**
     * 主页链接
     *
     * @Param Model
     */
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String listStudent(Model model) {

        //根据学习状态查找学生数目
        StuInfo stu = new StuInfo();
        stu.setStatus("在学");
        int countstudy = stuInfoService.selectStudyWork(stu);
        stu.setStatus("工作");
        int countwork = stuInfoService.selectStudyWork(stu);

        //使用Map接收，然后加入model
        Map info = new HashMap();
        info.put("countwork", countwork);
        info.put("countstudy", countstudy);

        //查找学生信息
        StuInfo one = new StuInfo();
        StuInfo two = new StuInfo();
        StuInfo three = new StuInfo();
        StuInfo four = new StuInfo();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        four.setId(4);
        one = stuInfoService.getById(one);
        two = stuInfoService.getById(two);
        three = stuInfoService.getById(three);
        four = stuInfoService.getById(four);
        info.put("one", one);
        info.put("two", two);
        info.put("three", three);
        info.put("four", four);
        model.addAllAttributes(info);
        return "homepage";
    }
}
