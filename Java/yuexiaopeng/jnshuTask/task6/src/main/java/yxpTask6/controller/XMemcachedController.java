package yxpTask6.controller;

import net.rubyeye.xmemcached.XMemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;
import yxpTask6.util.TaskMemcachedUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Controller
public class XMemcachedController
{
    @Autowired
    private StudentService studentService;
    @Autowired
    TaskMemcachedUtil taskMemcachedUtil;

    @RequestMapping("/memcached/all")
    public String allMemcachedController( Integer pageNum, Model model) throws Exception
    {
        int pageSize=180;
        if(pageNum==null||pageNum<=0) {
            pageNum = 1;
        }
        //存入缓存的学生数据的长度，用list长度来衡量；
        List listIndex=taskMemcachedUtil.getIndexListMemcached();
        //根据页码及数量从数据库查询到学生列表
        List<Student> student=taskMemcachedUtil.getPageListMemcached(pageNum,pageSize);
//        System.out.println(student);

        //返回值的判断；需要判断末页及上一页，下一页；
        Integer pageHome=1;
        Integer pageFinal=listIndex.size()/pageSize+1;
        if(listIndex.size()%pageSize==0){pageFinal=listIndex.size()/pageSize;}
        Integer pageNext=pageNum+1;
        if(pageNum==pageFinal){pageNext=pageFinal;}
        Integer pageLast=pageNum-1;
        if(pageLast==0){pageLast=pageNum;}
        model.addAttribute("student",student);
        //将页码进行包装成list传入view
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageHome",pageHome);
        model.addAttribute("pageLast",pageLast);
        model.addAttribute("pageNext",pageNext);
        model.addAttribute("pageFinal",pageFinal);

        return "memcachedHome";
    }
    //进行学生数据的删除；
    @RequestMapping(value = "/memcached/{studyId}",method = RequestMethod.DELETE)
    public void deleteMemcachedController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        taskMemcachedUtil.deleteStudentMemcache(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/memcached/all");
    }
    //学生数据的修改
    @RequestMapping(value="/memcached/{studyId}",method = RequestMethod.GET)
    public String updateMemcachedController(Student student,Model model)
    {
        Student student1=taskMemcachedUtil.getStudentMemcache(student.getStudyId());
        model.addAttribute("student",student1);
        return "memcachedUpdate";
    }
    //数据库更新
    @RequestMapping(value="/memcached/upd",method = RequestMethod.POST)
    public void updateMemcachedController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        //学生数据要求为修改后的数据；
        taskMemcachedUtil.updateStudentMemcache(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/memcached/all");
    }
    //学生数据的增加
    @RequestMapping(value="/memcached/ins",method = RequestMethod.PUT)
    public void insertMemcachedController(Student student, HttpServletResponse response,
                                        HttpServletRequest request) throws Exception
    {
        taskMemcachedUtil.addStudentMemcache(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/memcached/all");
    }
    @RequestMapping("/memcached/insert")
    public String insertMemcachedController()
    {
        return "memcachedInsert";
    }
    @RequestMapping("/memcached/cre")
    public void createMemcachedController(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception
    {
        taskMemcachedUtil.createAllStudentMemcache();
        taskMemcachedUtil.createIndexListMemcached();
        String url=request.getContextPath();
        response.sendRedirect(url+"/memcached/all");
    }
    @RequestMapping("/memcached/mysql")
    public void memcachedToMysqlController(HttpServletRequest request,
                                           HttpServletResponse response) throws Exception
    {
        taskMemcachedUtil.memcachedToMysql();
        String url=request.getContextPath();
        response.sendRedirect(url+"/memcached/all");
    }
}
