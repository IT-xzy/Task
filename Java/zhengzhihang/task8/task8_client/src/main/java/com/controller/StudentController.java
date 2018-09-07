package com.controller;
import com.Tools.SwitchService;
import com.pojo.Student;
import com.service.Service0;
import com.service.Service1;
import com.service.Service2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.List;


@Controller
public class StudentController {

    @Resource
    private SwitchService switchService;


    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView queryAll(){
        Service0 imStudentService=switchService.getService0();
        ModelAndView modelAndView=new ModelAndView();
        List<Student> studentList=imStudentService.findStudent();
        modelAndView.addObject("students",studentList);
        modelAndView.setViewName("student");
        return modelAndView;
    }

    //这个方法是用来添加的。
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView add(Student student){
        Service0 imStudentService=switchService.getService0();
        ModelAndView modelAndView=new ModelAndView();
        imStudentService.inputStudent(student);
        student.setCreate_at(System.currentTimeMillis());
        modelAndView.setViewName("redirect:/students");
        return  modelAndView;
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ModelAndView findStudentById(@PathVariable("id")long id,
                                        @RequestParam(value = "name",required = false) String name,
                                        @RequestParam(value="age",required = false) String age                                   ) {
        ModelAndView modelAndView = new ModelAndView();
        Service0 imStudentService=switchService.getService0();
        Student student=imStudentService.findStudentById(id);
        modelAndView.addObject("object",student);
        if(name==null && age==null ) {
            //编辑的方法体
            modelAndView.setViewName("edit");
        } else {
            //查询视图的方法体
            if (age==null){
                //查询方法体：json页面
                modelAndView.setViewName("query");
            }else {
                //查询方法体: jsp页面
                modelAndView.setViewName("query1");
            }
        }
        return  modelAndView;
    }

    //更新一个用户student
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView update(Student student ){
        Service0 imStudentService=switchService.getService0();
        ModelAndView modelAndView = new ModelAndView();
        imStudentService.replayStudent(student);
        student.setUpdate_at(System.currentTimeMillis());
        modelAndView.setViewName("redirect:/students");
        return  modelAndView;
        }

    //删除一个用户
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView delect(@PathVariable("id")long id){
        Service0 imStudentService=switchService.getService0();
        ModelAndView modelAndView=new ModelAndView();
        imStudentService.outputStudentById(id);
        modelAndView.setViewName("redirect:/students");
        return modelAndView;
    }



}
