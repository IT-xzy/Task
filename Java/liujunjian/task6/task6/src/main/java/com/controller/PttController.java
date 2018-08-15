package com.controller;

import com.pojo.Customer;
import com.pojo.Profession;
import com.service.CustomerService;
import com.service.PttDaoService;
import com.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PttController {
    @Autowired
    private PttDaoService pttDaoService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JwtUtil jwtUtil;

    private Profession findProfession(String profession) {
        try {
            return pttDaoService.findProfession(profession);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/cancellation")
    public String cancellation(HttpServletResponse response) {
//        把用户名设为null
        String token = jwtUtil.generateToken(null, 3600000);
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/loginResult")
    public String Login(Customer customer, Model model, HttpServletResponse response) throws Exception {
        String message = customerService.login(customer);
        if (message.equals("true")) {
            String token = jwtUtil.generateToken(customer.getUsername(), 3600000);
//            输出token
            System.out.println(token);
            Cookie cookie = new Cookie("token", token);
//            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return "redirect:/homePage";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @RequestMapping(value = "/registerResult", method = RequestMethod.POST)
    public String Register(Customer customer, Model model) throws Exception {
        String message = customerService.register(customer);
        if (message.equals("true")) {
            model.addAttribute("message", "注册成功，请登录:");
            return "login";
        } else {
            model.addAttribute("message", message);
            return "register";
        }
    }

    @RequestMapping(value = "/homePage")
    public String toHomePage(Model model) throws Exception {
        List<Profession> list1 = pttDaoService.findAll();
        int stuSum = 0;
        int graSum = 0;
        for (Profession profession : list1) {
            stuSum = stuSum + profession.getStu_number();
            graSum = graSum + profession.getGra_number();
        }
        model.addAttribute("stuSum", stuSum);
        model.addAttribute("graSum", graSum);
        List<String> list = new ArrayList();
        list.add("../images/banner-1.jpg");
        list.add("../images/banner-2.jpg");
        list.add("../images/banner-3.jpg");
        list.add("../images/banner-4.jpg");
        model.addAttribute("image", list);
        return "main";
    }

    @RequestMapping(value = "/profession")
    public String toProfession(Model model) {
        model.addAttribute("java", findProfession("java"));
        model.addAttribute("python", findProfession("python"));
        model.addAttribute("css", findProfession("css"));
        model.addAttribute("js", findProfession("js"));
        model.addAttribute("Android", findProfession("Android"));
        model.addAttribute("ios", findProfession("ios"));
        model.addAttribute("pm", findProfession("pm"));
        model.addAttribute("ui", findProfession("ui"));
        model.addAttribute("qa", findProfession("qa"));
        model.addAttribute("operator", findProfession("operator"));
        return "profession";
    }

    @RequestMapping(value = "/u")
    public String toRecommend() {
        return "recommend";
    }
}
