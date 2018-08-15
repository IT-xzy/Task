package com.controller;
import com.POJO.SignIn;
import com.example.CharacterUtils;
import com.example.DesUtil1;
import com.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.charset.Charset;

/**
 * @Author: Jaime
 * @Date: 2018/4/12 15:54
 * @Description: for Task5*
 */
@Controller
public class LoginController {
    @Autowired
    LoginServiceImpl loginServiceImpl;
    //加密用
    private static final Charset CHARSET = Charset.forName("gb2312");
    @RequestMapping("/welcome")
    public String indexPage(Model model) {
        //职业展示
        model.addAttribute("goodstudent", loginServiceImpl.findGood());
        model.addAttribute("numberofstudent", loginServiceImpl.selectCount());
        model.addAttribute("numberofgraduate", loginServiceImpl.selectCountGraduate());
        model.addAttribute("images1", loginServiceImpl.findImgaes1());

        return "index";
    }

    //职业页加入tiles
    @RequestMapping(value = "/u/jobs")
    public String jobs(Model model) {
        model.addAttribute("joblist1", loginServiceImpl.findJobList1());
        model.addAttribute("numberofstudent1", loginServiceImpl.selectCount());
        return "jobs";
        //根据该逻辑名，找到tiles.xml中 对应的definition...获取最后的jsp
    }

    //login
    @RequestMapping("/login")//add method = RequestMethod.post
    public String loginIndex(Model model, SignIn signIn) {
        model.addAttribute("signIn", signIn);
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerForm() {

        return "registerform";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model,@Valid SignIn signIn) {
        String salt= CharacterUtils.getRandomString2(8);
        signIn.setSalt(salt);
        signIn.setDes(DesUtil1.encrypt(signIn.getAccount(),CHARSET,salt));
        int a=loginServiceImpl.register(signIn);
        model.addAttribute("a",a);
        return "register";
    }
//登陆验证+格式验证
    @RequestMapping("/clientLogin")
    public String clientLogin(HttpServletRequest httpServletRequest, HttpSession httpSession, @Valid SignIn signIn, BindingResult bindingResult, Model model, HttpServletResponse httpServletResponse) {
       //格式验证通过
        if (!bindingResult.hasErrors()) {
            SignIn signInLoginInfo = loginServiceImpl.clientLogin(signIn.getAccount());
            //查询到了数据
            if (signInLoginInfo != null) {
                //账号密码匹配，登陆成功
                if (signIn.getAccount().equals(signInLoginInfo.getAccount()) && signIn.getPassword().equals(signInLoginInfo.getPassword())) {
                    //token生成
                    String saltInLoginInfo=signInLoginInfo.getSalt();
                    String token=DesUtil1.encrypt(signIn.getAccount(),CHARSET,saltInLoginInfo);
                    //设置cookie，将token放入cookie中
                    Cookie cookie=new Cookie("token",token);
                    //设置cookie的时间
                    cookie.setMaxAge(6000);
                    //将cookie返回至浏览器
                    httpServletResponse.addCookie(cookie);
                    //将token存入session中
                    httpSession.setAttribute("token",token);
                    return "redirect:/u/jobs";
                }
                //账号密码不匹配，登陆失败
                else {
                    return "login";
                }
            }
            //数据库中无匹配的数据
            else {
                model.addAttribute("errorlogin", "account/password error");
                return "login";
            }
        }
        //格式验证不通过
        else {
            return "login";
        }
    }
//登出
    @RequestMapping("/signout")
    public String signOuu(HttpSession httpSession) {
        httpSession.removeAttribute("token");
        return "redirect:/welcome";
    }


}