package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Student;
import cn.wp.service.StudentService;
import cn.wp.utils.RandomUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/19 17:10 @Version: 1.0 */
@Controller
public class StudentController {

  Logger logger = Logger.getLogger(StudentController.class);

  @WebLog(description = "请求学员页")
  @RequestMapping(value = "/a/u/student/list", method = RequestMethod.GET)
  public String selectProfessionData(Model entity, Long figure, Long income) {
    List<Student> students;
    int counts;
    int countBySalary;
    StudentService studentService;
    // 根据随机数不同来获取不同服务
    if (RandomUtil.randomCode() == 0) {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");
        studentService = (StudentService) applicationContext.getBean("student");

      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");
        studentService = (StudentService) applicationContext.getBean("student1");
      }
    } else {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");
        studentService = (StudentService) applicationContext.getBean("student1");

      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");
        studentService = (StudentService) applicationContext.getBean("student");
      }
    }
    //        不加参数就返回blank页面
    if (figure == null | income == null) {
      entity.addAttribute("code", -2);
      return "blank";
    } else {
      try {
        logger.info(
            "参数进来没+++++++++++++++++++++++++++++++"
                + figure
                + "-----------"
                + income
                + "----------");
        //           通过Salary对学员进行降序排列,返回页面上
        students = studentService.selectBySalary(figure);
        logger.info("salary排名前几的学员==================" + students);
        //            查询所有在学学员数
        counts = studentService.selectCount();
        logger.info("在学学员数====================" + counts);

        countBySalary = studentService.selectCountBySalary(income);
        logger.info("salary大于参数的学员数================" + countBySalary);

        entity.addAttribute("countBySalary", countBySalary);
        entity.addAttribute("counts", counts);
        entity.addAttribute("students", students);
        entity.addAttribute("code", 1);
        return "home";
      } catch (Exception e) {
        entity.addAttribute("code", -1);
        return "home";
      }
    }
  }
}

//    @RequestMapping(value = "/a/u/student/list", method = RequestMethod.GET)
//
//    public String selectAll(Model model, Long figure) {
//        try {
//            List<Student> students = studentService.selectBySalary(figure);
//            logger.info("salary排名前四的学员==================" + students);
//
//            model.addAttribute("students", students);
//
//            model.addAttribute("code", 1);
//            return "home";
//        } catch (Exception e) {
//            model.addAttribute("code", -1);
//            return "home";
//        }
//    }
