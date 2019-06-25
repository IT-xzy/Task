package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.Student;
import cn.wp.service.ProfessionService;
import cn.wp.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/19 17:10 @Version: 1.0 */
@Controller
public class StudentController {

  @Autowired StudentService studentService;
  @Autowired ProfessionService professionService;

  Logger logger = Logger.getLogger(StudentController.class);

  @WebLog(description = "请求学员页")
  @RequestMapping(value = "/a/u/student/list", method = RequestMethod.GET)
  public String selectProfessionData(Model entity, Long figure, Long income) {
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
        List<Student> students = studentService.selectBySalary(figure);
        logger.info("salary排名前几的学员==================" + students);
        //            查询所有在学学员数
        int counts = studentService.selectCount();
        logger.info("在学学员数====================" + counts);

        int countBySalary = studentService.selectCountBySalary(income);
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
