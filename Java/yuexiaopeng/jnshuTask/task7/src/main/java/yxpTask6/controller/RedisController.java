package yxpTask6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yxpTask6.pojo.Student;
import yxpTask6.util.TaskRedisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class RedisController
{
    @Autowired
    TaskRedisUtil taskRedisUtil;
    @RequestMapping("/redis/all")
    public String allRedisController( Integer pageNum, Model model) throws Exception
    {
        int pageSize=5;

        //存入缓存的学生数据的长度，用list长度来衡量；
        List listIndex=taskRedisUtil.getAllIndexRedis();
        //限定传入的页码值；
        if(pageNum==null||pageNum<=0||pageNum>listIndex.size()) {
            pageNum = 1;
        }
        //根据页码及数量从数据库查询到学生列表
        List<Student> student=taskRedisUtil.pageStudentRedis(pageNum,pageSize);
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
//
        return "redisHome";
    }
    //进行学生数据的删除；
    @RequestMapping(value = "/redis/{studyId}",method = RequestMethod.DELETE)
    public void deleteMemcachedController(Student student, HttpServletResponse response,
                                          HttpServletRequest request) throws Exception
    {
        taskRedisUtil.deleteStudentRedis(student.getStudyId());
        String url=request.getContextPath();
        response.sendRedirect(url+"/redis/all");
    }
    //学生数据的修改
    @RequestMapping(value="/redis/{studyId}",method = RequestMethod.GET)
    public String updateMemcachedController(Student student,Model model)
    {
        Student student1=taskRedisUtil.getByStudyIdRedis(student.getStudyId());
        model.addAttribute("student",student1);
        return "redisUpdate";
    }
    //数据库更新
    @RequestMapping(value="/redis/upd",method = RequestMethod.POST)
    public void updateMemcachedController(Student student, HttpServletResponse response,
                                          HttpServletRequest request) throws Exception
    {
        taskRedisUtil.updateStudentRedis(student);
        String url=request.getContextPath();
        response.sendRedirect(url+"/redis/all");
    }
    //学生数据的增加
    @RequestMapping(value="/redis/ins",method = RequestMethod.PUT)
    public void insertMemcachedController(Student student, HttpServletResponse response,
                                          HttpServletRequest request) throws Exception
    {
        //查询id是否存在；
        Student student1=taskRedisUtil.getByStudyIdRedis(student.getStudyId());
        if(student1==null)
        {
            taskRedisUtil.addStudentRedis(student);
        }
        String url=request.getContextPath();
        response.sendRedirect(url+"/redis/all");
    }
    @RequestMapping("/redis/insert")
    public String insertMemcachedController()
    {
        return "redisInsert";
    }

    @RequestMapping("/redis/cre")
    public void createMemcachedController(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception
    {
        taskRedisUtil.creatAllIndexRedis();
        taskRedisUtil.creatAllStudentRedis();
        String url=request.getContextPath();
        response.sendRedirect(url+"/redis/all");
    }
    @RequestMapping("/redis/mysql")
    public void memcachedToMysqlController(HttpServletRequest request,
                                          HttpServletResponse response) throws Exception
    {
        taskRedisUtil.redisToMysql();
        String url=request.getContextPath();
        response.sendRedirect(url+"/redis/all");
    }
}
