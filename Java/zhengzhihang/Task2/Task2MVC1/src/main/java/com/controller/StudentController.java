package com.controller;

import com.pojo.Student;
import com.service.IFStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    Logger logger =Logger.getLogger(StudentController.class);

    @Resource
    //用自动注入显示找不到这个bean，可是能运行。 很奇怪，以后再解决。
    private IFStudentService ifStudentService;
    //指定URL地址
//    @RequestMapping(value = {"/user/findStudent.action","/test"})
//    private String findStudent(Student student, Model model){
//        List<Student> studentList=ifStudentService.findStudent();
//        model.addAttribute("studentList",studentList);
//        return "/test" ;
//    }

    //这个方法是查询全表。并且在tomcat将这个URL设置成默认访问地址
    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public ModelAndView queryAll(){

        ModelAndView modelAndView=new ModelAndView();
        List<Student> studentList=ifStudentService.findStudent();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("Student");
        logger.info("test");
        return modelAndView;
    }
    //这个方法是用来添加的。
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ModelAndView add(Student student){

        //使用一个modelAndView,装执行了业务层逻辑的数据
        ModelAndView modelAndView=new ModelAndView();
        //用一个布林值去装业务层执行的情况，方便进行页面跳转判断
        boolean operation = ifStudentService.inputStudent(student);
        //业务层执行了，那么重定向回到主页面，否则跳转到错误页面
        if(operation){
            modelAndView.setViewName("redirect:/studentList");
        }else {
            modelAndView.setViewName("error");
        }
        //返回modelAndView
        return  modelAndView;
    }

    /*
    查询或者编辑一个学生，因为查询和更新指向的是同一个URL地址，更新前需要编译。
    所以这里把查询和编译放在一起做。
    RequestMapping里面设置了一个url的地址，这个是符合REST风格的，{id}对应的是数据表的id，
    在Student.jsp文件中，action="Student/${s.id}",这个id对应的就是这个ID
    */
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public ModelAndView findStudent
    //得到URL的id值，并且将ID作为值传入id，所以PathVariable是用来修饰int 对应的值
    (@PathVariable("id")int id,
     /*
     如果不是编译和查询整合的话，那么@RequestParam可有可无
     使用了@RequestParam里面对应的value值需要在jsp文件里面做相应的编译
     value的值判定可以为false，所以如果name为空的话，也能运行，但是在方法体里面进行需要的逻辑编写就行。
     */
     @RequestParam(value = "name",required = false) String name)
    {
        ModelAndView modelAndView = new ModelAndView();
        /*
        判定：Student里面有两个from表单，一个查询表单一个编辑表单，
        唯一的区别是查询表单多input了一个name，所以在if逻辑进行一个值判定，
        有一个name，就证明这个按钮是跳转查询页面，没有就是挑战编辑页面，
        进而在编辑界面进行数据的更新。
         */
        if(name==null) {//编辑视图的方法体
            //获得业务层接口，调用查询数据库函数
            Student student=ifStudentService.findStudentById(id);
            if(student !=null){
                //将数据传输给modelAndView
                modelAndView.addObject("object",student);
                //将数据转换成视图
                modelAndView.setViewName("edit");
            }else {
                modelAndView.setViewName("error");
            }
        }else {
           //查询视图的方法体
            Student student =ifStudentService.findStudentById(id);
            if (student !=null){
                modelAndView.addObject("object",student);
                modelAndView.setViewName("query");
            }else {
                modelAndView.setViewName("error");
            }
        }
        return  modelAndView;

    }
    //更新一个用户student
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView update(/*Student student*/int id, String age,String name,String sex,String school){
        logger.info("id==={}"+id);
        logger.info("age=={}"+age);
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setSex(sex);
        student.setSchool(school);

        //做一个逻辑判断，防止输入空值。==
        if (!(student.getAge().equals("")) || (student.getName().equals(""))){
            boolean operation=ifStudentService.replayStudent(student);
            if (operation){
                modelAndView.setViewName("redirect:/studentList");//转发
            }else {
                modelAndView.setViewName("error");
            }
        }else {
            modelAndView.setViewName("error");
        }
        return  modelAndView;
        }

    //删除一个用户
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView delect(
            //把URL上的id字段拿到这里用，然后赋值给引用名id
            @PathVariable("id")int id){
        ModelAndView modelAndView=new ModelAndView();
        //判断业务层逻辑执行情况，用来跳转页面
        boolean operation = ifStudentService.outputStudentById(id);
        if (operation){
            modelAndView.setViewName("redirect:/studentList");
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

}
