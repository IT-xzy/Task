package com.jnshu.controller;
import com.jnshu.Utils.EncryUtil;
import com.jnshu.Utils.MD5Util;
import com.jnshu.Utils.UUIDUtil;
import com.jnshu.model.Count;
import com.jnshu.model.Excellent;
import com.jnshu.model.Position;
import com.jnshu.service.Impl.CountServiceImpl;
import com.jnshu.service.Impl.ExcellentServiceImpl;
import com.jnshu.service.Impl.PositionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ViewContrller {
    @Resource
    private ExcellentServiceImpl excellentServiceImpl;
    @Resource
    private PositionServiceImpl positionService;
    @Resource
    private CountServiceImpl countServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inputCustomer() {
        return "Login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String error() {
        return "redirect:/";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String inputLogin(HttpServletResponse response, HttpServletRequest request, @RequestParam("user") String user, @RequestParam("pass") String pass) throws Exception {
        if (user != null & !user.equals("")) {
            Count count = countServiceImpl.selectByName(user);
            if (count.getUser().equals(user)) {
                if (MD5Util.MD5(pass + count.getSalt()).equals(count.getMd5())) {
                    String df = System.currentTimeMillis() + "";//设置日期格式
                    String tokenz = user + "," + df;
                    String token = EncryUtil.encrypt(tokenz);
                    Cookie cookie = new Cookie("name", token);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    return "redirect:/u/t10";
                }
            }
        }
        return "redirect:/Login";
    }

    @RequestMapping(value = "/u/t10", method = RequestMethod.GET)
    public ModelAndView to10() throws IOException {
        ModelAndView mv = new ModelAndView("CustomerForm");
        List<Excellent> excellencelist = excellentServiceImpl.getAllExcellent();
        Count count = countServiceImpl.selectById(1);
        mv.addObject("count", count);
        mv.addObject("excellencelist", excellencelist);
        return mv;
    }

    @RequestMapping(value = "/t11", method = RequestMethod.GET)
    public ModelAndView toTo11() throws Exception {
        ModelAndView mv = new ModelAndView("CustomerDetail");
        List<Position> list = positionService.getAllPosition();
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView touser() throws Exception {
        ModelAndView mv = new ModelAndView("user");
        return mv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView adduser(@RequestParam("user") String user, @RequestParam("online") String online, @RequestParam("workers") String workers, @RequestParam("pass") String pass) throws Exception {
        int check = countServiceImpl.countByName(user);
        if (check > 0) {
            ModelAndView mv = new ModelAndView("user");
            return mv;
        } else {
            String salt = UUIDUtil.getUUID();//随机生成盐
            String MD5 = MD5Util.MD5(pass + salt);//密码鸡眼
            Count count = new Count();
            count.setOnline(online);
            count.setWorkers(workers);
            count.setUser(user);
            count.setPass(pass);
            count.setMd5(MD5);
            count.setSalt(salt);
            countServiceImpl.insert(count);
            ModelAndView mv = new ModelAndView("Login");
            return mv;
        }
    }

    @RequestMapping(value = "/u/delete", method = RequestMethod.GET)
    public ModelAndView todelete(HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("name", null);
        cookie.setMaxAge(0);
        ModelAndView mv = new ModelAndView("CustomerDetail");
        response.addCookie(cookie);
        return mv;
    }
}
