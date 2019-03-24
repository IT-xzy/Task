package com.ptteng.controller;


import com.ptteng.model.Company;
import com.ptteng.model.Student;
import com.ptteng.service.CompanyService;
import com.ptteng.service.StudentService;
import com.ptteng.utils.RandomUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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


    Logger logger = Logger.getLogger(StudentController.class);


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String selectProfessionData(Model model, Long figure, Long income) {
        System.out.println("???????????????????????");

        System.out.println("==============");
        List<Student> students;
        List<Company> companies;
        int counts;
        int countBySalary;
        StudentService studentService;
        CompanyService companyService;
        if (RandomUtil.randomCode() == 0) {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("serverPackage/server.xml");
                studentService = (StudentService) applicationContext.getBean("student");
                companyService = (CompanyService) applicationContext.getBean("company");
            } catch (Exception e) {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("serverPackage/server1.xml");
                studentService = (StudentService) applicationContext.getBean("student1");
                companyService = (CompanyService) applicationContext.getBean("company1");
            }
        } else {
            try {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("serverPackage/server1.xml");
                studentService = (StudentService) applicationContext.getBean("student1");
                companyService = (CompanyService) applicationContext.getBean("company1");
            }catch (Exception e){
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("serverPackage/server.xml");
                studentService = (StudentService) applicationContext.getBean("student");
                companyService = (CompanyService) applicationContext.getBean("company");
            }

        }
        if (figure == null | income == null) {
            model.addAttribute("code", -2);
            return "one/blank";
        } else {
            try {
                logger.info("参数进来没+++++++++++++++++++++++++++++++" +
                        figure + "-----------" +
                        income + "----------");
//           通过Salary对学员进行降序排列,返到页面上
                students = studentService.selectBySalary(figure);
                logger.info("salary排名前几的学员==================" + students);

//            查出所有的合作公司
                companies = companyService.selectAll();
                logger.info("合作公司==================" + companies);
//            查出所有的在学学员数
                counts = studentService.selectCount();
                logger.info("在学学员数====================" + counts);

                countBySalary = studentService.selectCountBySalary(income);
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



