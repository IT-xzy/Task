package com.ptteng.controller;

import com.ptteng.exception.StudentException;
import com.ptteng.bean.Student;
import com.ptteng.service.StudentService;
import com.ptteng.utils.CheckBox;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller    //加了这个就不需要显式实现接口了
//@ControllerAdvice  异常处理,标签的方式对代码的侵入性太强，不推荐使用
@RequestMapping(value = "/u/task2")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = Logger.getLogger(StudentController.class);

/*    应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }
    把值绑定到Model中，使全局@RequestMapping可以获取到该值
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }
     全局异常捕捉处理
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 403);
        map.put("msg", ex.getClass().getSimpleName());
        System.out.println(map);
        return map;
    }*/

    @RequestMapping("/student/list")
    public String main(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) {
        model.addAttribute("pagemsg", studentService.findByPage(currentPage));//回显分页数据
        return "list";
    }

    //根据ID查找学员
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String findAStudentById(@PathVariable Long id, Model model) throws Exception {
        long start = System.currentTimeMillis();
        Student student = studentService.findByPrimeKey(id);
        if (student == null)
            throw new StudentException("该条信息不存在，请刷新页面重试！");
        model.addAttribute("student", student);
        long cost = System.currentTimeMillis() - start;
        logger.info("查找操作，id：" + id + "\t花费" + cost + "毫秒");
        return "id";
    }

    //根据ID删除学员
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteAStudentById(@PathVariable Long id) throws Exception {
        long start = System.currentTimeMillis();
        if (!studentService.deleteAStudent(id))
            throw new StudentException("该条记录已删除，请刷新页面重试！");
        long cost = System.currentTimeMillis() - start;
        logger.info("成功删除，id：" + id + "\t花费" + cost + "毫秒");
        return "redirect:list";
    }

    //根据姓名模糊查找
    @RequestMapping(value = "/student/name", method = RequestMethod.GET)
    public String findAStudentByName(@RequestParam String name, Model model) throws Exception {
        long start = System.currentTimeMillis();
        if (name.equals(""))
            throw new StudentException("请输入有效搜索信息！");
        List<Student> students = studentService.findStudentsByName(name);
        if (students.size() == 0)
            throw new StudentException("该搜索结果不存在，请核对姓名信息！");
        model.addAttribute("students", students);
        long cost = System.currentTimeMillis() - start;
        logger.info("查找操作，姓名：" + name + "\t花费" + cost + "毫秒");
        return "name";
    }

    //根据学号精确查找
    @RequestMapping(value = "/student/num", method = RequestMethod.GET)
    public String findAStudentByNum(@RequestParam String num, Model model) throws Exception {
        long start = System.currentTimeMillis();
        Student student = studentService.findAStudentByNum(num);
        if (student == null)
            throw new StudentException("该搜索结果不存在，请核对学号信息！");
        model.addAttribute("student", student);
        long cost = System.currentTimeMillis() - start;
        logger.info("查找操作，学号：" + num + "\t花费" + cost + "毫秒");
        return "number";
    }

    //进入新增学员的编辑窗口
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String newOneStudent() {
        return "newone";
    }

    //提交新增学员的信息
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String tryToAdd(Student student) throws Exception {
        long start = System.currentTimeMillis();
        CheckBox.check(student, CheckBox.INSERT);
        long cost = System.currentTimeMillis() - start;
        logger.info("成功新增一条学员信息,id为：" + studentService.addAStudent(student) + "\t花费" + cost + "毫秒");
        return "redirect:student/list";
    }

    //提交更新信息
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String tryToUpdate(Student student) throws Exception {
        long start = System.currentTimeMillis();
        CheckBox.check(student, CheckBox.UPDATE);
        studentService.updateInformation(student);
        long cost = System.currentTimeMillis() - start;
        logger.info("成功更新一条学员信息，id为：" + student.getId() + "\t花费" + cost + "毫秒");
        return "redirect:student/list";
    }

}
