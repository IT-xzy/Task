package com.jnshuboot.controller;

import com.jnshuboot.pojo.SysRoleUser;
import com.jnshuboot.pojo.SysUser;
import com.jnshuboot.service.BSUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bs/user")
public class BSUserController {
    @Autowired
    BSUserService bsUserService;

    @RequestMapping("list")
    public String listUser(Model model) {
        List<SysRoleUser> listSRU = bsUserService.selectUsers();
        model.addAttribute("listSRU", listSRU);
        return "/user/detail";
    }

    @RequestMapping("add")
    public String addUser(SysUser sysUser, SysRoleUser sysRoleUser) {
        int i = bsUserService.insertUser(sysUser, sysRoleUser);
        if (i >= 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("delete")
    public String deleteUser(Integer userId) {
        int i = bsUserService.deleteUser(userId);
        if (i >= 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("update")
    public String updateUser(Integer userId, SysRoleUser sysRoleUser) {
        int i = bsUserService.updateUser(userId, sysRoleUser);
        if (i >= 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("one")
    public String oneUser(Integer userId, Model model) {
        SysRoleUser sysRoleUser = bsUserService.selectByUserId(userId);
        model.addAttribute("sru", sysRoleUser);
        return "/user/one";
    }
}
