package com.controller;

import com.POJO.ChangeUtil;
import com.POJO.DateTypeChange1;
import com.POJO.PageBean;
import com.POJO.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SpringController {
    Student student;
    @Autowired
    private StudentService stuServiceImpl;

    String message;
    @RequestMapping(value = "/student/list ",method = RequestMethod.GET)
    public String listAll(@RequestParam(value = "currentPage",defaultValue ="1",required = false)int currentPage,Model model) {
       model.addAttribute("pagemsg",stuServiceImpl.findAll(currentPage));//回显分页数据
        return "listsall";
    }

    @RequestMapping(value = "/student/ID")
    public String turnToSearchid(){
        return "searchbyid";
    }
    /*
     * 根据ID查询信息
     * 不存在该条数据时,跳转到提示该ID不存在的页面
     * */
    @RequestMapping(value = "/student")
    public String selectById(Long ID, Model model) throws IOException {
        student = stuServiceImpl.findUserById(ID);

        if(student!=null){
            model.addAttribute("student", student);
            return "list";
        }
        else {
            model.addAttribute("ID", ID);
            return "noexist";}
        }
//     * 根据姓名模糊查询
    @RequestMapping("/name")
    public String turnToSearcname( ) throws IOException {
        return "searchbyname";
    }
//*dynamic
    @RequestMapping(value = "/student/dynamic")
    public String selectByName(@RequestParam(value = "currentPage",defaultValue ="1",required = false)int currentPage,
                               @RequestParam(value ="name" ) String name, Model model )
            throws IOException {
        PageBean<DateTypeChange1> list =stuServiceImpl.findUserByName(currentPage,name);
        String n=name;
        model.addAttribute("pagemsg2",list);//回显分页数据
        model.addAttribute("name", n);
        return "listbyname";
    }

    @RequestMapping(value = "/student/{ID}",method = RequestMethod.DELETE)
    public String delectById(@PathVariable("ID") int ID, Model model) throws Exception {
        int a = stuServiceImpl.deleteUser(ID);
        if (a == 1) {
            message = "数据删除成功";
        } else {
            message = "数据删除失败";
        }

        model.addAttribute("message", message+ID);
        return "deletbyid";
    }
//数据修改前,获取当前这条数据的信息,并将信息放入文本框.
    @RequestMapping(value = "/student/{ID}",method = RequestMethod.POST)
    public ModelAndView turnToUpdate(@PathVariable("ID") Long ID, ModelAndView modelAndView) throws IOException {
        student = stuServiceImpl.findUserById(ID);
           DateTypeChange1 student3=new DateTypeChange1();
           student3=ChangeUtil.dateTypeChange(student);
        modelAndView.addObject("student", student3);
        modelAndView.setViewName("update1");
        return modelAndView;
    }
    //进行数据修改
    //student3对应上面数据查询中的student3.
    @RequestMapping(value = "/student/{ID}",method = RequestMethod.PUT)
        public String updateUser( @PathVariable("ID") Long ID,DateTypeChange1 student3,Model model) throws Exception {
            student=ChangeUtil.LongTypeChange(student3);
            int b=stuServiceImpl.updateUser(student);
//          System.out.println(student3);
            if (b == 1) {
                message = "数据修改成功";
            }
            else {
                message = "数据修改失败";
            }
            model.addAttribute("message",message);
            return "update2";
    }

    @RequestMapping("/new")
    public String turntoinsert() {
        return "insert";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String insert(DateTypeChange1 student4,Model model) throws Exception {

        student=ChangeUtil.LongTypeChange(student4);
        int b=stuServiceImpl.insertUser(student);
        Long a=student.getID();
        model.addAttribute("message2",a);

        return "insertover";
    }

    @RequestMapping("/student/jsontest")
    public String jsontest(Model model) throws IOException {

        student=stuServiceImpl.findUserById(6l);
        model.addAttribute("student",student);
        return "jsontest";
    }

}
