package com.jnshu.controller;

import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import com.jnshu.model.Page;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 *
 */
@Controller

public class StudentController {
    protected Logger log = Logger.getLogger(StudentController.class);
    @Autowired
    Page p;
    @Resource(name = "StudentService")
    private StudentService studentService;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView findAll() throws Exception {
//        将查找全部方法的值赋给list
        List<Student> list = studentService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", list);
        mv.setViewName("hello");
        return mv;
    }


    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id, Student student) {
        log.debug("删除开始");
        System.out.println("删除" + student.toString());
        studentService.deleteStudent(id);
        return "hello";
    }

    //这个url是和全部信息那个连接对应的它要先获得当前对象的数据,
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String edits(@PathVariable("id") long id, Model model) {
        log.debug("id = " + id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        return "edit";
    }

    //这个url是和edit里面的action=对应的
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String edit(@PathVariable("id") long id, Student student) {
        //执行update方法
        log.debug(student.toString());
        studentService.updateStudent(student);
        log.debug("修改成功了");
        //请求赋值

        return "hello";
//        return "hello";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(Student student) {
        log.debug("添加成功了");
        studentService.addStudent(student);
        return "hello";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id, Model model) {
        log.debug("id = " + id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        log.debug(student.toString());
        return "delete";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String page(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, Model model) throws Exception {
        //定义页的行数
        p.setPageSize(10);
        //得出总记录数
        p.setTotalUsers(studentService.findUsers().size());
        //打印总行数
        log.info("开始了====================================" +
                "总行数" + p.getTotalUsers());

        //计算总页数 如果 总记录数%每页行数=0 就执行 等于每页行数
        p.setTotalPages(p.getTotalUsers() % p.getPageSize() == 0 ? p.getTotalUsers() / p.getPageSize() : p.getTotalUsers() / p.getPageSize() + 1);

        //显示的数据,是当前页减一乘以十 ,到当前页数乘以十
        List<Student> list = studentService.findUsersByPage((currentPage - 1) * p.getPageSize(), p.getPageSize());
        //下一页
        if (currentPage < p.getTotalPages()) {
            //如果当前页小于总页数下一页等于当前页加一
            p.setNextPage(currentPage + 1);
            //将当前页赋值给 实体类中的当前页继续用currentPage去比较
            p.setCurrentPage(currentPage);
        } else {
            //如果当前页不小于总页数,总页数等于当前页
            p.setCurrentPage(p.getTotalPages());
        }
        //上一页
        if (currentPage > 1) {
            //如果当前页大于1,上一页等于当前页减一
            p.setPrefPage(currentPage - 1);
            //将当前页赋值给 实体类中的当前页
            p.setCurrentPage(currentPage);

        } else {
            p.setPrefPage(currentPage);
        }
        //跳转页面
        model.addAttribute("currentPage", currentPage);
        log.info(p);
        model.addAttribute("list", list);
        model.addAttribute("page", p);

        return "home";
    }

}

