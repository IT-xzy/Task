package com.jin.controller;

import com.jin.dao.ValidateAll;
import com.jin.pojo.Student;
import com.jin.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @ProjectName: task2
 * @Package: com.jin.controller
 * @ClassName: CustomerController
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/9 21:58
 * @UpdateUser:
 * @UpdateDate: 2018/5/9 21:58
 * @UpdateRemark:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;
    private Logger logger = Logger.getLogger(Object.class);

    /**
     * @Description: Select all students.
     * * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @since: 1.0.0
     * @Date: 2018/5/18 16:03
     */
    @RequestMapping("/students")
    public ModelAndView queryStudent() throws Exception {

        List<Student> students = studentService.query();
        ModelAndView modelAndView = new ModelAndView();
        //"students"对应jsp页面中的items="${students }"
        modelAndView.addObject("students", students);
        //jsp页面的名字
        modelAndView.setViewName("students");
        return modelAndView;
    }

    /**
     * @Description: Turn to a jsp to write the select-description.
     * * @param
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:04
     */
    @RequestMapping("/select")
    public String select() throws Exception {

        return "select";
    }

    /**
     * @param object
     * @Description: Select a list of student by an object which includes int id/Long qq/String str.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:06
     */
    @RequestMapping(value = "/student/{object}", method = RequestMethod.GET)
    public String searchStudent(Model model, @PathVariable("object") String object) throws Exception {

        List<Student> students;
        //Pattern类的作用在于编译正则表达式后创建一个匹配模式
        //由于Pattern构造函数是私有的，所以不能直接创建，而是通过他的静态方法compile()创建并注入属性
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        //Matcher类使用Pattern实例提供的模式信息对正则表达式进行匹配
        // pattern对象通过自己的matcher()方法，为传入的字符串创建一个Matcher对象
        //Matcher对象调用matches()方法，使字符串与正则进行匹配，只有完全匹配才返回true
        if (pattern.matcher(object).matches()) {
            if (object.length() > 0 && object.length() < 6) {
                int id = Integer.parseInt(object);
                students = studentService.selectByNumberOrString(id);
            } else {
                Long qq = Long.parseLong(object);
                students = studentService.selectByNumberOrString(qq);
            }

        } else {
            students = studentService.selectByNumberOrString(object);
        }
        model.addAttribute("students", students);
        //通过model将model传递到页面
        //modelAndView.addObject()
        return "searchStudent";
    }

    //通过id、name等六个属性组合查询
    @RequestMapping("/selectBy")
    public String selectBy() {

        return "selectByIdAndSoOn";
    }

    /**
     * @param student
     * @Description: Select by student's id and like student's name/whatType/school/student_id/tutorBro.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:08
     */
    @RequestMapping("/searchByIdOrSomething")
    public String searchByStudent(Model model, Student student) {

        model.addAttribute("students", studentService.selectByLimit(student));
        return "searchStudent";
    }

    /**
     * @param id
     * @Description: Show the details of a student selected by id.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:12
     */
    @RequestMapping("/edit")
    public String editStudent(Model model, Integer id) throws Exception {

        model.addAttribute("student", studentService.getStudentById(id));
        return "studentEdit";
    }

    /**
     * @param student,       submit by users.
     * @param bindingResult, used to collect the objectErrors.
     * @Description: Update student.
     * * @param model
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:14
     */
    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)

    //@Validated标注需要校验的属性，与BindingResult配套属性，并且BindingResult必须在后面，否则就接收不了错误信息了。
    //分组校验，验证的是ValidateAll.class组的
    public String saveUpdate(Model model, @ModelAttribute("student") @Validated(value = ValidateAll.class) Student student,
                             BindingResult bindingResult) throws Exception {
        //BindingResult继承了Error，可以调用Error的hasErrors()方法，返回值是布尔类型，校验有错误的话，返回true
        if (bindingResult.hasErrors()) {
            //遍历错误并输出
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : objectErrors)
                //由于properties（本身不支持中文）中的信息是中文，所以在配置错误信息文件的时候设置了字符集
                //所以用logger.info(objectError.getDefaultMessage())会输出乱码
                //可以先用ISO-8859-1打乱再用UTF-8生成。如果想不那么麻烦，则不要在错误信息文件中输入中文
                logger.info(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"), "UTF-8"));
            model.addAttribute("objectErrors", objectErrors);
            return "editError";
        }
        studentService.updateStudent(student);
        return "insertFinish";
    }

    /**
     * @Description: Delete by id.
     * * @param id
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:20
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) throws Exception {

        studentService.deleteStudent(id);
        return "redirect:students";
    }

    /**
     * @Description: Get a jsp.
     * * @param
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:27
     */
    @RequestMapping("/add")
    public String add() {

        return "insert";
    }

    /**
     * @Description: Insert a student.
     * * @param student, submit by users.
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:27
     */
    @RequestMapping("/addStudent")
    public String insert(Student student) throws Exception {

        studentService.insertStudent(student);
        //重定向到query查询列表，其实是做了两次request
        return "redirect:students";
    }

    /**
     * @Description: Turn to this url when selecting nothing.
     * * @param
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/18 16:29
     */
    @RequestMapping("/nothing")
    public String noSelectResult() {

        return "noSelectResult";
    }
}
