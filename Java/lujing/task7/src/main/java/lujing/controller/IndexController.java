package lujing.controller;

import lujing.pojo.GoodStudent;
import lujing.pojo.Learn;
import lujing.pojo.Professions;
import lujing.serviceimpl.GoodStudentServiceImpl;
import lujing.serviceimpl.IndexServiceImpl;
import lujing.serviceimpl.JobListServiceImpl;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.util.List;

/**
 * @author LUJING
 * Create_at 2017/12/28 12:35
 */
@Controller


public class IndexController {
    @Autowired
    IndexServiceImpl LearnServiceImpl;
    @Autowired
    GoodStudentServiceImpl goodStudentServiceImpl;
    @Autowired
    JobListServiceImpl jobListServiceImpl;
    
    @RequestMapping("/index")
    public String learnPath(Model model) {
        List<Learn> all = LearnServiceImpl.selectLearnALL();
        int countStudying = goodStudentServiceImpl.countStudying();
        int countWorking = goodStudentServiceImpl.countWorking();
        List<GoodStudent> goodStudents = goodStudentServiceImpl.getGoodStudents();
        
        //获取所有“学习路径”
        model.addAttribute("allLearn", all);
        
        //获取在学总人数
        model.addAttribute("countStudying", countStudying);
        
        //获取正在工作人数
        model.addAttribute("countWorking", countWorking);
        
        //获取优秀学生名单
        model.addAttribute("goodStudents", goodStudents);
        
        return "jnshu";
    }
    
    @RequestMapping("/u/joblist")
    public String joblist(Model Model) {
       List<Professions> joblist = jobListServiceImpl.findJobLists();
       //获得职业清单
        Model.addAttribute("joblist",joblist);
        
        return "joblist";
    }
    
    @RequestMapping("/u/cooperation")
    public String cooperation(){
        return "cooperation";
    }
    
    @RequestMapping(value = "/test",method = RequestMethod.POST )
    public void testaaa( String text ){
        System.out.println(text);
        
    }
    @RequestMapping("/test2")
    public void test2(HttpServletResponse response) throws IOException {
        
        response.getWriter().write("<script>alert(成功)</script>");
        
    }
}
