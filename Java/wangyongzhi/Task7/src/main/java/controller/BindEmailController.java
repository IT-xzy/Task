package controller;

import domain.entity.StuApply;
import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StuApplyService;
import service.cache.util.MemcachedUtil;
import thirdApi.com.aliyun.email.util.EmailUtil;
import util.GetUserUtil;
import util.RandomCode;
import util.RegexUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 绑定邮箱模块
 */
@Controller
@RequestMapping(value = "/")
public class BindEmailController {
    private Logger logger = LoggerFactory.getLogger(BindEmailController.class);

    @Autowired
    GetUserUtil getUserUtil;
    @Autowired
    MemcachedUtil memcachedUtil;
    @Autowired
    StuApplyService stuApplyService;


    @RequestMapping(value = "/u/bindEmail", method = RequestMethod.GET)
    public String getBindEmail() {
        return "bindData/bindEmail";
    }


    /**
     * @Description: 发送激活邮件
     */
    @RequestMapping(value = "/u/bindEmail", method = RequestMethod.POST)
    public String postBindEmail(@RequestParam String email, HttpServletRequest request, Model model) {

        Users user = getUserUtil.getUser(request);
        Map map = new HashMap();

        if (RegexUtil.isEmail(email)) {   //如果符合邮箱格式

            //设计储存键值
            String userEmail = user.getUsername() + "Email";
            String emailCode = user.getUsername() + "EmailCode";

            //生成8位验证码
            String secureCode = RandomCode.getSixRandom();

            memcachedUtil.setValue(userEmail, 1800, email);
            memcachedUtil.setValue(emailCode, 1800, secureCode);
            logger.info("验证码已经存入缓存。");

            //发送邮件
            EmailUtil.sendEmail(email, secureCode);
            map.put("warning", "激活邮件已发送，请30分钟内验证激活。");
            logger.info("Email has been sent！");
        } else {
            //格式如果有误
            map.put("warning", "您输入的邮箱格式有误，请重新输入。");
            logger.info("This is not an Eamil！");
        }

        model.addAttribute("map", map);
        return "bindData/bindEmail";
    }
    /**
     * @Description: 验证邮箱的激活链接
     */
    @RequestMapping(value = "/u/email/{code}", method = RequestMethod.GET)
    public String activateEmail(@PathVariable("code") String code, HttpServletRequest request, Model model) {

        //取出缓存中的键值
        Users user = getUserUtil.getUser(request);
        String userEmail = user.getUsername() + "Email";
        String emailCode = user.getUsername() + "EmailCode";

        String secureCode = (String) memcachedUtil.getValue(emailCode);
        logger.info("验证码已经取出缓存");

        //取出邮箱并插入数据库
        String email = (String) memcachedUtil.getValue(userEmail);
        StuApply stu = stuApplyService.getByUsername(user.getUsername());

        Map map = new HashMap();

        //判定验证码是否相同
        if (code.equals(secureCode)) {
            stu.setEmail(email);
            stuApplyService.updateByUsername(stu);
            map.put("warning", "绑定成功！");
            logger.info("Binding email successfully!");
        } else {
            map.put("warning", "绑定失败，请重新绑定！");
            logger.info("Wrong emailcode！");
        }
        model.addAttribute("map", map);
        return "bindData/warning";
    }
}
