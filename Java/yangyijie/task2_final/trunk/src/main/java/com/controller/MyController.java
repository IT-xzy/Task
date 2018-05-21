package com.controller;

import com.bean.Student;
import com.bean.StudentGet;
import com.bean.StudentPut;
import com.service.IService;
import com.util.ChangeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/14 11:55
 */
@Controller
public class MyController {
    @Autowired
    private IService servicelmpl;
    private Student student;
    private Logger logger = Logger.getLogger(MyController.class);
    
    /**
     * 以下2个方法为新增服务
     * @return 跳转新增页面
     */
    @RequestMapping(value = "/student/newone",method = RequestMethod.POST)
    public String newone(){
        return "add";
    }
    
    /**
     * 新增学生数据
     * @param sg 接收页面数据的studentGet对象
     * @return 重定向执行分页查询index
     */
    @RequestMapping(value = "/student/new", method = RequestMethod.POST)
    public String news(StudentGet sg) {
        student = ChangeUtil.studentChange(sg);
        //student.setCreate_at(System.currentTimeMillis());交给service
        servicelmpl.insertStudent(student);
        return "redirect:/student/index";
    }
//     @RequestMapping(value = "/student/new",method = RequestMethod.POST)
//     public String news(Date date,Student student){
//         long time = date.getTime();
//         student.setEntry_time(time);
//         servicelmpl.insertStudent(student);
//         return "redirect:/student/index";
//     }
    /**
     * 分页查询
     * @param currentPage 当前页数
     * @param model 传递给页面的模型对象
     * @return 返回index主页
     */
    @RequestMapping(value = "/student/index",method = RequestMethod.GET)
    public String index(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Model model){
        model.addAttribute("pagemsg", servicelmpl.findByPage(currentPage));//回显分页数据
        return "index";
    }
    /**
     * 查询所有数据(已被分页查询替代)
     * @param model 传递给页面使用的模型
     * @return 跳转到list.jsp页面
     */
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Student> list = servicelmpl.selectAll();
        List<StudentPut> list2 = new ArrayList<>();
        for (Student student1 : list) {
            list2.add(ChangeUtil.timeChange(student1));
        }
        model.addAttribute("studentList", list2);
        return "list";
    }
    

    
    /**
     * 通过姓名模糊查询
     * @param name 从页面接收传入的姓名
     * @param model 传递给页面显示的模型对象
     * @return 跳转到name查询页面
     */
    @RequestMapping(value = "/student/name",method = RequestMethod.GET)
    public String name(String name,Model model){
        List<Student> list = servicelmpl.getStudentByName(name);
        List<StudentPut> list1 = new ArrayList<>();
        for (Student student1 : list) {
            list1.add(ChangeUtil.timeChange(student1));
        }
        model.addAttribute("nameList", list1);
        return "name";
    }
    
    /**
     * 刪除方法
     * @param id 根据数据的ID去删除记录
     * @param page 捕捉当前页面用于删除之后重定向回到当前页面而不是首页
     * @return
     */
    @RequestMapping(value = "/student/{id}&{page}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id,@PathVariable("page") Integer page) {
        servicelmpl.deleteStudent(id);
        return "redirect:/student/index?currentPage="+page;
    }
    
    /**
     * 查询分页后的删除方法
     * @param id
     * @return
     */
    @RequestMapping(value = "/name/{id}", method = RequestMethod.DELETE)
    public String nameDelet(@PathVariable("id") Long id) {
        servicelmpl.deleteStudent(id);
        return "redirect:/student/index";
    }
    
    
    //以下两个控制器都会更新功能服务
    /**
     * 获取页面数据的控制器
     * @param id 从页面获取的id
     * @param model 传递给页面使用的模型
     * @return 跳转到update.jsp页面
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public String getdata(@PathVariable("id") Long id, ModelMap model) {
        Student s = servicelmpl.getStudentById(id);
        model.addAttribute("newstudent", s);
        Date date = new Date(s.getEntry_time());
        System.out.println(date);
        model.addAttribute("newdate",date);
        return "update";
    }
    
    /**
     * 执行更新的方法
     * @param id 从页面获取的id,实际是从上一个方法的student对象中获取的数据
     * @param sg 从页面获取除了id意外的其他数据
     * @return 重定向到分页index
     */
    @RequestMapping(value = "/student/id", method = RequestMethod.PUT)
    public String update( Long id, StudentGet sg) {
        student = ChangeUtil.studentChange(sg);
        student.setId(id);
        //student.setUpdate_at(System.currentTimeMillis());这里交给service层完成了
        servicelmpl.updateStudent(student);
        return "redirect:/student/index";
    }
    
    
    /**
     * json数据转换的尝试
     * @param modelMap 保存对象给页面使用
     * @return 跳转到json1.jsp页面
     */
    @RequestMapping(value = "/student/json1", method = RequestMethod.GET)
    public String json(ModelMap modelMap){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("567");
        modelMap.addAttribute("list", list);
        return "json1";
    }
}
