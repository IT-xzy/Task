package com.ptteng.controller;


import com.ptteng.entity.Company;
import com.ptteng.entity.Student;
import com.ptteng.service.CompanyService;
import com.ptteng.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  10:18
 * @Version 1.0
 **/

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CompanyService companyService;

    Logger logger = Logger.getLogger(StudentController.class);

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String selectProfessionData(Model model,  Long figure,  Long income) {
        if (figure == null | income == null) {
            model.addAttribute("code", -2);
            return "one/blank";
        } else {
            try {
                logger.info("参数进来没+++++++++++++++++++++++++++++++" +
                        figure + "-----------" +
                        income + "----------");
//           通过Salary对学员进行降序排列,返到页面上
                List<Student> students = studentService.selectBySalary(figure);
                logger.info("salary排名前几的学员==================" + students);

//            查出所有的合作公司
                List<Company> companies = companyService.selectAll();
                logger.info("合作公司==================" + companies);
//            查出所有的在学学员数
                int counts = studentService.selectCount();
                logger.info("在学学员数====================" + counts);

                int countBySalary = studentService.selectCountBySalary(income);
                logger.info("salary大于多少的学员数================" + countBySalary);

                model.addAttribute("countBySalary", countBySalary);
                model.addAttribute("counts", counts);
                model.addAttribute("students", students);
                model.addAttribute("companies", companies);
                model.addAttribute("code", 1);
                return "home";
            } catch (Exception e) {
                model.addAttribute("code", -1);
                return "home";
            }
        }
    }

}



