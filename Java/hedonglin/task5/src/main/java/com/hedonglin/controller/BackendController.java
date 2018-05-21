package com.hedonglin.controller;

import com.hedonglin.model.Talent;
import com.hedonglin.service.TalentService;
import com.hedonglin.util.CookieUtil;
import com.hedonglin.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
public class BackendController {
    @Autowired
    private TalentService talentService;
    private static final Logger log = LoggerFactory.getLogger(BackendController.class);

    //注册用户界面
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public String registered() {
        return "regist";
    }

    //注册用户
    @RequestMapping(value = "/registered/u", method = RequestMethod.POST)
    public String regist(String account,String password) {
        //生成盐
        String salt= UUID.randomUUID().toString();
        String passwordMixSalt = MD5Util.mixPasswordWithSalt(password, salt);

        //生成对象
        Talent talent=new Talent();
        talent.setSalt(salt);
        talent.setPassword(passwordMixSalt);
        talent.setName(account);
        Talent exitTalent=talentService.selectByName(account);
        log.info("talent:{},exitTalent：{}",talent,exitTalent);
        if (exitTalent != null)
         {
            return "false";
         }
        else {
            //放入数据库
            talentService.insert(talent);
            log.info("注册成功");
            return "redirect:/registered/success";
        }

    }


    //注册成功界面
    @RequestMapping("/registered/success")
    public String registeredSuccess() {
        return "success";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Model model) {
        log.info("登陆展示页");
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        RedirectAttributes model, String account, String password) throws Exception {
        Long id=talentService.selectIdByName(account);
        Talent talent=talentService.selectByPrimaryKey(id);
        String salt=talent.getSalt();
        String mixSltPassword=MD5Util.mixPasswordWithSalt(password,salt);
        log.info("账号:{}，密码:{}", account, password);
        if (talent.getName().equals(account) && talent.getPassword().equals(mixSltPassword)) {
            log.info("登陆成功");
            String token=talentService.getTokenByName(account);
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(30 * 60); // 设置为30分钟
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:talent";
        } else {
            log.info("登陆失败");
            model.addFlashAttribute("error", "密码错误");
            return "redirect:loginPage";
        }
    }


    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                cookie.setValue(null);
                cookie.setMaxAge(0); //立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        return "redirect:loginPage";
    }




    @RequestMapping(value = "/fuck", method = RequestMethod.GET)
    public String fuckYou(ModelMap model,HttpServletRequest request) {
        Cookie name=CookieUtil.getCookieByName(request, "token");
        log.info("request:{},name:{}",request,name);

        try {
            String value=CookieUtil.getCookieValueByName(request,"token");
            log.info("request:{},name:{},value,{}",request,name,value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "fuck";
    }


}
