package cn.summerwaves.controller;

import cn.summerwaves.model.Excellence;
import cn.summerwaves.model.Position;
import cn.summerwaves.model.User;
import cn.summerwaves.service.IExcellenceService;
import cn.summerwaves.service.IPositionService;
import cn.summerwaves.service.IUserService;
import cn.summerwaves.util.CookieUtil;
import cn.summerwaves.util.TokenUtil;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
public class InterceptorController {

    @Resource
    private IUserService userService;
    @Resource
    private IExcellenceService excellenceService;
    @Resource
    private IPositionService positionService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(@Param("username")String username,@Param("password")String password,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Param("username")String username,@Param("password")String password,
                              HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        User realUser;
        realUser = userService.selectUserByName(username);
        /*登录时使用加盐算法*/
        if (realUser != null && realUser.getPassword().equals(userService.setPasswordBySalt(username,password))) {
            //生成token并添加到设定好的Cookie中
            String token = TokenUtil.makeToken(realUser.getUsername());
            Cookie tokenCookie = CookieUtil.createCookie("token", token, 60 * 60 * 24 * 10);
            response.addCookie(tokenCookie);
            mv.setViewName("loginSuccess");
            mv.addObject("username", realUser.getUsername());
            return mv;
        } else {
            mv.setViewName("loginFail");
            return mv;
        }
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //防止重复的用户名，以及用户名、密码为空，并要求用户名要不小于2
        if (userService.selectUserByName(username) == null && !username.equals("")
                && !password.equals("") && username.length() >= 2) {
            User user = new User();
            user.setUsername(username);
            //密码加盐
            user.setPassword(userService.setPasswordBySalt(username, password));
            userService.insertUser(user);
            mv.addObject("username", user.getUsername());
            mv.addObject("password", user.getPassword());
            mv.setViewName("registerSuccess");
            return mv;
        }
        mv.setViewName("registerFail");
        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping(value = "/skip", method = RequestMethod.GET)
    public String toSkip() {
        return "skipToLogin";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView toT10() {
        ModelAndView mv = new ModelAndView("home");
        List<Excellence> excellencelist = excellenceService.selectExcellenceByName();
        mv.addObject("excellencelist",excellencelist);
        return mv;
    }
    @RequestMapping(value = "/u/position")
    public ModelAndView toT11() {
        ModelAndView mv = new ModelAndView("position");
        List<Position> positions = positionService.selectPositionByType(1);
        mv.addObject("positions", positions);
        return mv;
    }

}
