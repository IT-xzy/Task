package com.jnshuboot.controller;

import com.jnshuboot.pojo.Student;
import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.SysRole;
import com.jnshuboot.service.BSRoleService;
import com.jnshuboot.service.StudentService;
import com.jnshuboot.util.Page;
import com.jnshuboot.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
    StudentService studentService;
    @Autowired
    private PageUtil pageUtil;

    @RequestMapping("list")
//    public String listRole(Integer pageNum,Integer pageSize){
    public String listStu(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          Model model) {
        List<Student> listStu = studentService.selectPage(pageNum, pageSize);
        Long countAll = studentService.countAll();
        Page page = pageUtil.getPageInfo(pageNum, pageSize, countAll);
        model.addAttribute("listStu", listStu);
        model.addAttribute("page", page);
        model.addAttribute("countAll", countAll);
        model.addAttribute("pageNum", pageNum);
        return "stu/detail";
    }

    @RequestMapping("add")
    public String addStu(Student student) {
        int i = studentService.insertSelective(student);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("delete")
    public String deleteStu(Integer id) {
        int i = studentService.deleteById(id);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("update")
    public String updateStu(Student student) {
        int i = studentService.updateById(student);
        if (i > 0) {
            return "redirect:list";
        }
        return "error";
    }

    @RequestMapping("one")
    public String oneStu(Integer id, Model model) {
        Student student = studentService.selectById(id);
        model.addAttribute("stu", student);
        return "stu/one";
    }
}
