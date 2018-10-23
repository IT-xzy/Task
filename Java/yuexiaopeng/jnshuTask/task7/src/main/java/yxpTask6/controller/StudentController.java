package yxpTask6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/*
* 标准模式的控制器
* */
@Controller
public class StudentController
{
    @Autowired
    private StudentService studentService;
    @RequestMapping("/student/all")
    public String allStudentController(Integer pageNum,
                                        Model model)
    {
//        Map<String,Object> map=studentService.selectAllStudentMap();
        //所有用户信息
        List stu=studentService.selectAllStudyId();
        //根据条件进行分页的list
        List<Student>  student=new Vector<>();
        Student student1;
        int pageSize=5;
        //保证pagenum有默认值；不符合条件的情况返回首页；
        if(pageNum==null||pageNum<=0||pageNum>stu.size()) {
            pageNum = 1;
        }
            //分页数据添加进集合
            int start = pageNum * pageSize - pageSize;
            int end = start + pageSize;
            if(end>=stu.size()){end=stu.size();}
            for (int i = start; i < end; i++)
            {
                student1=studentService.selectByStudyId(stu.get(i).toString());
                student.add(student1);
            }
        //返回值的判断；需要判断末页及上一页，下一页；
        Integer pageHome=1;
        Integer pageFinal=stu.size()/pageSize+1;
        if(stu.size()%pageSize==0){pageFinal=stu.size()/pageSize;}
        Integer pageNext=pageNum+1;
        if(pageNum==pageFinal){pageNext=pageFinal;}
        Integer pageLast=pageNum-1;
        if(pageLast==0){pageLast=pageNum;}
        model.addAttribute("student",student);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageHome",pageHome);
        model.addAttribute("pageLast",pageLast);
        model.addAttribute("pageNext",pageNext);
        model.addAttribute("pageFinal",pageFinal);
        return "studentHome";
    }
    //进行学生数据的删除；
    @RequestMapping(value = "/student/{studyId}",method = RequestMethod.DELETE)
    public void deleteStudentController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        studentService.deleteStudent(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/student/all");
    }
    //学生数据的修改
    @RequestMapping(value="/student/{studyId}",method = RequestMethod.GET)
    public String updateStudentController(Student student,Model model)
    {
        Student student1=studentService.selectStudent(student);
        model.addAttribute("student",student1);
        return "studentUpdate";
    }
    //数据库更新
    @RequestMapping(value="/student/upd",method = RequestMethod.POST)
    public void updateStudentController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        studentService.updateStudent(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/student/all");
    }
    //学生数据的增加
    @RequestMapping(value="/student/ins",method = RequestMethod.PUT)
    public void insertStudentController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        studentService.insertStudent(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/student/all");
    }
    @RequestMapping("/student/insert")
    public String insertStudentController()
    {
        return "studentInsert";
    }
}
