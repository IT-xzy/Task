package com.jnshuboot.controller;

import com.jnshuboot.pojo.Login;
import com.jnshuboot.service.LoginService;
import com.jnshuboot.util.Page;
import com.jnshuboot.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bs/login")
public class BSLoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private PageUtil pageUtil;

    @RequestMapping("list")
    public String listLogin(Integer pageNum, Model model) {
        Integer pageSize = 5;
        List listLogin = loginService.pageLogin(pageNum, pageSize);
        Long countAll = loginService.countLogin();
        Page page = pageUtil.getPageInfo(pageNum, pageSize, countAll);
        model.addAttribute("page", page);
        model.addAttribute("listLogin", listLogin);
        model.addAttribute("conuntAll", countAll);
        model.addAttribute("pageNum", pageNum);
        return "login/detail";
    }

    @RequestMapping("delete")
    public String deleteLogin(Long loginId, Model model) {
        int status = loginService.delete(loginId);
        String tip = "删除login失败";
        if (status <= 0) {
            model.addAttribute("tip", tip);
            return "login/failed";
        }
        return "redirect:list";
    }

    @RequestMapping("update")
    public String updateLogin(Login login, Model model) {
        int status = loginService.changInfo(login);
        String tip = "更新login失败";
        if (status <= 0) {
            model.addAttribute("tip", tip);
            return "login/failed";
        }
        return "redirect:list";
    }

    @RequestMapping("detail")
    public String detailLogin(Long loginId, Model model) {
        List<Login> list = loginService.selectById(loginId);
        model.addAttribute("login", list.get(0));
        return "login/one";
    }
}
