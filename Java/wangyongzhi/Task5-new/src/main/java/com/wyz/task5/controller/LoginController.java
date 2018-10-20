package com.wyz.task5.controller;

import com.wyz.task5.domain.entity.Users;
import com.wyz.task5.serviec.UsersService;
import com.wyz.task5.util.CookieUtil;
import com.wyz.task5.util.EncryptionUtil;
import com.wyz.task5.util.TokenUtil;
import com.wyz.task5.util.desEncryption.DesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 登录模块
 */
@Controller
@RequestMapping(value = "/")

public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(StuInfoController.class);

    @Autowired
    UsersService usersService;

    //把login页面放入了受保护的文件里。所以需要针对get方式提交定义一个方法
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login/login";
    }

    /**
     * @Description: 登录模块
     * @param  request
     * @param  response
     * @param  username
     * @param  password
     * @param  model
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //此处@RequestParam作用是从前台获取参数，如果参数名相同，无需注明名称，如果不同，得注明。
    // required=true，则参数必须要传（为了防止前台为null，后台为类似int的基本类型）
    //defaultValue属性可以设置默认值
    public String postLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
                                @RequestParam(name = "pd", required = true, defaultValue = "000000") String password, Model model) {
//        if (logger.isInfoEnabled()) {
//            logger.info("用户输入的用户名:{}；密码：{}；", username, password);
//        }
        Users user = usersService.getByName(username);

        //严重注意，此处只能用==判断，不可以用equals方法
        if (user == null) {
            logger.info("There is no current user!");
            return "login/errorLogin";
        }
        String salt = user.getSalt();
        password = EncryptionUtil.getSHA256Str(password + salt);
        if (password.equals(user.getPassword())) {

            //生成token令牌
            long loginTime = System.currentTimeMillis();
            user.setLoginTime(loginTime);
            usersService.updateloginTime(user);
            TokenUtil.createToken(username, loginTime, response);
            logger.info("Login successfully！");

            return "redirect:/homepage";
        } else {
            return "login/errorLogin";
        }
    }

    /**
     * @Description: 登出模块
     * @param  request
     * @param  response     *
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.delCookie(request, response, "time");
        CookieUtil.delCookie(request, response, "username");
        logger.info("Logout successfully！");
        return "redirect:homepage";
    }
}
