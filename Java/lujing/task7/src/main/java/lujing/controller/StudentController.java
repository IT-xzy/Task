package lujing.controller;

import java.util.List;

import lujing.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import lujing.pojo.StudentCustom;
import lujing.service.StudentService;


@Controller
@RequestMapping("/student")

public class StudentController {
    
    @Autowired
    private StudentService studentService;
    @Autowired
    FileUtils FileUtils;
    //跳转到新增页面
    @RequestMapping(value = "/newpage", method = RequestMethod.GET)
    public String addstudent(Model model) {
        StudentCustom studentCustom = studentService.findStudentById(218547);
        model.addAttribute("studentCustom", studentCustom);
        return "student/addstudent";
    }
    
    /**
     * @param studentCustom 接收页面的学生信息
     * @param picFile       接收页面的图片
     * @return
     */
    // 提交新增学生信息，value是url地址，设置request的方法
    @RequestMapping(value = "/studentOne", method = RequestMethod.POST)
    public String addStudentSubmit(StudentCustom studentCustom, MultipartFile picFile) {
        //判断picFile的状态
        if (picFile != null && picFile.getSize() > 0) {
            //调用第三方的上传接口，返回服务器的图片路径
            String newFilePath = FileUtils.uploadxx(picFile);
            //将路径保存在该学生信息中
            studentCustom.setPic(newFilePath);
        }
        //存入该学生信息
        studentService.addStudent(studentCustom);
        return "redirect:studentslist";
    }
    
    /**
     * 显示所有学生列表
     * @return
     */
  
    @RequestMapping(value = "/studentslist", method = RequestMethod.GET)
    public ModelAndView queryStudent() {
        ModelAndView modelAndView = new ModelAndView();
        List<StudentCustom> studentlist = studentService.findStudentList(null);
        
        modelAndView.addObject("studentlist", studentlist);
        // 将模型数据填充到视图，逻辑视图名
        modelAndView.setViewName("student/studentlist");
        return modelAndView;
    }
    
    // 点击修改按钮，跳转到修改页面，并查询id对应的学生信息填充到表单中
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editstudent(Model model, @PathVariable("id") Integer id) {
        StudentCustom studentCustom = studentService.findStudentById(id);
        
        if (null != studentCustom.getPic() && studentCustom.getPic().length() > 0) {
            String openPath = FileUtils.getUrl(studentCustom.getPic());
            model.addAttribute("openPath",openPath);
        }
        
        model.addAttribute("student", studentCustom);
        // 返回字符串类型，字符串为jsp页面的逻辑视图名
        return "student/editstudent";
    }
    
    //修改提交
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editStudentSubmit(@PathVariable("id") Integer id, StudentCustom studentCustom, MultipartFile picFile) {
        //如果picFile不为空，执行上传
        if (null != picFile && picFile.getSize() > 0) {
            String newFilePath = FileUtils.uploadxx(picFile);
            //得到原图片路径
            String oldFilePath = studentCustom.getPic();
            //如果原图片不为空，删除原图片
            if (null != oldFilePath && oldFilePath.length() > 0) {
                FileUtils.deleteObject(oldFilePath);
            }
            //set新的图片路径
            studentCustom.setPic(newFilePath);
        }
        //更新信息
        studentService.updateStudent(id, studentCustom);
        return "redirect:studentslist";
    }
    
    
    /**
     * 删除按钮，执行删除学生方法
     *
     * @param id
     * @return
     */
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("id") Integer id) {
        
        //删除服务器图片
        String oldFilePath = studentService.findStudentById(id).getPic();
        
        if (null != oldFilePath && !oldFilePath.equals("")) {
            FileUtils.deleteObject(oldFilePath);
        }
        //删除数据库信息
        studentService.deleteStudent(id);
        return "redirect:studentslist";
    }
    
    /**
     * @param
     * @return
     */
    @RequestMapping("/json1")
    public @ResponseBody
    List<StudentCustom> testjson() {
        
        List<StudentCustom> studentlist = studentService.findStudentList(null);
        
        return studentlist;
        
    }
    
}
