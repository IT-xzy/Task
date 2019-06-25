package cn.wp.controller;

import cn.wp.entity.User;
import cn.wp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/3 14:38 @Version: 1.0 */
@Controller
public class UserController {
  Logger logger = Logger.getLogger(UserController.class);
  @Autowired UserService userService;

  @RequestMapping(value = "/a/u/all", method = RequestMethod.GET)
  public String selectAll(Model model) {
    try {
      List<User> users = userService.selectAll();
      model.addAttribute("users", users);
      model.addAttribute("code", 1);

    } catch (Exception e) {
      model.addAttribute("code", -1);
    }
    return "user";
  }

    @RequestMapping(value = "/a/u/add", method = RequestMethod.GET)
    public String add() {
        logger.info("跳转添加页面");
        return "add";
    }


}
