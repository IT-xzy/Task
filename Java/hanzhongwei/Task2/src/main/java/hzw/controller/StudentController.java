package hzw.controller;

import hzw.model.Student;
import hzw.service.StudentSerivce;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//使用@Controller来表示这个类是一个handler控制器
@Controller
@RequestMapping("")
public class StudentController {

    @Autowired
    StudentSerivce studentSerivce;
    private Logger logger = Logger.getLogger(String.valueOf(StudentController.class));

    //一般建议URL和方法名一致
    //@RequestMapping实现对student方法和url进行映射，一个方法对应一个url
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView listStudent(){
        logger.info("开始全体查询");
        ModelAndView mav = new ModelAndView();
        List<Student> list = studentSerivce.getAll();
        mav.addObject("stu",list);
        mav.setViewName("listStudent");
        logger.info("查询全体时mav："+mav);
        return mav;
    }

    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public ModelAndView addStudent(Student student){
        logger.info("开始添加");
        studentSerivce.addStu(student);
        logger.info("添加的数据是："+student);
        ModelAndView mav = new ModelAndView("redirect:/student");
        logger.info("添加的mav是："+mav);
        return mav;
    }

    @RequestMapping(value = "/student/{stuId}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(Student student){
        logger.info("开始删除");
        studentSerivce.deleteStu(student.getStuId());
        ModelAndView mav = new ModelAndView("redirect:/student");
        logger.info("删除的mav是："+mav);
        return mav;
    }

    @RequestMapping(value = "/student/{stuId}",method = RequestMethod.POST)
    public ModelAndView updateStudent(Student student){
        logger.info("开始 更新");
        studentSerivce.updateStu(student);
        ModelAndView mav = new ModelAndView("redirect:/student");
        logger.info("更新的mav是："+mav);
        return mav;
    }

    @RequestMapping(value = "/student/insert/{stuId}",method = RequestMethod.GET)
    public ModelAndView getId(Student student){
        logger.info("开始按id查询");
        Student stu = studentSerivce.getId(student.getStuId());
        logger.info("查询到的数据是："+stu);
        if (stu != null){
            ModelAndView mav = new ModelAndView("updateStudent");
            mav.addObject("s",stu);
            logger.info("查询的mav是："+mav);
            return mav;
        }else {
            ModelAndView mav = new ModelAndView("error");
            return mav;
        }

    }

    @RequestMapping(value = "/student/select",method = RequestMethod.POST)
    public ModelAndView select(HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("id"));
        Student student = studentSerivce.getId(id);
        if (student != null){
            ModelAndView modelAndView =new ModelAndView("updateStudent");
            modelAndView.addObject("s",student);
            return  modelAndView;
        }else {
            ModelAndView mav = new ModelAndView("error");
            return mav;
        }

    }
    /**
     * Json-taglib
     */
    @RequestMapping(value = "/jsonlist",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String jsonListAll(Model model){
        List<Student> students = studentSerivce.getAll();
        model.addAttribute("stu",students);
        logger.info("json-list-model:"+model);
        return "jsonList";
    }
    @RequestMapping(value = "/jsonget/{stuId}",method = RequestMethod.GET)
    public String jsonGetId(@PathVariable("stuId")long stuId,Model model){
        Student student = studentSerivce.getId(stuId);
        model.addAttribute("s",student);
        logger.info("json-getid-model"+model);
        return "jsonListid";
    }

    /**
     * 注解的方式返回json
     * @ResponseBody
     */
    @RequestMapping(value = "json/json1",method = RequestMethod.GET)
    public @ResponseBody JSONObject jsonDemo1(){
        JSONObject jsonObject = new JSONObject();
        List<Student> list = studentSerivce.getAll();
        jsonObject.put("stu",list);
        logger.info("jsonObject::"+jsonObject);
        return jsonObject;
    }

    @RequestMapping(value = "/json/select/{stuId}",method = RequestMethod.GET)
    @ResponseBody
    public Student getIdStu(Student student){
        Student stu=studentSerivce.getId(student.getStuId());
        logger.info("id查询"+stu);
        return stu;
    }

    @RequestMapping(value = "/json/insert",method = RequestMethod.PUT)
    @ResponseBody
    public Student addStu(Student student){
        Student stu = new Student();
        stu.setStuName("笑哈哈");
        stu.setStuQQ(43242);
        stu.setStuType("jia");
        stu.setStuNum(433);
        studentSerivce.addStu(stu);
        logger.info("增加的"+stu);
        return stu;
    }

    @RequestMapping(value = "/json/delete/{stuId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Student delete(Student student){
        Student stu = studentSerivce.getId(student.getStuId());
        studentSerivce.deleteStu(stu.getStuId());
        logger.info("删除的"+stu);
        return stu;
    }

    @RequestMapping(value = "/json/update/{stuId}",method = RequestMethod.POST)
    @ResponseBody
    public Student update(Student student){
        Student stu = studentSerivce.getId(student.getStuId());
        stu.setStuName("小王");
        stu.setStuNum(222);
        studentSerivce.updateStu(stu);
        logger.info("更新的"+stu);
        return stu;
    }

    @RequestMapping(value = "/json/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> listStu(){
        List<Student> stu = studentSerivce.getAll();
        logger.info("全体的的"+stu);
        return stu;
    }
}
