package cn.wp.controller;

import cn.wp.aspect.WebLog;
import cn.wp.model.User;
import cn.wp.service.EmailService;
import cn.wp.service.UserService;
import cn.wp.utils.EmailUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName: EmailController @Description: 邮箱接口 @Author: 老王 @Date: 2019/6/13 15:34 @Version: 1.0
 */
@Controller
public class EmailController {
  @Autowired EmailService emailService;
  @Autowired EmailUtil emailUtil;
  @Autowired UserService userService;
  Logger logger = Logger.getLogger(EmailController.class);
  /**
   * @Author: wp @Description: 先去获取邮箱验证码 @Param: []
   *
   * @return: java.lang.String @Exception: @Date: 2019/6/14 21:53
   */
  @RequestMapping(value = "/a/gain", method = RequestMethod.GET)
  public String getMessage() {
    return "email";
  }

  public String randomMessage() {
    Random random = new Random();
    String message = String.valueOf(1000 + random.nextInt(8999));
    logger.info("验证码是===============" + message);
    return message;
  }
  /**
   * @Author: wp @Description: 查数据库确认插入与否 @Param: [mail]
   *
   * @return: java.lang.String @Exception: @Date: 2019/6/14 21:55
   */
  @WebLog(description = "获取邮箱验证码页")
  @RequestMapping(value = "/getMail", method = RequestMethod.POST)
  public String getMessage(String mail) throws IOException {
    logger.info("邮箱是多少啊?=====" + mail);
    // 获取随机数,作为验证码存在数据库里,然后发送
    String message = randomMessage();
    int state = emailService.insertCodeMail(mail, message, System.currentTimeMillis());
    logger.info("插入与否======" + state);
    emailUtil.send_common(mail, message);
    return "registerEmail";
  }
  /**
   * @Author: wp @Description: 正式注册 @Param: [request]
   *
   * @return: java.lang.String @Exception: @Date: 2019/6/14 21:56
   */
  //  @WebLog(description = "邮箱注册页")
  @RequestMapping(value = "/registerByMail", method = RequestMethod.POST)
  public String register(HttpServletRequest request) {
    // 获取参数
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String mail = request.getParameter("mail");
    String code = request.getParameter("code");
    String phone = request.getParameter("phone");
    // 参数判空
    if (!ObjectUtils.isEmpty(name)
        && !ObjectUtils.isEmpty(password)
        && !ObjectUtils.isEmpty(mail)
        && !ObjectUtils.isEmpty(code)) {
      // 用户名是否存在
      User userName = userService.selectByName(name);
      logger.info("用户名是========" + userName);
      if (ObjectUtils.isEmpty(userName)) {
        // 用户名不存在,可注册
        // 查找email表中是否有发送的邮件和验证码
        User user = userService.selectCodeMail(code, mail);
        logger.info("code and mail=====" + user);
        if (!ObjectUtils.isEmpty(user)) {
          logger.info("请重新获取验证码");
          return "email";
        } else {
          // 注册
          logger.info("邮箱与验证码匹配");
          int state = userService.insertMail(name, password, phone, mail);
          logger.info("插入成功与否" + state);
          return "home";
        }
      } else {
        logger.info("用户名已经存在");
        return "registerEmail";
      }
    } else {
      logger.info("数据为空");
      return "registerEmail";
    }
  }
}
