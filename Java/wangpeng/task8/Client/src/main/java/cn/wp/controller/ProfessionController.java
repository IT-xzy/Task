package cn.wp.controller;

import cn.wp.model.Profession;
import cn.wp.service.ProfessionService;
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
public class ProfessionController {
  Logger logger = Logger.getLogger(ProfessionController.class);

  @RequestMapping(value = "/u/profession/list", method = RequestMethod.GET)
  public String selectPageData(Model model) {

    List<Profession> profession;
    ProfessionService professionService;
    // 根据随机数不同获取不同服务
    if (RandomUtil.randomCode() == 0) {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");
        professionService = (ProfessionService) applicationContext.getBean("profession");
      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");
        professionService = (ProfessionService) applicationContext.getBean("profession1");
      }
    } else {
      try {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server1.xml");
        professionService = (ProfessionService) applicationContext.getBean("profession1");
      } catch (Exception e) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("serverPackage/server.xml");
        professionService = (ProfessionService) applicationContext.getBean("profession");
      }
    }
    try {
      //            查找所有职业
      profession = professionService.selectAll();
      logger.info("所有职业==================" + profession);
      model.addAttribute("profession", profession);
      model.addAttribute("code", 1);
      return "profession";
    } catch (Exception e) {
      model.addAttribute("code", -1);
      return "profession";
    }
  }
}
