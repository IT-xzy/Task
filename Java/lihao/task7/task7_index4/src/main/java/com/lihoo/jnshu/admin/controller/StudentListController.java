package com.lihoo.jnshu.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.common.constant.LoginStatus;
import com.lihoo.jnshu.common.util.commonUtil.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihoo
 * @since 2018-09-28
 */
@Controller
@RequestMapping("")
public class StudentListController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStudentListService studentListService;

    //  主页
    @RequestMapping("/home")
    public String home(Model model, HttpServletRequest request) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("我王境泽就是饿死：" + status);
        model.addAttribute("status", status);
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.gt("id", 0);
        List<StudentList> countAll = studentListService.list(slqw);
//        countAll.forEach(item -> logger.info("遍历学生列表：" + item));
        model.addAttribute("countAll", countAll);
        return "home";
    }

    //  职业
    @RequestMapping(value = "/profession")
    public String profession(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        System.out.println("****拦截器判断进入**职业展示");
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("从这跳下去：" + status);
        model.addAttribute("status", status);
        //页面信息展示
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.gt("id", 0);
        List<StudentList> selectAll = studentListService.list(slqw);
        model.addAttribute("selectAll", selectAll);
        QueryWrapper<StudentList> slqw1 = new QueryWrapper<>();
//        slqw.gt("id", 0);
        int countAll = studentListService.count(slqw1);
//        Long countAll = studentListService.countAll();
        model.addAttribute("countAll", countAll);
        return "profession";
    }

    //  推荐
    @RequestMapping(value = "/recommend")
    public String recommend(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        System.out.println("****拦截器会去判断能不能进入**推荐页");
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("也不带吃你们一点东西：" + status);
        model.addAttribute("status", status);
        return "recommend";
    }


    //    列表页
    @RequestMapping("/list")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, PageUtil page, Model model) throws Exception {
        String[] status = LoginStatus.status(request);
        logger.info("也不带吃你们一点东西：" + status);
        model.addAttribute("status", status);
        PageHelper.offsetPage(page.getStart(), 10);
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.gt("id", 0);
        List<StudentList> stuList = studentListService.list(slqw);
        logger.info("---------------------------------开始-------------------------------------");
        int totalPage = (int) new PageInfo<>(stuList).getTotal();
        page.caculateLast(totalPage);
        ModelAndView mav = new ModelAndView("/list");
        mav.addObject("stuList", stuList);
        logger.info("---------------------------------结束-------------------------------------");
        return mav;
    }



}
