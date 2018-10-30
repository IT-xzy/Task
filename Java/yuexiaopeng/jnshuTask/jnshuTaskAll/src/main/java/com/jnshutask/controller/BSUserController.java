package com.jnshutask.controller;


import com.jnshutask.pojo.TaUser;
import com.jnshutask.pojo.TaUserRole;
import com.jnshutask.service.TaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bs/user")
public class BSUserController {

    @Autowired
    TaUserService taUserService;

    @PreAuthorize("hasAuthority('user:list')")
    @RequestMapping("list")
    public String listUser(Model model) {
        List<TaUserRole> listSRU = taUserService.selectUserRoles();
        List<TaUser> listTU=taUserService.selectUsers();
        model.addAttribute("listSRU", listSRU);
        model.addAttribute("listTU", listTU);
        return "/user/detail";
    }

    @PreAuthorize("hasAuthority('user:add')")
    @RequestMapping("add")
    public String addUser(TaUser taUser, TaUserRole taUserRole) {
        int i = taUserService.insertUser(taUser, taUserRole);
        if (i >= 0) {
            return "redirect:list";
        }
        return "failed";
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @RequestMapping("delete")
    public String deleteUser(Long userId) {
        int i = taUserService.deleteUser(userId);
        if (i >= 0) {
            return "redirect:list";
        }
        return "failed";
    }

    @PreAuthorize("hasAuthority('user:update')")
    @RequestMapping("update")
    public String updateUser(Long userId, TaUserRole taUserRole) {
        int i = taUserService.updateUserRole(userId, taUserRole);
        if (i >= 0) {
            return "redirect:list";
        }
        return "failed";
    }

    @PreAuthorize("hasAuthority('user:update')")
    @RequestMapping("one")
    public String oneUser(Long userId, Model model) {
        TaUserRole taUserRole = taUserService.selectUserRoleByUserId(userId);
        TaUser taUser=taUserService.selectUserByUserId(userId);
        model.addAttribute("tu", taUser);
        model.addAttribute("tur", taUserRole);
        return "/user/one";
    }
}
