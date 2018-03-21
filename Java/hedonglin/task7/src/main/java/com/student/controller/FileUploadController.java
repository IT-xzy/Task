package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.util.CookieUtil;
import com.student.util.QiNiuUtil;
import com.student.util.UpLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Resource
    private StudentService studentService;
    @Resource
    private QiNiuUtil qiNiuUtil;

    private  final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile file,String sex,String major,String qq,String intro) throws IOException {
        log.info("file:{}",file);
        if (!file.isEmpty()) {
            //上传文件路径
//            String path = request.getServletContext().getRealPath(description+"/images/");
            String key = UUID.randomUUID() + "/images/";
            //上传文件名
            InputStream filename = file.getInputStream();
//            byte[] bbuf = new byte[1024];
//            int hasRead = 0;
//            while ((hasRead = filename.read(bbuf)) > 0) {
//                System.out.println(new String(bbuf, 0, hasRead));
//            }
            qiNiuUtil.uploadFile(filename,key);
            String imageKey = "http://p5o7nv9t5.bkt.clouddn.com/" + key;
            String token = CookieUtil.getCookieValueByName(request, "token");
            log.info("filename:{}，image Key：{}，token:{}",filename,imageKey,token);
            try {
                Long id=studentService.getIdByTokey(token);
                Student student=studentService.selectByPrimaryKey(id);
                log.info("从token里面拿出来的id是：{}",id);
                student.setHeadPortrait(imageKey);
                student.setSex(sex);
                student.setIntro(intro);
                student.setMajor(major);
                student.setQq(qq);
                studentService.updateByPrimaryKey(student);
                filename.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "yes";

        }
           return "";
    }



    @RequestMapping(value = "/uploadForm",method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }
}
