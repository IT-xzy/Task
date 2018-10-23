package com.jnshutask.controller;


import com.jnshutask.pojo.TaRole;
import com.jnshutask.pojo.TaRoleMenu;
import com.jnshutask.service.TaRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bs/role")
public class BSRoleController {
    @Autowired
    TaRoleService taRoleService;

    @PreAuthorize("hasAuthority('role:list')")
    @RequestMapping("list")
    public String listRole(Model model) {
        List<TaRoleMenu> listRoleMenu = taRoleService.selectRoleMenus();
        List<TaRole> listRole=taRoleService.selectRoles();
        model.addAttribute("listRole",listRole);
        model.addAttribute("listRoleMenu", listRoleMenu);
        return "/role/detail";
    }

    @PreAuthorize("hasAuthority('role:add')")
    @RequestMapping("add")
    public String addRole(TaRole taRole, TaRoleMenu taRoleMenu) {
        int i = taRoleService.insertRole(taRole, taRoleMenu);
        if (i > 0) {
            return "redirect:list";
        }
        return "/role/failed";
    }

    @PreAuthorize("hasAuthority('role:delete')")
    @RequestMapping("delete")
    public String deleteRole(Long roleId) {
        int i = taRoleService.deleteRole(roleId);
        if (i > 0) {
            return "redirect:list";
        }
        return "/role/failed";
    }

    @PreAuthorize("hasAuthority('role:update')")
    @RequestMapping("update")
    public String updateRole(Long roleId, TaRoleMenu taRoleMenu) {
        int i = taRoleService.updateRoleMenu(roleId, taRoleMenu);
        if (i > 0) {
            return "redirect:list";
        }
        return "/role/failed";
    }

    @PreAuthorize("hasAuthority('role:update')")
    @RequestMapping("one")
    public String oneRole(Long roleId, Model model) {
        TaRoleMenu taRoleMenu = taRoleService.selectRoleMenuByRoleId(roleId);
        model.addAttribute("rm", taRoleMenu);
        return "/role/one";
    }
}
