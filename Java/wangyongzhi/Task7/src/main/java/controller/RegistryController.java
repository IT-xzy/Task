package controller;


import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UsersService;
import util.EncryptionUtil;
import util.RegexUtil;
import util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 注册模块
 */
@Controller
@RequestMapping(value = "/")
public class RegistryController {
    private static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    UsersService usersService;

    /**
     * @Description: 注册模块
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam String username, String password, String repassword, Model model) {

        Map<String, String> msg = new HashMap<String, String>();
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setRepassword(repassword);

        //如果格式错误，带着错误提示返回页面
        if (!RegexUtil.validate(username, password, repassword, msg)) {
            user.setMsg(msg);
            model.addAttribute("user", user);
            logger.info("The format is wrong！");
            return "register";
        }
        //判断是否重复注册
        //严重注意，此处只能用==判断，不可以用equals方法
        //查询数据库里是否有重复的用户注册信息
        else if (usersService.getByName(username) != null) {
            msg.put("username", "用户名重复，请重新输入");
            user.setMsg(msg);
            model.addAttribute("user", user);
            logger.info("Username repeated！");
            return "register";
        }
        //最终符合，注册并跳转
        else {
            //加盐加密，最后把盐和密码分别存入数据库
            String salt = EncryptionUtil.getNextSalt();
            password = EncryptionUtil.getSHA256Str(password + salt);
            user.setSalt(salt);
            user.setPassword(password);
            user.setCreateAt(System.currentTimeMillis());
            usersService.insert(user);
            logger.info("Registered successfully！");

            //对登录时间和用户名加密，以cookie形式返回
            long loginTime = System.currentTimeMillis();
            user.setLoginTime(loginTime);
            usersService.updateloginTime(user);
            //生成token令牌
            TokenUtil.createToken(username, loginTime, response);
            return "redirect:/homepage";
        }
    }
}
