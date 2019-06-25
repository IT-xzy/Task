package cn.wp.controller;

import cn.wp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

/** @ClassName: @Description: @Author: WP @Date: 2019/6/19 19:17 @Version: 1.0 */
@Controller
public class StudentController {

  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public String get(Model model) throws RemoteException, NotBoundException, MalformedURLException {
    StudentService studentService = null;
    int code = new Random().nextInt(2);
    if (code == 1) {
      try {
        studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8881/studentService");
      } catch (Exception e) {
        studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8882/studentService");
      }
    } else {
      try {
        studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8881/studentService");
      } catch (Exception e) {
        studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:8882/studentService");
      }
    }
    try {
      List list = studentService.selectAll();
      System.out.println("查询成功========" + list);
      model.addAttribute("data", list);
      model.addAttribute("code", 200);
      return "all";
    } catch (Exception e) {
      model.addAttribute("code", 201);
      return "all";
    }
  }
}
