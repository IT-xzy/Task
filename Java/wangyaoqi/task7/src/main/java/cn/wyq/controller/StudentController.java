package cn.wyq.controller;

import cn.wyq.pojo.Student;
import cn.wyq.service.StudentService;
import cn.wyq.util.AliOOS;
import com.aliyun.oss.OSSClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;
    ModelAndView modelAndView = new ModelAndView();

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/u/students",method = RequestMethod.GET)
    public ModelAndView listStudent(){
        List<Student> students= studentService.list();
//        int total = studentService.total();
//        page.caculateLast(total);
        modelAndView.addObject("students",students);
//        modelAndView.addObject("page",page);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @RequestMapping(value = "/u/student",method = RequestMethod.POST)
    public ModelAndView addStudent(MultipartFile file,Student student,HttpServletRequest request){
        String orignalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(orignalFilename);
        String path = request.getSession().getServletContext().getRealPath("/img/photo");
        logger.info(path);
        logger.info(fileName);

        try{
            File targetFile = new File(path,fileName);
            FileUtils.writeByteArrayToFile(targetFile,file.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

        AliOOS aliOOS = new AliOOS();
        aliOOS.upload(path+"/"+fileName,fileName);

        String url = "https://wyqaliyun.oss-cn-qingdao.aliyuncs.com/"+fileName;
        student.photo = url;
        studentService.addStudent(student);
        System.out.println("增加数据");
        redisTemplate.delete("studentList");
        modelAndView.setViewName("redirect:/u/students");
        System.out.println("跳转\n");
        return modelAndView;
    }

    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        System.out.println("删除数据\n");
        redisTemplate.delete("studentList");
        modelAndView.setViewName("redirect:/u/students");
        return modelAndView;
    }

    @RequestMapping(value = "/u/session",method = RequestMethod.DELETE)
    public ModelAndView loginout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.invalidate();
        System.out.println("退出登录");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            break;
        }
        System.out.println("退出成功");
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

//    @RequestMapping(value = "/u/student/image",method = RequestMethod.POST)
//    public ModelAndView uploadImage(MultipartFile file){
//        String orignalFilename = file.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(orignalFilename);
//        try{
//            File targetFile = new File("E:/temp/",fileName);
//            FileUtils.writeByteArrayToFile(targetFile,file.getBytes());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        modelAndView.addObject("fileName",fileName);
//        modelAndView.setViewName("redirect:/u/students");
//        return modelAndView;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.POST)
//    public ModelAndView updateStudent(Student student){
//        studentService.updateStudent(student);
//        modelAndView.setViewName("redirect:/students");
//        return modelAndView;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/u/student/{id}",method = RequestMethod.GET)
//    public ModelAndView showStudent(@PathVariable("id") int id){
//        Student student=studentService.getById(id);
//        modelAndView.addObject("student",student);
//        modelAndView.setViewName("editStudent");
//        return modelAndView;
//    }
}
