package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;
import utils.EncryUtil;
import utils.Jwt;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) {
        userService.insert(user);
       return "home.page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/task5/register";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "/task5/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logging(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, User user) {
        //取出登陆的时候用户输入的账户，根据账户查找该账户的密码和salt值然后用检验函数做检验
        if (userService.nametest(user.getName())) {
            if (userService.passwordtest(user)) {
                //登陆成功
                String string = System.currentTimeMillis()+"";
                String tk = user.getName()+string;
                String token = Jwt.createJWT(tk);
                Cookie cookie = new Cookie("token",token);
                cookie.setMaxAge(60*60*24);
                httpServletResponse.addCookie(cookie);
                return "home.page";
            }
            //密码错误
            else return "task5/error";
        }
        //用户名不存在
        else return "task5/error";
    }
}
