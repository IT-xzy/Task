package spring.controller;

        import utils.exception.LoginException;
        import org.apache.log4j.Logger;
        import org.springframework.web.bind.annotation.RequestMethod;
        import utils.jiami.CookieUtil;
        import utils.jiami.Sha;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import spring.model.User;
        import spring.service.impl.UserService;
        import utils.jiami.Token;

        import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String Login(HttpServletResponse response,String username, String userpassword) throws Exception {
        logger.info("进行登陆判断");
        User user = new User();
        user.setUsername(username);
        user.setUserpassworld(Sha.jdksha256(userpassword));
        if(userService.query(user)==null){
            logger.info("用户登陆错误");
            throw new LoginException("用户或密码错误，请重新登陆!");
        }else{
            Long date = System.currentTimeMillis();
            user.setLogin(date);
            userService.reLogin(user);
            String token = Token.createJWT(username,date.toString(),1000*60*30);
            CookieUtil.createCookie("login",token,response);
        }
        logger.info("用户登陆成功");
        return "redirect:home";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String add(String username,String userpassword) throws Exception{
        logger.info("用户注册判断");
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
        if(username.matches(regex)&&userpassword.matches(regex)){
            User user = new User();
            user.setUsername(username);
            user.setUserpassworld(Sha.jdksha256(userpassword));
            user.setCreateAt(System.currentTimeMillis());
            if(userService.selectByName(username)){
                logger.info("用户名存在");
                throw new LoginException("用户名已存在！");
            }else {
                userService.add(user);
                logger.info("用户注册成功");
                return "add";
            }
        }else {
            logger.info("用户注册不符合要求");
            throw new LoginException("用户名或密码长度不符合要求！");
        }
    }
    @RequestMapping("esc")
    public String Esc(HttpServletResponse response){
        CookieUtil.deleteCookie("login",null,response);
        logger.info("用户退出");
        return "redirect:home";
    }
}
