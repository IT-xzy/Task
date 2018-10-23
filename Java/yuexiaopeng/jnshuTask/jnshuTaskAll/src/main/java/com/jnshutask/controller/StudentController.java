package com.jnshutask.controller;


import com.jnshutask.controller.ControllerUtil.UserNameUtil;
import com.jnshutask.pojo.TaStudent;
import com.jnshutask.service.TaStudentService;
import com.jnshutask.util.Page;
import com.jnshutask.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("fs/stu")
public class StudentController {
    @Autowired
    TaStudentService taStudentService;
    @Autowired
    private PageUtil pageUtil;
    @PreAuthorize("hasAuthority('stu:list')")
    @RequestMapping("list")
//    public String listRole(Integer pageNum,Integer pageSize){
    public String listStu(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          Model model) {
        List<TaStudent> listStu = taStudentService.selectPage(pageNum, pageSize);
        Long countAll = taStudentService.countAll();
        Page page = pageUtil.getPageInfo(pageNum, pageSize, countAll);
        String username=new UserNameUtil().getUsername();
        model.addAttribute("listStu", listStu);
        model.addAttribute("page", page);
        model.addAttribute("countAll", countAll);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("username",username);
        return "stu/detail";
    }

    @PreAuthorize("hasAuthority('stu:add')")
    @RequestMapping("add")
    public String addStu(TaStudent student) {
        TaStudent student1 = taStudentService.insertSelective(student);
        if (student1.getId() > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @PreAuthorize("hasAuthority('stu:delete')")
    @RequestMapping("delete")
    public String deleteStu(Integer id) {
        int i = taStudentService.deleteById(id);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @PreAuthorize("hasAuthority('stu:update')")
    @RequestMapping("update")
    public String updateStu(TaStudent student) {
        TaStudent student1 = taStudentService.updateById(student);
        if (student1.getId() > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @PreAuthorize("hasAuthority('stu:update')")
    @RequestMapping("one")
    public String oneStu(Integer id, Model model) {
        TaStudent student = taStudentService.selectById(id);
        model.addAttribute("stu", student);
        return "stu/one";
    }

}
