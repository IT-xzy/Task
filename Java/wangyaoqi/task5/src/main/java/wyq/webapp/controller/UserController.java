package wyq.webapp.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;
        import wyq.webapp.pojo.User;
        import wyq.webapp.service.UserService;
        import wyq.webapp.util.JwtHelper;
        import wyq.webapp.util.MD5Util;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/u/page",method = RequestMethod.GET)
    public ModelAndView page(){
        modelAndView.setViewName("page");
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getRegister(){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response,String userName, String password) {
        User findUn = userService.findUserName(userName);
        if(findUn != null){
            modelAndView.addObject("msg","用户名已存在");
            modelAndView.setViewName("redirect:/register");
            return modelAndView;
        }

        String salt = MD5Util.addSalt();
        String pw = MD5Util.genetate(password,salt);

        User user = new User();
        user.setUserName(userName);
        user.setPassword(pw);
        user.setSalt(salt);
        userService.register(user);

        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,String userName, String password){
        String salt = userService.getSalt(userName).getSalt();
        String pw = MD5Util.genetate(password,salt);
        User quser = userService.login(userName,pw);

        if (quser != null) {
            String data = userName+"-"+System.currentTimeMillis();
            String token = JwtHelper.sign(data,30L * 24L * 3600L * 1000L);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(24*60*60);
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute("token",token);
//            String sessionId = session.getId();
            modelAndView.addObject("msg","登陆成功");
            modelAndView.setViewName("redirect:/u/page");
        }else {
            modelAndView.addObject("msg","登录失败");
            modelAndView.setViewName("redirect:/user");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/u/page",method = RequestMethod.POST)
    public ModelAndView outlogin(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            break;
        }
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
