package com.jnshuboot.controller;

import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.SysRole;
import com.jnshuboot.pojo.SysRoleUser;
import com.jnshuboot.service.BSRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bs/role")
public class BSRoleController {
    @Autowired
    BSRoleService bsRoleService;

    @RequestMapping("list")
//    public String listRole(Integer pageNum,Integer pageSize){
    public String listRole(Model model) {
        List<SysPermissionRole> listSPR = bsRoleService.selectRole();
        model.addAttribute("listSPR", listSPR);
        return "/role/detail";
    }

    @RequestMapping("add")
    public String addRole(SysRole sysRole, SysPermissionRole sysPermissionRole) {
        int i = bsRoleService.insertRole(sysRole, sysPermissionRole);
        if (i > 0) {
            return "redirect:list";
        }
        return "/error";
    }

    @RequestMapping("delete")
    public String deleteRole(Integer roleId) {
        int i = bsRoleService.deleteRole(roleId);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("update")
    public String updateRole(Integer roleId, SysPermissionRole sysPermissionRole) {
        int i = bsRoleService.updateRole(roleId, sysPermissionRole);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("one")
    public String oneRole(Integer roleId, Model model) {
        SysPermissionRole sysPermissionRole = bsRoleService.selectByRoleId(roleId);
        model.addAttribute("spr", sysPermissionRole);
        return "/role/one";
    }
}
