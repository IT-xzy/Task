package action;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;
import utils.Jwt;
import utils.VerificationCode;
import utils.json.JsonResult;
import utils.json.JsonStatusCode;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //怎么把错误信息传给前端？？？？（使用aop切面管理）
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult bindingResult,Model model) {
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> objectErrorList = bindingResult.getAllErrors();
//            List<String> list = new ArrayList<String>();
//            for (ObjectError objectError : objectErrorList) {
//                list.add(objectError.getDefaultMessage());
//                System.out.println(objectError.getDefaultMessage());
//            }
//            return "/task5/register";
//        }
        if(!userService.nametest(user.getName())) {
            userService.insert(user);
            return "home.page";
        }
        else  return "redirect:/register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/task5/register";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/task5/login";
    }

    //账号+密码 返回JSP页面
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String logging(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Valid User user,BindingResult bindingResult,Model model) {
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        String name = user.getName();
//        String password = user.getPassword();
//        //取出登陆的时候用户输入的账户，根据账户查找该账户的密码和salt值然后用检验函数做检验
//            if (userService.nametest(user.getName())) {
//                if (userService.passwordtest(name,password)) {
//                    //登陆成功
//                    String string = System.currentTimeMillis() + "";
//                    String tk = user.getName() + string;
//                    String token = Jwt.createJWT(tk);
//                    Cookie cookie = new Cookie("token", token);
//                    cookie.setMaxAge(60 * 60 * 24);
//                    httpServletResponse.addCookie(cookie);
//                    return "redirect:/home";
//                }
//                //密码错误
//                else return "/task5/error";
//            }
//            //用户名不存在
//            else return "/task5/error";
//    }

    //账号 密码 验证码 返回JSON（代码写得太丑。。。）
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody JsonResult logging(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json ) {
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(json);
        String name=jsonObject.getString("name");
        String password = jsonObject.getString("password");
        String signcode = jsonObject.getString("signcode");

       // 取出sesson中的验证码
        HttpSession httpSession = httpServletRequest.getSession();
        String signcodeSession = (String) httpSession.getAttribute("signcode");

        //如果验证码检验通过
        if (signcodeSession.equalsIgnoreCase(signcode)) {
            //验证用户名是否存在
            if (userService.nametest(name)) {
                //判断用户名和密码是否匹配
                if (userService.passwordtest(name, password)) {
                    //登陆成功，加入token
                    String string = System.currentTimeMillis() + "";
                    String tk = name + string;
                    String token = Jwt.createJWT(tk);
                    Cookie cookie = new Cookie("token", token);
                    //三小时cookie
                    cookie.setMaxAge(60 * 60 * 3);
                    httpServletResponse.addCookie(cookie);
                    //返回登陆成功
                    return new JsonResult(JsonStatusCode.SUCCESS.getCode(), JsonStatusCode.SUCCESS.getMessage(), new Date());
                }
                //返回用户名密码不匹配
                return new JsonResult(-1, "用户名密码不匹配", new Date());
            }
            //返回用户名错误
            return new JsonResult(-1, "用户名不存在", new Date());
            }
        //返回验证码错误信息
        return new JsonResult(-1, "验证码错误", new Date());
    }


    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String loginout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, User user) {
        //获取token
        Cookie[] cookie = httpServletRequest.getCookies();
        for (Cookie ck : cookie) {
            if (ck.getName().equals("token")) {
                //删除token（token删除只能通过重新设置MaxAge为0
                ck.setMaxAge(0);
                //将新token返给http
                httpServletResponse.addCookie(ck);
                System.out.println("token删除成功");
            }
        }
        return "home.page";
    }

    //验证码相关
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "/task5/logintest";
    }

    @RequestMapping(value = "/logintest", method = RequestMethod.GET)
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws ServletException, IOException {
        VerificationCode verificationCode = new VerificationCode();
        //获取验证码图片
        BufferedImage bufferedImage = verificationCode.getImage();
        //获取验证码内容
        String text = verificationCode.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("signcode", randomCode.toString());
        System.out.println("session-signcode" + randomCode.toString());
        // 禁止图像缓存
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        // 将图像输出到Servlet输出流中
        ImageIO.write(bufferedImage, "jpeg", servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public  @ResponseBody JsonResult check(HttpServletRequest httpServletRequest,String signcode) {
        //这样获取的是get方法附在url后面的querystring中间的内容，在这里为signcode=xxx 也可以在参数中直接获取（声明key值）
        System.out.println(httpServletRequest.getQueryString());
        //
        System.out.println(signcode);

        HttpSession httpSession = httpServletRequest.getSession();
        String signcodeSession = (String) httpSession.getAttribute("signcode");
            if (signcode.equals(null)) {
                return new JsonResult(JsonStatusCode.EXCEPTION.getCode(),JsonStatusCode.EXCEPTION.getMessage(),new Date());
            }
            if (signcodeSession.equals(null)) {
                return new JsonResult(JsonStatusCode.EXCEPTION.getCode(), JsonStatusCode.EXCEPTION.getMessage(), new Date());
            }
            if (signcode.equalsIgnoreCase(signcodeSession)){
            return new JsonResult(JsonStatusCode.SUCCESS.getCode(),JsonStatusCode.SUCCESS.getMessage(),new Date());
        }
        return  new JsonResult(JsonStatusCode.EXCEPTION.getCode(),JsonStatusCode.EXCEPTION.getMessage(),new Date());
    }

    @RequestMapping(value = "/gettest",method = RequestMethod.GET)
    public void gettest(HttpServletRequest httpServletRequest,String signcode,String name){
        System.out.println(signcode);
        System.out.println(name);
    }
}

